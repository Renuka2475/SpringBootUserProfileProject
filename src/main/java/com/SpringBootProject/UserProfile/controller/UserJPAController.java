package com.SpringBootProject.UserProfile.controller;

import com.SpringBootProject.JPA.PostJPARepository;
import com.SpringBootProject.JPA.UserJPARepository;

import com.SpringBootProject.UserProfile.bean.Post;
import com.SpringBootProject.UserProfile.bean.User;
import com.SpringBootProject.UserProfile.userDao.UserDaoService;
import jakarta.validation.Valid;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserJPAController {
    private UserJPARepository userJPARepository;
    private PostJPARepository postJPARepository;

    public UserJPAController(UserJPARepository userJPARepository, PostJPARepository postJPARepository) {
       this.userJPARepository=userJPARepository;
       this.postJPARepository=postJPARepository;
    }

    @GetMapping(path="/jpa/users/all")
    public List<User> getAllUsers(){
        return  userJPARepository.findAll();

    }

    @GetMapping(path="/jpa/users/getuserById/{id}")

//    EntityModel --
//    WebMVCLinkBuilder -- to add link
    public EntityModel<User> getuserByid(@PathVariable int id){
        Optional<User> getUser= userJPARepository.findById(id);
        if(getUser.isEmpty()){
            throw new UserNotFoundException("id: "+id);
        }
        EntityModel<User> entityModel = EntityModel.of(getUser.get()); //creating an entityModel for getuser.
        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).getAllUsers());
        entityModel.add(link.withRel("all-users"));
        return entityModel;
    }
    @DeleteMapping(path="/jpa/users/getuserById/{id}")
    public void deleteUserById(@PathVariable int id){
        Optional<User> getUser= userJPARepository.findById(id);
        userJPARepository.deleteById(id);


    }

    @PostMapping("/jpa/users/createUser")
    public ResponseEntity<User> CreateUser(@Valid @RequestBody User user){

        User saveduser = userJPARepository.save(user);
       URI location = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("{/id}")
                .buildAndExpand(user.getId())
                .toUri();
       return ResponseEntity.created(location).build();


    }

    @GetMapping(path="/jpa/users/{id}/post")
    public List<Post> retrievePostForUser(@PathVariable int id){
        Optional<User> postUser= userJPARepository.findById(id);
        if(postUser.isEmpty()){
            throw new UserNotFoundException("id: "+id);
        }

        return postUser.get().getPosts();
    }

    @PostMapping("/jpa/users/createUser/{id}/Post")
    public ResponseEntity<User> CreatePostForUser(@PathVariable int id,@Valid @RequestBody Post postUser){

        Optional<User> isUserPresent = userJPARepository.findById(id);

        if(isUserPresent.isEmpty()){
            throw new UserNotFoundException("id="+id);
        }
        postUser.SetUser(isUserPresent.get());

        Post saveduser = postJPARepository.save(postUser);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("{/id}")
                .buildAndExpand(saveduser.getUser())
                .toUri();
        return ResponseEntity.created(location).build();


    }




}
