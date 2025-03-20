package com.ohgiraffers.userservice.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ohgiraffers.userservice.dto.UserDTO;
import com.ohgiraffers.userservice.service.UserService;
import com.ohgiraffers.userservice.vo.RequestRegistUserVO;
import com.ohgiraffers.userservice.vo.ResponseRegistUserVO;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class UserController {

	private Environment env;
	private UserService userService;
	private ModelMapper modelMapper;

	@Autowired
	public UserController(Environment env, UserService userService, ModelMapper modelMapper) {
		this.env = env;
		this.userService = userService;
		this.modelMapper = modelMapper;
	}

	@GetMapping("/health")
	public String status() {
		return "I'm Working in User Service " + env.getProperty("local.server.port");
	}

	@PostMapping("users")
	public ResponseEntity<ResponseRegistUserVO> registUser(@RequestBody RequestRegistUserVO newUser) {
		UserDTO userDTO = modelMapper.map(newUser, UserDTO.class);

		/* 설명. call by reference 개념 (반환받을 필요 없이 객체의 주소를 받아 userId를 추가하는 개념) == 같은 주소 */
		/* 궁금. service 가기 전과 후가 같은 객체이니 반환받을 필요가 없다.*/
		userService.registUser(userDTO);	// 총 필드 4개중 입력값 3개만 가지고 service 계층 전 상태. (그후 uuid 추가됨)
		ResponseRegistUserVO successRegistUser = modelMapper.map(userDTO, ResponseRegistUserVO.class);
		// 여기서 userDTO 는 위의 객체 그대로의 주소를 가지고 있다.(객체 하나가지고 계속 사용중임) service 간 후

		return ResponseEntity.status(HttpStatus.CREATED)
							 .body(successRegistUser);
	}
}
