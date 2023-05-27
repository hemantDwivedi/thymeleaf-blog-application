//package com.project.blog.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                        .authorizeHttpRequests()
//                                .requestMatchers("/blog/**")
//                                        .permitAll()
//                                                .requestMatchers("/users")
//                                                        .hasRole("ADMIN")
//                                                                .and()
//                                                                        .formLogin(
//                                                                                form -> form
//                                                                                        .loginPage("/sign-in")
//                                                                                        .loginProcessingUrl("/sign-in")
//                                                                                        .defaultSuccessUrl("/users")
//                                                                                        .permitAll()
//                                                                        )
//                                                                                .logout(
//                                                                                        logout -> logout
//                                                                                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                                                                                                .permitAll()
//                                                                                );
//        return http.build();
//    }
//}
