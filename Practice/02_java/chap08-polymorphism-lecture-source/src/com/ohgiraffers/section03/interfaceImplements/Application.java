package com.ohgiraffers.section03.interfaceImplements;

import java.io.Serializable;

public class Application {
    public static void main(String[] args) {

        /* 수업목표. 인터페이스(inteface)에 대해 이해할 수 있다.*/
        /* 설명.
        *   인터페이스란?
        *    자바의 클래스와 유사한 형태지만 상수필드(public statitc final)와
        *    추상메소드(public abstract)만 가질 수 있는 클래스의 변형체이다.
        * */

//        InterProduct ip1 = new InterProduct(); //당연히 에러남
        Product p = new Product();
//        Serializable p2 = new Product();
        InterProduct p2 = new Product();        //인터페이스도 다형성 적용 가능.
        p2.nonStaticMethod();
    }
}
