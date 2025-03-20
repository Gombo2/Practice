package com.ohgiraffers.userservice.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JwtFilter extends OncePerRequestFilter {

	private final JwtUtil jwtUtil;

	public JwtFilter(JwtUtil jwtUtil) {
		this.jwtUtil = jwtUtil;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
		FilterChain filterChain) throws ServletException, IOException {
		String authorizationHeader = request.getHeader("Authorization");
		log.info("들고 온 토큰 확인: {}", authorizationHeader);

		if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
			String token = authorizationHeader.substring(7);		// bearer " 를 제외한 토큰 부분만 추출
			log.info("순수 토큰 값: {}" + token);
			if(jwtUtil.validateToken(token)) {

			}
		}

		/* 궁금. 다음 필터를 진행하게 해 줘야 AuthenticationFilter가 동작한다. */
		filterChain.doFilter(request, response);
	}


}
