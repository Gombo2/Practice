package com.ohgiraffers.section03.bidirection;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

public class BidirectionTest {
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

    /* 설명. 양방향 연관관계를 통해 만들 엔티티 갯수는 줄어들지만 경우의 수를 모두 고려하여 설계해야 한다.
    *       (특히 순환참조를 고려해야 한다.(toString() 작성 시 조심(join의 대상 제외) 해야 한다.)
    * */
    @Test
    public void 양방향_연관관계_매핑_조회_테스트() {
        int menuCode = 10;
        int categoryCode = 10;

        /* 설명. 연관관계의 주인(자식 엔티티)은 한번에 left join문으로 관계를 맺은 엔티티를 조회해 온다. */
        Menu foundMenu = entityManager.find(Menu.class, menuCode); //ManyToOne
        System.out.println("foundMenu = " + foundMenu);
        // 객체 그래프 탐색 -> 연관관계를 탐색하는것
        System.out.println("10번 메뉴의 카테고리: " + foundMenu.getCategory());

        /* 설명. 양방향은 부모에 해당하는 엔티티는 가짜 연관관계이고 필요 시 연관 관계 엔티티를 조회하는 쿼리로 작성된다.
        *       (FetchType.LAZY처럼 동작한다.)
        * */
        /* 궁금. OneToMany는 애초에 join이 들어가지 않는다.*/
        Category foundCategory = entityManager.find(Category.class, categoryCode); //OneToMany -> 필요할때가아니면 안날아감
        System.out.println("foundCategory = " + foundCategory);
        /* 궁금. 달라고 할때 select이 한번 더 날아간다.*/
        System.out.println("10번 카테고리의 메뉴들: " + foundCategory.getMenuList()); // menu에 대한 select 발생

    }
}
