package com.shalash.task3;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloSpringSecurityController {

    @GetMapping("/")
    public String getAfterAuthentication(){
        return "authenticated try to visit /hello , /task , /USER and /ADMIN. ";
    }


    @GetMapping("/hello")
    public String sayHello(){
        return "Hello Spring Security learner at Task3";
    }


    @GetMapping("/task")
    public String getTaskAsString(){
        return  """
                     Task 3: Custom Login Page
                        Create a custom login page and configure Spring Security to use it instead of the default form-based login.
                        Redirect users to different pages after login based on their roles.
                """;
    }

    @GetMapping("/user")
    public String getUserPage(){
        return "Welcome at user page";
    }


    @GetMapping("/admin")
    public String getAdminPage(){
        return "Welcome at admin page";
    }




}
