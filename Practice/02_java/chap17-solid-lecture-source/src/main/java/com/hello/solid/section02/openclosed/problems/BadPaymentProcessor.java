package com.hello.solid.section02.openclosed.problems;

public class BadPaymentProcessor {
    public void processPayment(String paymentType) {

        if (paymentType.equals("credit")) {
            System.out.println("신용카드로 결제를 처리합니다.");
        } else if (paymentType.equals("kakao")) {
            System.out.println("카카오페이로 결제를 처리합니다.");
        }

        /* 설명. 새로운 결제 수단을 추가하려면 이 클래스를 수정해야 한다. */
    }
}
