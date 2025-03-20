package com.ohgiraffers.userservice.vo;

import lombok.Data;

/* 궁금. 요청값을 받는것 + alpha가능 (validation 체크등) */
@Data
public class RequestRegistUserVO {
	private String email;
	private String name;
	private String pwd;
}
