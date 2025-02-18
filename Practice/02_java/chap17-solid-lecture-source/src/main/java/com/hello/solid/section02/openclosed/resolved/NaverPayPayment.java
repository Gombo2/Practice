package com.hello.solid.section02.openclosed.resolved;

public class NaverPayPayment implements Payment {
    @Override
    public void prodcess() {
        System.out.println("네이버페이로 결제 처리");
    }
}
