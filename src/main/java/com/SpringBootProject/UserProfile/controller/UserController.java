package com.SpringBootProject.UserProfile.controller;

import com.SpringBootProject.UserProfile.bean.User;
import com.SpringBootProject.UserProfile.userDao.UserDaoService;
import jakarta.validation.Valid;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import java.net.URI;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@RestController
public class UserController {

    private MessageSource messageSource;
    UserController(MessageSource messageSource){
        this.messageSource = messageSource;
    }

    @GetMapping(path="users/all")
    public List<User> getAllUsers(){
        return  UserDaoService.findAllUsers();

    }

    @GetMapping(path="/users/getuserById/{id}")

//    EntityModel --
//    WebMVCLinkBuilder -- to add link
    public EntityModel<User> getuserByid(@PathVariable int id){
        User getUser= UserDaoService.findUserById(id);
        if(getUser==null){
            throw new UserNotFoundException("id: "+id);
        }
        EntityModel<User> entityModel = EntityModel.of(getUser); //creating an entityModel for getuser.
        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).getAllUsers());
        entityModel.add(link.withRel("all-users"));
        return entityModel;
    }
    @DeleteMapping(path="/users/getuserById/{id}")
    public void deleteUserById(@PathVariable int id){
        UserDaoService.deleteUserById(id);


    }

    @PostMapping("/users/createUser")
    public ResponseEntity<User> CreateUser(@Valid @RequestBody User user){

        User saveduser = UserDaoService.createuser(user);
       URI location = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("{/id}")
                .buildAndExpand(user.getId())
                .toUri();
       return ResponseEntity.created(location).build();


    }

    @GetMapping(path="users/hello-internationalized")
    public String getAllUsersInternationalized(){
        Locale locale= LocaleContextHolder.getLocale();
        return  messageSource.getMessage("good.morning.message",null,"Default Message", locale);

    }


}
