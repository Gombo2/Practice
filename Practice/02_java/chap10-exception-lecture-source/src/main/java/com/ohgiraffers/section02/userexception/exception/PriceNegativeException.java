package com.ohgiraffers.section02.userexception.exception;

public class PriceNegativeException extends Exception { //Exception을 상속받으면 예외 클래스가 된다.

    public PriceNegativeException(String message) { //생성자를 만들지 않으면 unhandled excpetion이라고 함.
        super(message);
    }
}
