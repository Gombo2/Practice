package com.ohgiraffers.section01.method;

public class Application3 {

    static int global = 10;

    public static void main(String[] args) {

        /* 수업목표. 메소드 전달인자(argument)와 매개변수(parameter)에 대해 이해하 고메소드 호출 시 활용할 수 있다.*/
        /* 설명.
        *    변수를 선언한 위치에 따라 구분할 수도 있다.
        *    1. 지역변수
        *    2. 전역변수
        *    3. 매개변수
        * */

        System.out.println("전역 변수 : " + global);

        Application3 app3 = new Application3();
        app3.testMethod(13);
        app3.testMethod(11);
        app3.testMethod('a');

        int local = 20;
        System.out.println("지역 변수 : " + local);
    }

    public void testMethod(int n) {
        System.out.println("당신의 나이는 " + n + " 세 입니다. ");
    }
}
