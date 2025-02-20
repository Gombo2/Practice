package com.ohgiraffers.assertions.section01.jupiter;

//유효성 검사기 (service 계층에서 생성)
public class NumberValidator {
    //유효성 검사
    public void checkDividableNumbers(int firstNum, int secondNum) {
        if(secondNum == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다!");     // 전달인자가 잘못 되었다.
        }
    }
}
