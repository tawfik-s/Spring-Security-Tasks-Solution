package com.shalash.task8;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {


    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
       return http.authorizeHttpRequests(authorizeRequests ->
               authorizeRequests.anyRequest().authenticated())
               .formLogin(Customizer.withDefaults())
//               .csrf(csrf -> csrf.disable()) //disable csrf not recommended
//               .csrf(csrf -> csrf.ignoringRequestMatchers("/ts"))  /ignore specific request from csrf
               .build();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        return new InMemoryUserDetailsManager(
                User.withUsername("tawfeek")
                        .password("{noop}pass")
                        .roles("ADMIN")
                        .build(),
                User.withUsername("mohamed")
                        .password("{noop}pass")
                        .roles("USER")
                        .build()
        );
    }
}
