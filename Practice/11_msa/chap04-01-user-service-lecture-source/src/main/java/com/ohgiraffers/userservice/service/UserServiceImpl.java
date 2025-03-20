package com.ohgiraffers.userservice.service;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ohgiraffers.userservice.aggregate.UserEntity;
import com.ohgiraffers.userservice.dto.UserDTO;
import com.ohgiraffers.userservice.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	UserRepository userRepository;
	ModelMapper modelMapper;
	BCryptPasswordEncoder bCryptPasswordEncoder;

	public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper,
		BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userRepository = userRepository;
		this.modelMapper = modelMapper;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}


	@Override
	@Transactional
	public void registUser(UserDTO userDTO) {

		/* 설명. 회원 가입 할 때 고유 번호 할당. */
		userDTO.setUserId(UUID.randomUUID().toString());


		/* 설명. Entity로 modelMapper로 매핑 후 엔티티에 있는 encrpytedPwd에 암호화 된 값을 추가한다. */
		UserEntity registUser = modelMapper.map(userDTO, UserEntity.class);
		/* 궁금. 매핑을 느슨하게 하지 않고, 정확한 필드명이 동일한거에 매핑하라고 정의 해줘야 함. -> config에서 처리*/
		registUser.setEncryptedPwd(bCryptPasswordEncoder.encode(userDTO.getPwd()));

		userRepository.save(registUser);

	}
}
