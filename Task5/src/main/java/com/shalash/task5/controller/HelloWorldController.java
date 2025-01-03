package com.shalash.task5.controller;


import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {


    @GetMapping("/")
    public String helloWorld(Authentication authentication) {
        return "hello at the root endpoint "+authentication.getName();
    }


    @GetMapping("/user")
    public String getUserPage(Authentication authentication) {
        return "hello at the user endpoint "+authentication.getName();
    }


    @GetMapping("/admin")
    public String getAdminPage(Authentication authentication) {
        return "hello at the admin endpoint "+authentication.getName();
    }


}
