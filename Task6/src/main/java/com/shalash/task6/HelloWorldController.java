package com.shalash.task6;


import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/")
    public String getHomePage(Authentication auth){
        return "welcome to our app "+ auth.getName();
    }

    @GetMapping("/user")
    public String getUserPage(Authentication auth){
        return "welcome to user page "+ auth.getName();
    }
}
