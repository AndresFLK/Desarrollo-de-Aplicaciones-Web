package com.tienda_l;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

        @Bean
        public UserDetailsService users() {
                UserDetails admin = User.builder()
                                .username("Juan")
                                .password("{noop}Juan123")
                                .roles("ADMIN", "VENDEDOR", "USER")
                                .build();
                UserDetails sales = User.builder()
                                .username("Rebeca")
                                .password("{noop}Rebeca123")
                                .roles("VENDEDOR", "USER")
                                .build();
                UserDetails user = User.builder()
                                .username("Pedro")
                                .password("{noop}Pedro123")
                                .roles("USER")
                                .build();

                return new InMemoryUserDetailsManager(user, sales, admin);
        }

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http)
                        throws Exception {
                http
                                .authorizeHttpRequests((request) -> request
                                                .requestMatchers("/",
                                                                "/index",
                                                                "/errores/**",
                                                                "/webjars/**")
                                                .permitAll()
                                                .requestMatchers(
                                                                "/articulo/nuevo",
                                                                "/articulo/guardar",
                                                                "/articulo/modificar/**",
                                                                "/articulo/eliminar/**",
                                                                "/categoria/nuevo",
                                                                "/categoria/guardar",
                                                                "/categoria/modificar/**",
                                                                "/categoria/eliminar/**",
                                                                "/cliente/nuevo",
                                                                "/cliente/guardar",
                                                                "/cliente/modificar/**",
                                                                "/cliente/eliminar/**")
                                                .hasRole("ADMIN")
                                                .requestMatchers(
                                                                "/articulo/listado",
                                                                "/categoria/listado",
                                                                "/cliente/listado")
                                                .hasAnyRole("ADMIN", "VENDEDOR"))
                                .formLogin((form) -> form
                                                .loginPage("/login").permitAll())
                                .logout((logout) -> logout.permitAll())
                                .exceptionHandling()
                                .accessDeniedPage("/errores/403");
                return http.build();
        }
}
