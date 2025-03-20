package com.ohgiraffers.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ohgiraffers.userservice.aggregate.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
	UserEntity findByEmail(String email);
}
