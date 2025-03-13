package com.ohgiraffers.section01;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class EntityManagerLifeCycleTest {
    private static EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    @BeforeAll
    public static void initFacotry() {
        entityManagerFactory = Persistence.createEntityManagerFactory("jpatest");
    }

    @BeforeEach
    public void initManger() {
        /* 설명. EntityManager가 생성될 때마다 고유의 새로운 영속성 컨텍스트(Entity를 관리하는 자바의 창고)가 생성된다.*/
        entityManager = entityManagerFactory.createEntityManager();
    }
}
