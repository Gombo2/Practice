package com.ohgiraffers.section01.simple;

import jakarta.persistence.*;
import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;

public class SimpleJPQLTest {
    private static EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    @BeforeAll
    public static void initFactory() {
        entityManagerFactory = Persistence.createEntityManagerFactory("jpatest");
    }

    @BeforeEach
    public void initManager() {

        /* 설명. EntityManager가 생성될 때마다 고유의 새로운 영속성 컨텍스트(Entity를 관리하는 자바의 창고)가 생성된다. */
        entityManager = entityManagerFactory.createEntityManager();
    }

    @AfterEach
    public void closeManager() {
        entityManager.close();
    }

    @AfterAll
    public static void closeFactory() {
        entityManagerFactory.close();
    }

    @Test
    public void TypedQuery를_이용한_단일행_조회_테스트() {
        String jpql = "SELECT menuName FROM menu_section01 WHERE menuCode = 7";
        TypedQuery<String> query = entityManager.createQuery(jpql, String.class); //순수 jpa로만 할때 이렇게 씀
        String resultMenuName = query.getSingleResult(); //단일행 조회

        Assertions.assertEquals("민트미역국", resultMenuName);
    }

    @Test
    public void Query를_이용한_단일행_조회_테스트() {
        String jpql = "SELECT m.menuName FROM menu_section01 m WHERE m.menuCode = 7";
        Query query = entityManager.createQuery(jpql); //순수 jpa로만 할때 이렇게 씀
        Object resultMenuName = query.getSingleResult(); //단일행 조회
        System.out.println("resultMenuName = " + resultMenuName);

        Assertions.assertTrue(resultMenuName instanceof String);
        Assertions.assertEquals("민트미역국", resultMenuName);

        /* 설명. 단일행 일부 다중열(Object[]일 시) */
        /* 설명. jpql을 통해 일부분의 조회 결과 컬럼을 받아내는 것을 projection이라고 한다.*/
        /* 궁금. 그래서 보통 2개가 필요하더라도 m으로 전체를 조회한다.*/
//        String jpql = "SELECT m.menuName, m.menuPrice FROM menu_section01 m WHERE m.menuCode = 7";
//        // 일부분만 받는 방식으로 프로젝션 이라고 한다.
//        Query query = entityManager.createQuery(jpql);
//        List<Object[]> resultColums = query.getResultList();
//
//        Object[] resultRow = resultColums.get(0);
//        Arrays.stream(resultRow).forEach(System.out::println);
//
//        Assertions.assertTrue(resultRow[0] instanceof String);
//        Assertions.assertTrue(resultRow[1] instanceof Integer);
    }

    @Test
    public void TypedQuery를_이용한_다중행_다중열_조회_테스트() {
        String jpql = "SELECT m FROM menu_section01 m";
        /* 궁금. 모든 컬럼은 entity로 치환될 수 있다. 모든걸 뽑는경우니까(m) m.* 불가.*/
        TypedQuery<Menu> query = entityManager.createQuery(jpql, Menu.class);

        List<Menu> foundMenuList = query.getResultList();
        foundMenuList.forEach(System.out::println);

        Assertions.assertTrue(!foundMenuList.isEmpty());
    }

    @Test
    public void distinct를_활용한_중복제거_여러_행_조회_테스트() {
        /* 궁금. distinct를 통해 중복 제거, (메뉴의 할당된 카테고리의 종류를 보겠다는 jpql.)*/
        String jpql = "SELECT DISTINCT m.categoryCode FROM menu_section01 m";
        TypedQuery<Integer> query = entityManager.createQuery(jpql, Integer.class);
        List<Integer> categoryCodeList = query.getResultList();
        categoryCodeList.forEach(System.out::println);

        Assertions.assertTrue(!categoryCodeList.isEmpty());
    }

    @Test
    public void in_연산자를_활용한_조회_테스트() {
        String jpql = "SELECT m FROM menu_section01 m WHERE m.categoryCode IN (6, 10)";
        List<Menu> menuList = entityManager.createQuery(jpql, Menu.class).getResultList();

        menuList.forEach(System.out::println);
        Assertions.assertTrue(!menuList.isEmpty());

    }

    @Test
    public void like_연산자를_활용한_조회_테스트() {
        String jpql = "SELECT m FROM menu_section01 m WHERE m.menuName LIKE '%마늘%'";
        List<Menu> menuList = entityManager.createQuery(jpql, Menu.class).getResultList();

        menuList.forEach(System.out::println);
        Assertions.assertTrue(!menuList.isEmpty());

    }
}
