package com.shalash.task1;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloSpringSecurityController {

    @GetMapping("/")
    public String getAfterAuthentication(){
        return "authenticated try to visit /hello and /task ";
    }


    @GetMapping("/hello")
    public String sayHello(){
        return "Hello Spring Security from Task1";
    }


    @GetMapping("/task")
    public String getTaskAsString(){
        return """
                Task 1: Basic Authentication
                Configure a Spring Boot application with Spring Security to require username and password authentication for all endpoints.
                Use in-memory user details with roles USER and ADMIN.
                """;
    }


}
