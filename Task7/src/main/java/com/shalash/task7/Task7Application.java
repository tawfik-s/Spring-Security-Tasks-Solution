package com.shalash.task7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@SpringBootApplication
public class Task7Application {

    public static void main(String[] args) {
        SpringApplication.run(Task7Application.class, args);
    }

}
