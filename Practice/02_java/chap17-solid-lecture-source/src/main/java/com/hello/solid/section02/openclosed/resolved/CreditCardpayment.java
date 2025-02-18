package com.hello.solid.section02.openclosed.resolved;

public class CreditCardpayment implements Payment {
    @Override
    public void prodcess() {
        System.out.println("신용카드로 결제 처리");
    }
}
