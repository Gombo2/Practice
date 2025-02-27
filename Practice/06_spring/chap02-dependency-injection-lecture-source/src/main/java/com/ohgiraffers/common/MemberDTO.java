package com.ohgiraffers.common;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class MemberDTO {
    private int sequence;
    private String name;
    private String email;
    private Account personalAccount;            // 개인 계좌
                                                // interface 객체를 받야아 함으로 의존관계가 형성된다.
}
