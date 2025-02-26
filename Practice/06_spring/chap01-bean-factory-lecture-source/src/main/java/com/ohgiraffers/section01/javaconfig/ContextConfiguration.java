package com.ohgiraffers.section01.javaconfig;


import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//자바의 configuration metadata 방법 (spring 설정) 이게 pojo인거 바꾸려면 annotation으로 바꾸어야함(@Configuration)
@Configuration
public class ContextConfiguration {

    @Bean("member")     //Bean 옆에 ("원하는 bean 명")으로 초기화할수 있다.
    public MemberDTO getMember() {
        return new MemberDTO(1, "user01", "pass01", "홍길동");
    }
}
