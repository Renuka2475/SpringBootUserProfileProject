package com.SpringBootProject.JPA;

import com.SpringBootProject.UserProfile.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJPARepository extends JpaRepository <User,Integer>{

}
