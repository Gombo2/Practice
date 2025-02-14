package com.ohgiraffers.section03.reference;

import java.util.function.Function;

public class Application2 {
    public static void main(String[] args) {


        /* 수업목표. 기존에 존재하는 생성자를 참조한 람다식을 활용할 수 있다.*/
//        Function<String, Member> costMember =
//                 x -> {return new Member(x)};
//        x -> new Member(x);


        Function<String, Member> costMember = Member::new; //객체 선언(member(memId))를 쓴것.


        Member member1 = costMember.apply("A");
        System.out.println("member1 = " + member1);

        Member member2 = costMember.apply("B");
        System.out.println("member2 = " + member2);


    }
}
