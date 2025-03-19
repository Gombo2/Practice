package com.ohgiraffers.userservice.dto;

import lombok.Data;

@Data
public class UserDTO {
	private String email;
	private String name;
	private String pwd;

	private String userId;
}
