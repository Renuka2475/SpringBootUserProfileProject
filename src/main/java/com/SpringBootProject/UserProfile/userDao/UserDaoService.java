package com.SpringBootProject.UserProfile.userDao;

import com.SpringBootProject.UserProfile.bean.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoService {


    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User(1,"Renuka", LocalDate.now().minusYears(24)));
        users.add(new User(2,"Vanitha",LocalDate.now().minusYears(21)));
        users.add(new User(3,"Neethu",LocalDate.now().minusYears(18)));
        users.add(new User(4,"jagadeesh",LocalDate.now().minusYears(14)));
    }

    public static List<User> findAllUsers(){
        return users;
    }
}
