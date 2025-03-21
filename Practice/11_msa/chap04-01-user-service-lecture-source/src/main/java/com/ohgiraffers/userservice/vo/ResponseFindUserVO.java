package com.ohgiraffers.userservice.vo;

import lombok.Data;

@Data
public class ResponseFindUserVO {
    private String email;
    private String name;
    private String userId;

    /* 설명. Feign Client 이후 (주문도내역도 담기)*/
    private List<ResponseOrdere> orders;
}
