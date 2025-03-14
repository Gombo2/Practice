package com.ohgiraffers.section03.primarykey.subsection01.identity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

import java.util.List;

public class PrimaryKeyMappingTest {
    private static EntityManagerFactory entityManagerFactory;

    private EntityManager entityManager;

    @BeforeAll
    public static void initFactory() {
        entityManagerFactory = Persistence.createEntityManagerFactory("jpatest");
    }

    @AfterAll
    public static void closeFactory() {
        entityManagerFactory.close();
    }

    @BeforeEach
    public void initManager() {
        entityManager = entityManagerFactory.createEntityManager();
    }

    @AfterEach
    public void closeManager() {
        entityManager.close();
    }

    @Test
    public void 식별자_매핑_테스트() {

        Member member = new Member();
//        member.setMemberNo(1);
        member.setMemberId("user01");
        member.setMemberPwd("pass01");
        member.setNickname("홍길동");
        member.setPhone("010-1234-5678");
        member.setEmail("hong@gmail.com");
        member.setAddress("서울시 서초구");
        member.setEnrollDate(new java.util.Date());
        member.setMemberRole("ROLE_MEMBER");
        member.setStatus("Y");

        Member member2 = new Member();
//        member2.setMemberNo(1);
        member2.setMemberId("user02");
        member2.setMemberPwd("pass02");
        member2.setNickname("홍길22");
        member2.setPhone("010-3331-5678");
        member2.setEmail("hong@gml.com");
        member2.setAddress("서울시 강남구");
        member2.setEnrollDate(new java.util.Date());
        member2.setMemberRole("ROLE_ADMIN");
        member2.setStatus("Y");

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.persist(member);
        entityManager.persist(member2);

        transaction.commit();

        /* 설명. persist 당시에는 부여되지 않은 pk값으로 commit 이후로 조회를 하면 가능할까? */
//        Member selectedMember = entityManager.find(Member.class, 1);
//        System.out.println("selectedMember = " + selectedMember);
//
//        Assertions.assertEquals(2, selectedMember.getMemberNo());

        Stirng jpql = "SELECT A.memberNo FROM member_section03_subsection01.A";
        List<Integer> memberCodeList = entityManager.createQuery(jpql, Integer.class).getResultList();
        memberCodeList.forEach(System.out::println);
    }
}
