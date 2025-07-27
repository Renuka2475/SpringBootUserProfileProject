package com.SpringBootProject.SpringSecurity;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import  org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
@Configuration
public class SpringSecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

//        All requests should get authenticated

        http.authorizeHttpRequests(auth->auth.anyRequest().authenticated());
//        If a request is not authenticated a web page is shown
        http.httpBasic(Customizer.withDefaults());

//        CSRF -> Post, Put

        http.csrf(csrf->csrf.disable());


        return http.build();

    }


}
