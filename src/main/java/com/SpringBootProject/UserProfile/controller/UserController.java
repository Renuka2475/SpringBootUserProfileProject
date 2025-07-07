package com.SpringBootProject.UserProfile.controller;

import com.SpringBootProject.UserProfile.bean.User;
import com.SpringBootProject.UserProfile.userDao.UserDaoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @GetMapping(path="users/all")
    public List<User> getAllUsers(){
        return  UserDaoService.findAllUsers();

    }


}
