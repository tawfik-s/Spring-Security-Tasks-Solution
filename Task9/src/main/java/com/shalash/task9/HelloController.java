package com.shalash.task9;


import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String index() {
        return "hello at task9";
    }

    @GetMapping("/user")
    public String helloUser(Authentication authentication) {
        return "welcome user "+ authentication.getName() + " authorities " + authentication.getAuthorities();
    }



}
