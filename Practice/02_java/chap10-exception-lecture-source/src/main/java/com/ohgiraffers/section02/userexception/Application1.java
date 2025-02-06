package com.ohgiraffers.section02.userexception;

public class Application1 {
    public static void main(String[] args) {

        /* 수업목표. 사용자 정의형 예외 클래스 정의 후 발생한 사용자 예외들을 처리할 수 있다.*/
        ExceptionTest et = new ExceptionTest();
        et.checkEnoughMoney(30000, 40000);
    }
}
