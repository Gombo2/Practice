package com.ohgiraffers.secondservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class SecondServiceController {

	private Environment env;

	@Autowired
	public SecondServiceController(Environment env) {
		this.env = env;
	}

	@GetMapping("/health")
	public String healthCheck() {
		return "I'm OK, 포트는 " + env.getProperty("local.server.port");
	}

}

