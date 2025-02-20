package com.ohgiraffers.secton03.additional;

import org.junit.jupiter.api.*;

import java.util.concurrent.TimeUnit;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AdditionalAnnotationTest {

    /* 수업목표. Junit에서 제공하는 메소드 관련 추가 어노테이션을 사용할 수 있다. */
    @Disabled           //이 테스트를 무시한다.
    @Test
    public void testIgnore() {}


    @Test
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)        // 1초
    public void testTimeout() throws InterruptedException {
//        Thread.sleep(900);
//        Thread.sleep(2000); // Thread.sleep을 활용하면 밀리초만큼 지연 가능
    }

    /* 설명. 클래스 위에 TestMethodOrder 어노테이션을 추가해야 한다. */
    @Test
    @Order(1)
    public void testFirst() {

    }

    @Test
    @Order(3)
    public void testThird() {

    }

    @Test
    @Order(2)
    public void testSecond() {

    }

}
