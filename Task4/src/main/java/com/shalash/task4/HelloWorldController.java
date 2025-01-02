package com.shalash.task4;


import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/")
    public String getMainPage(Authentication authentication) {
        return "hello from root endpoint "+authentication.getName();
    }


    @GetMapping("/user")
    public String getUserPage(Authentication authentication) {
        return "welcome "+authentication.getName()+" at user endPoint";
    }


    @GetMapping("/admin")
    public String getAdminPage(Authentication authentication) {
        return "hello from admin endpoint "+authentication.getName();
    }

}
