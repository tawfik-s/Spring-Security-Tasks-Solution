package com.shalash.task5;

import com.shalash.task5.enitity.UserDetailsImpl;
import com.shalash.task5.repository.UserDetailsImplRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class ApplicationConfig {


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(UserDetailsImplRepo userDetailsImplRepo) {
        return username -> userDetailsImplRepo.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
    }

    //add users to the database
    @Bean
    public CommandLineRunner commandLineRunner(UserDetailsImplRepo repository) {
        return args -> {
            UserDetailsImpl u1= UserDetailsImpl.builder()
                    .name("tawfeek")
                    .role("ROLE_ADMIN")
                    .email("t.shalash1@gmail.com")
                    .password(new BCryptPasswordEncoder().encode("tawfeekpass"))
                    .build();

            UserDetailsImpl u2= UserDetailsImpl.builder()
                    .name("mohamed")
                    .role("ROLE_USER")
                    .password(new BCryptPasswordEncoder().encode("mohamedpass"))
                    .email("m.shalash1@gamil.com")
                    .build();
            repository.save(u1);
            repository.save(u2);
        };
    }

}
