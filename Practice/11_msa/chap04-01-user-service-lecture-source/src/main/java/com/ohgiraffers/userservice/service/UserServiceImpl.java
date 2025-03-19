package com.ohgiraffers.userservice.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.ohgiraffers.userservice.dto.UserDTO;
import com.ohgiraffers.userservice.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	UserRepository userRepository;

	@Override
	public void registUser(UserDTO userDTO) {

		/* 설명. 회원 가입 할 때 고유 번호 할당. */
		userDTO.setUserId(UUID.randomUUID().toString());
	}
}
