package com.SpringBootProject.UserProfile.userDao;

import com.SpringBootProject.UserProfile.bean.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

@Component
public class UserDaoService {


    private static List<User> users = new ArrayList<>();
    private static int idCount=0;
    static {
        users.add(new User(idCount++,"Renuka", LocalDate.now().minusYears(24)));
        users.add(new User(idCount++,"Vanitha",LocalDate.now().minusYears(21)));
        users.add(new User(idCount++,"Neethu",LocalDate.now().minusYears(18)));
        users.add(new User(idCount++,"jagadeesh",LocalDate.now().minusYears(14)));
    }

    public static List<User> findAllUsers(){
        return users;
    }

    public static User findUserById(int id) {
        User userDetails=users.stream()
                .filter(user-> user.getId()==id)
                .findFirst()
                .orElse(null);

        return userDetails;
    }
    public static void deleteUserById(int id) {
       users.removeIf(user->user.getId()==id);
    }

    public static User createuser(User user){
        user.setId(idCount++);
        users.add(user);
        return user;
       }
}
