package com.ohgiraffers.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Chap0101EurekaServerLectureApplication {

	public static void main(String[] args) {
		SpringApplication.run(Chap0101EurekaServerLectureApplication.class, args);
	}

}
