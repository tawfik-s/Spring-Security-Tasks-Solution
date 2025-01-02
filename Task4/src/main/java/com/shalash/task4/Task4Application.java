package com.shalash.task4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class Task4Application {


    @Autowired
    private UserDetailsImplementationEntityRepository userDetailsImplementationEntityRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(Task4Application.class, args);
    }

    // lets add two users at the database for testing

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            userDetailsImplementationEntityRepository.save(UserDetailsImplementationEntity.builder()
                    .name("mohamed")
                    .email("m.shalash2@gmail.com")
                    .role("ROLE_ADMIN")
                    .password(passwordEncoder.encode("mohamed")).build());

            userDetailsImplementationEntityRepository.save(UserDetailsImplementationEntity.builder()
                    .name("tawfeek")
                    .email("t.shalash1@gmail.com")
                    .role("ROLE_USER")
                    .password(passwordEncoder.encode("tawfeek")).build());
        };
    }
}
