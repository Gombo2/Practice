package com.ohgiraffers.section04.constructor;

public class User {
    private String id;
    private String pwd;
    private String name;
    private java.util.Date enrollDate;

    /* 설명. 기본 생성자(매개변수가 없는)를 활용한 객체 생성(반드시 명시적으로 쓰자!) */
    public User() {
        System.out.println("기본 생성자 호출");
    }

    /* 설명. 원하는 필드를 초기화 하기 위한 매개변수 있는 생성자를 활용해 객체를 생성할 수 있다. */
    public User(String id, String pwd, String name) {
        System.out.println("매개변수 있는 생성자 호출");
        
        /* 설명. 생성자 안에서의 this.은 이 생성자로 만들어질 객체에 접근하는 것이다. */
        this.id = id;
        this.pwd = pwd;
        this.name = name;
    }

    public User(String id, String pwd, String name, java.util.Date enrollDate) {
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
                + ", enrollDate: " + this.enrollDate;
    }
}
