package com.ohgiraffers.section03.filterstream.dto;

import java.io.Serializable;

/* 궁금. 객체 입력 단위를 하기 위해선 implements Serializable이 필요하다.*/
public class MemberDTO implements Serializable {

    /* 설명. transient 키워드가 달린 필드는 객체 입출력 시(직렬화 시 대상이 되지 않는다.) 출력 되지 않는다.*/
    private String id;
    private transient String pwd;
    private String name;
    private String email;
    private int age;
    private char gender;

    public MemberDTO() {

    }

    public MemberDTO(String id, String pwd, String name, String email, int age, char gender) {
        this.id = id;
        this.pwd = pwd;
        this.name = name;
        this.email = email;
        this.age = age;
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public String getPwd() {
        return pwd;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public char getGender() {
        return gender;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "id='" + id + '\'' +
                ", pwd='" + pwd + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }
}
