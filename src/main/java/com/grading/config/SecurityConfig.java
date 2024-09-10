//package com.grading.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http
//                .authorizeHttpRequests((authz) -> authz
//                        .requestMatchers("/public/**").permitAll()
//                        .anyRequest().authenticated()
//                )
//                .oauth2Login(Customizer.withDefaults())
//                .build();
//    }
//
//    @Bean
//    public ClientRegistrationRepository clientRegistrationRepository() {
//        return null;
//    }
//}
