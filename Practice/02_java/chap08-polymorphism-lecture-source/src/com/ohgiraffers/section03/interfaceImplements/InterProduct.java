package com.ohgiraffers.section03.interfaceImplements;

public interface InterProduct extends ParentInterProduct, AnotherParentInterProduct {
//    public static final int MAX_NUM = 100; //public static final 안적어도됨. 인터페이스에서는 항상 들어가기때문
    int MAX_NUM = 100; //상품이 최대 100개만 저장 가능하고 변동 없이 이 값을 활용해라.

    /* 설명. 인터페이스는 생성자를 가질 수 없다.(feat. 객체를 만들 수 없다.)*/
//    public InterProduct() {}

    /* 설명. 반환형 없고, 들어가는 매개변수 없고, 이 메소드 명으로 Override 해서 쓰세요~ 라고 규약이 생긴것*/
//    public void nonStaticMethod(); //추상메소드 abstract 또한 고정이기에 자동으로 들어간다.

    void nonStaticMethod();

    /* 설명. static 메소드를 사용하면 메소드의 바디부까지 작성이 가능하다. (JDK 1.8부터 추가) */
    public static void staticMethod() {

    }

    /* 설명. non-static 메소드도 default 키워드를 사용하면 메소드의 바디부까지 작성이 가능하다.(JDK 1.8부터 추가)*/
    public default void defaultMethod() {

    }

    /* 설명. 접근 제어자가 private인 메소드는 메소드의 바디부까지 작성이 가능하다.(feat. default도 없이)*/
    /* 설명. private이기에 자식이 접근을 못하기 떄문.*/
    private void privateMethod() {

    }

    /* 설명. 바디부가 있다 == 오버라이딩을 무조건 할 필요는 없다. 정상적인 메소드이기에*/
}
