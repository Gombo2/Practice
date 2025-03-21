package com.ohgiraffers.springcloudgateway.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class AuthorizationHeaderFilter
	extends AbstractGatewayFilterFactory<AuthorizationHeaderFilter.Config> {

	Environment env;

	@Autowired
	public AuthorizationHeaderFilter(Environment env) {
		this.env = env;
	}

	public static class Config {


	}

	@Override
	public GatewayFilter apply(Config config) {

		return (exchange, chain) -> {
			ServerHttpRequest request = exchange.getRequest();
			//사용자 요청 동일하다.  얘가 토큰임.

			/* 설명. request header에 "Authorization" 이라는 키 갑싱 없으면 토큰 업싱 요청이 온 것으로 판단.*/
			if(!request.getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
				return onError(exchange, "No autorization header", HttpStatus.UNAUTHORIZED);
			}

			return chain.filter(exchange);
		};
	}

	private Mono<Void> onError(ServerWebExchange exchange, String noAutorizationHeader, HttpStatus httpStatus) {
			return null;
	}
}
