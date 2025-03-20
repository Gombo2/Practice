package com.ohgiraffers.userservice.security;

import java.security.Key;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class JwtUtil {

	private final Key key;

	public JwtUtil(
		@Value("${token.secret}") String secretKey
			) {
			byte[] keyBytes = Decoders.BASE64.decode(secretKey);
			this.key = Keys.hmacShaKeyFor(keyBytes);
	}

	public boolean validateToken(String token) {
		try {
			Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
			return true;
		} catch (io.jsonwebtoken.security.SecurityException | MalformedJwtException e) {
			log.info("유효하지 않은 JWT Token");
		} catch (ExpiredJwtException e) {
			log.info("만료기간이 지남");
		} catch (IllegalArgumentException e) {
			log.info("토큰의 클레임이 비어있음");
		}
		return false;
	}
}
