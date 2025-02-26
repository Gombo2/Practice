package com.ohgiraffers.common;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
//@Data                 //위에거 + equals, hashcode,내부클래스 등등 전체를 다만들어줌.. 근데 별로임
public class MemberDTO {
    private int sequence;
    private String id;
    private String pwd;
    private String name;

}
