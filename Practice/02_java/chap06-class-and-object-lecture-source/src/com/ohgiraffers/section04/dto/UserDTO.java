package com.ohgiraffers.section04.dto;

import java.io.Serializable;
import java.util.Date;

/* 설명.
*   자바빈(Java Bean) 이란?
*   JSP에서 사용되는 표준 액션 태그로 접근할 수 있게 만든 자바 클래스형태이다.
*   자바 코드를 모르는 웹 퍼블리셔들도 자바 코드를 사용할 수 있도록 태그 형식으로 지원하는 문법을
*   의미하는데, 그 때 사용할 수 있도록 규칙을 저장해 놓은 java 클래스를 자바빈(Java Bean)이라고 부른다.
*   지금은 특정 목적 및 프레임워크를 통해 클래스를 작성하는 규칙이라고 보면 된다.
* */

/* 설명.
*   1. 자바빈은 특정 패키지에 속해 있어야 함(default 패키지 사용 금지)
*   2. 필드의 접근 제어자는 private로 선언해야 함(캡슐화 적용)
*   3. 기본 생성자가 명시적으로 존재해야 한다.(매개변수 있는 생성자는 선택사항)
*   4. 모든 필드에 접근 가능한 설정자(setter)와 접근자(getter)가 public으로 작성되어 있어야 함.
*   5. 직렬화(Serialization 구현)을 고려해야 한다.(선택사항) -> implements Serializable
* */
public class UserDTO  {
    private String id;
    private String pwd;
    private String name;
    private java.util.Date enrollDate;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public Date getEnrollDate() {
        return enrollDate;
    }

    public void setEnrollDate(Date enrollDate) {
        this.enrollDate = enrollDate;
    }

    @Override //같은 이름의 메소드가 받은 매개변수에 따라 다른 동작을 하게 해줌
    public String toString() { //this가 생략된 상태.
        return "UserDTO{" +
                "id='" + id + '\'' +
                ", pwd='" + pwd + '\'' +
                ", name='" + name + '\'' +
                ", enrollDate=" + enrollDate +
                '}';
    }
}

