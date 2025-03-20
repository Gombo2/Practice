package com.ohgiraffers.userservice.security;

import jakarta.servlet.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.Collections;

/* 설명. WebSecurityConfigurerAdapter를 상속 받거나 @EnableWebSecurity를 쓰는 예제는 옛날 방식 */
@Configuration
public class WebSecurity{

    private JwtAuthenticationProvider jwtAuthenticationProvider;
    private Environment env;        //의존성 주입 DI

    @Autowired
    public WebSecurity(JwtAuthenticationProvider jwtAuthenticationProvider, Environment env) {
        this.jwtAuthenticationProvider = jwtAuthenticationProvider;
        this.env = env;
    }

    @Bean
    public AuthenticationManager authenticationManager() {
        return new ProviderManager(Collections.singletonList(jwtAuthenticationProvider));
    }

    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception{
        http.csrf(csrf -> csrf.disable());

        /* 설명. 허용되는 경로 및 권한 설정 */
        http.authorizeHttpRequests(authz ->
                authz.requestMatchers(new AntPathRequestMatcher("/users/**")).permitAll()
                        .anyRequest().authenticated()
             )
            .authenticationManager(authenticationManager())
            .sessionManagement(session ->
                    session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        http.addFilter(getAuthenticationFilter(authenticationManager()));

        return http.build();
    }

    /* 설명. Filter는 jakarta.servlet으로 import */
    private Filter getAuthenticationFilter(AuthenticationManager authenticationManager) {
        return new AuthenticationFilter(authenticationManager, env);
    }
}
