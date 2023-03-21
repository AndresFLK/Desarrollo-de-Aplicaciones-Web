package com.tienda_l;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public UserDetailsService users() {
        UserDetails admin = User.builder()
                .username("Juan")
                .password("{noop}Juan123")
                .roles("ADMIN", "VENDEDOR")
                .build();
        UserDetails sales = User.builder()
                .username("Rebeca")
                .password("{noop}Rebeca123")
                .roles("ADMIN", "VENDEDOR")
                .build();
        UserDetails user = User.builder()
                .username("Pedro")
                .password("{noop}Pedro123")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(user, sales, admin);
    }

}
