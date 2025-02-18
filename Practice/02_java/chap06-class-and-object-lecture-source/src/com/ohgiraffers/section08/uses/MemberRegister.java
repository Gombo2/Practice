package com.ohgiraffers.section08.uses;

public class MemberRegister {
    public void regist(Member[] members) {
        System.out.println("회원을 등록합니다.");

        for (int i = 0; i < members.length; i++) {
            System.out.println(members[i].getName() + "님 회원 가입을 축하드립니다.");
        }

        MemberRepository.store(members);

    }
}
