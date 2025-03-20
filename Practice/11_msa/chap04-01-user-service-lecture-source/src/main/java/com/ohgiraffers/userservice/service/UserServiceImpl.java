package com.ohgiraffers.userservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
		registUser.setEncryptedPwd(bCryptPasswordEncoder.encode(userDTO.getPwd())); // plain text(평문) -> digest(암호문)

		userRepository.save(registUser);

	}

	/* 설명. *spring security 사용 시 프로바이더에서 활용할 로그인용 메소드 (id로 회원 조회해서 UserDetails 타입을 반환하는 메소드) */
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		UserEntity loginUser = userRepository.findByEmail(email);	// email 필드로 where 절을 걸어서 조회하는 쿼리 메소드 작성

		/* 설명. DB에서 조회 된 해당 email의 회원 권한들을 가져와, List<GrantedAuthority>로 만듬 */
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ENTERPRISE"));

		return new User(loginUser.getEmail(), loginUser.getEncryptedPwd(),
			true, true, true, true, grantedAuthorities);
	}
}
