package com.ohgiraffers.userservice.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class WebSecurity {

	@Bean
	protected SecurityFilterChain configure(HttpSecurity http) throws Exception  {
		http.csrf(csrf -> csrf.disable());

		/* 설명. 허용되는 경로 및 권한 설정 */
		http.authorizeHttpRequests(authz ->
			authz.requestMatchers(new AntPathRequestMatcher("/users/**")).permitAll()
				.anyRequest().authenticated()
		);

		return http.build();
	}
}
