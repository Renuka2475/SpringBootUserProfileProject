package com.SpringBootProject.JPA;

import com.SpringBootProject.UserProfile.bean.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostJPARepository extends JpaRepository<Post,Integer> {
}
