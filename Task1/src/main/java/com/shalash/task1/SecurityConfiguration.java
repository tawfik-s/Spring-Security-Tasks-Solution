package com.shalash.task1;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(authorizeRequests -> {
                    authorizeRequests.anyRequest().authenticated();
                }).formLogin(Customizer.withDefaults())
                //not required in task1 solution to add filter
                .addFilterBefore(new SecurityFilter(), UsernamePasswordAuthenticationFilter.class)
                .build();
    }


    /**
     * {noop} specifies that the password is stored as plain text (not recommended for production).
     * Replace {noop} with a proper password encoder, e.g., BCryptPasswordEncoder for production applications.
     * I provide two ways to use the builder with builder() method or with withUsername
     * this for second task that  require create in-memory user details with roles USER and ADMIN
     *
     */
    @Bean
    public UserDetailsManager userDetailsManager() {
        return new InMemoryUserDetailsManager(
                User.builder()
                        .username("tawfeek")
                        .password("{noop}pass")
                        .roles("USER")
                        .build()
                ,
                User.withUsername("mohamed")
                        .password("{noop}pass")
                        .roles("ADMIN")
                        .build()
        );
    }

}
