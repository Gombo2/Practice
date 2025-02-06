package com.ohgiraffers.section01.exception;

public class Application {
    public static void main(String[] args) {
        ExceptionTest et = new ExceptionTest();

        try {
            et.checkEnoughtMoney(10000, 50000);
//            et.checkEnoughtMoney(50000, 10000);
            System.out.println("예외가 없었군요. 돈이 많으신가봐요?");
        } catch (ArithmeticException e) {
            System.out.println("예외가 발생했군요!");


            System.out.println("그 예외는 " + e.getMessage() + " 때문이군요!!!!");
            System.out.println("거 돈 좀 넉넉히 들고 다닙시다.");
//        System.exit(0);       // 자바 어플리케이션이 즉시 종료되도록 처리
        }

        System.out.println("프로그램을 종료합니다.");
    }
}
