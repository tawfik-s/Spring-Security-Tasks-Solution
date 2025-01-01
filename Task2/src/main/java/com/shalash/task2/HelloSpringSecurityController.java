package com.shalash.task2;


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
        return "Hello Spring Security learner at Task2";
    }


    @GetMapping("/task")
    public String getTaskAsString(){
        return  """
                    Task 2: Role-Based AccessControl
                        Implement role-based access control:
                        USER can access /user/**.
                        ADMIN can access /admin/** and /user/**.
                        Restrict /admin/** to only ADMIN users.
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
