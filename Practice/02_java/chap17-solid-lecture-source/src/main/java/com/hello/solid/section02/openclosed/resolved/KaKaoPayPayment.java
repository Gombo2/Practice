package com.hello.solid.section02.openclosed.resolved;

public class KaKaoPayPayment implements Payment {
    @Override
    public void prodcess() {
        System.out.println("카카오페이로 결제 처리");
    }
}
