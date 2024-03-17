package com.manish.lms.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return passwordEncoder;
    }

    // @Autowired
    // private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // @Bean
    // protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    //     auth.userDetailsService(userService::loadUserByUsername).passwordEncoder(passwordEncoder);
    // }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(Authorize -> Authorize
                .requestMatchers("/api/admin/**").hasRole("ADMIN")
                .requestMatchers("/api/**").authenticated())
                .formLogin(formlogin -> formlogin.loginPage("/login").permitAll())
                .logout(logoutt -> logoutt.permitAll())
                .csrf(csrf -> csrf.disable());

        return http.build();
    }
}