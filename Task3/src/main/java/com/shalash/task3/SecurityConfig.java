package com.shalash.task3;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


    private final CustomSuccessHandler customSuccessHandler;

    public SecurityConfig(CustomSuccessHandler customSuccessHandler) {
        this.customSuccessHandler = customSuccessHandler;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(authorizeRequests -> {
                    authorizeRequests.requestMatchers("/admin/**").hasRole("ADMIN");
                    authorizeRequests.anyRequest().authenticated();
                }).formLogin(form -> {
                    form.loginPage("/login").permitAll();
                    form.successHandler(customSuccessHandler);
                })
                .build();
    }


    @Bean
    public UserDetailsManager userDetailsManager() throws Exception {
        return new InMemoryUserDetailsManager(
                User.withUsername("tawfeek")
                        .password("{noop}pass")
                        .roles("USER")
                        .build(),
                User.withUsername("mohamed")
                        .password("{noop}pass")
                        .roles("ADMIN")
                        .build()
        );
    }
}
