package com.shalash.task6;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.DefaultAuthenticationEventPublisher;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, DefaultAuthenticationEventPublisher defaultAuthenticationEventPublisher) throws Exception {
        return http.authorizeHttpRequests(
                authorizeRequests ->{
                    authorizeRequests.anyRequest().authenticated();
                }
        ).oauth2Login(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults())
                .build();
    }


    //not necessary you can remove it
    @Bean
    public UserDetailsService userDetailsService() {
        return new InMemoryUserDetailsManager(
                User.withUsername("tawfeek")
                        .password("{noop}pass")
                        .roles("USER").build(),
          User.builder().username("mohamed")
                  .password("{noop}pass")
                  .roles("ADMIN").build()
        );
    }




}
