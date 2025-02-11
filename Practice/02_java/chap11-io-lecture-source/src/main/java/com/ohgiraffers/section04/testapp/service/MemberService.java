package com.ohgiraffers.section04.testapp.service;

import com.ohgiraffers.section04.testapp.aggregate.Member;
import com.ohgiraffers.section04.testapp.repository.MemberRepository;

import java.util.ArrayList;

/* 설명. 트랜잭션 처리(성공 실패에 따라 commit/rollback) 및 회원관리 비즈니스 로직 처리 */
public class MemberService {

    private final MemberRepository mr = new MemberRepository();

    public MemberService() {
    }

    public void findAllMembers() {
        ArrayList<Member> findMembers = mr.selectAllMembers();

        System.out.println("Service에서 조회 확인: ");
        for (Member member : findMembers) {
            System.out.println(member);
        }
    }

    public void findMemberBy(int memNo) {
        Member findMember = mr.selectMemberBy(memNo);

        if(findMember != null) {
            System.out.println("회원 조회 성공: " + findMember);
        } else {
            System.out.println(memNo + "번 회원은 없습니다.");
        }
    }
}
