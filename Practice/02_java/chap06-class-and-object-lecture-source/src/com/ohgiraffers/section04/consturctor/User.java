package com.ohgiraffers.section04.consturctor;

import java.util.Date;

public class User {
    /* 설명. 메소드 안이 아닌 곳에서 생성한 변수들 - > field 라고 부름 (클래스의 속성) */
    private String id;
    private String pwd;
    private String name;
    private java.util.Date enrollDate;

    /* 설명. 기본 생성자(매개변수가 없는)를 활용한 객체 생성(반드시 명시적으로 쓰자!) */
    // 기본적으로 없으면 자바에서 자동으로 만들어주지만 생성자가 없으면 객체 생성이 절대 불가능하다.
    public User() {  //반환형이 없는 메소드. 생성자
        System.out.println("기본 생성자 호출");
    }

    /* 설명. 매개변수 있는 생성자 생성시 자바에서 public User()를 만등러주지 않는다. 주석처리하면 에러남. */
    /* 설명. 생성자 안에서의 this.은 이 생성자로 만들어질 객체에 접근하는 것이다. */
    /* 설명. 원하는 필드를 초기화 하기 위한 매변수 있는 생성자를 활용해 객체를 설정할 수 있다. */
    public User(String id, String pwd, String name) {
        System.out.println("매개변수 있는 생성자 호출");

        this.id = id;  //생성자 안의 this.는 생성자로 만들어질 객체의 this임.
        this.pwd = pwd;
        this.name = name;
    }

    public User(String id, String pwd, String name, Date enrollDate) {
//        this.id = id;
//        this.pwd = pwd;
//        this.name = name;
        /* 설명. this()를 통해 다른 생성자를 활용하여 코드의 줄 수를 줄일 수 있다. */
        /* 설명. 참고로 this()는 항상 첫 줄에 작성되어야 하며 2개 이상 작성할 수 없다. */
        this(id, pwd, name);
        this.enrollDate = enrollDate;
    }

    public String information() {
        return "id: " + this.id + ", pwd: " + this.pwd + ", name: " + this.name
                + ", enrollDate: " + this.enrollDate; //this. 생략해도 동일함.
    }
}
