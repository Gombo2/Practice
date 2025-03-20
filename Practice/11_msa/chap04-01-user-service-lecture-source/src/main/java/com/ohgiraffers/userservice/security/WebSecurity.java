package com.ohgiraffers.userservice.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/* 설명. WebSecurityConfigurerAdapter를 상속 받거나 @EnableWebSEcurity를 쓰는 예제는 옛날 방식.*/
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
