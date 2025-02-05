package com.ohgiraffers.section02.package_and_import;

import com.ohgiraffers.section01.method.Calculator;

public class Application2 {
    public static void main(String[] args) {


        /* 수업목표. import에 대해 이해할 수 있다.*/
        Calculator cal = new Calculator();
        int result = cal.plusTwoNumbers(10, 2);
        System.out.println("result = " + result);

        result = Calculator.maxNumbersOf(10, 30);
        System.out.println("result = " + result);
    }
}
