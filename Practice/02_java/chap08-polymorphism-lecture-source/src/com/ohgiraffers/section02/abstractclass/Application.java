package com.ohgiraffers.section02.abstractclass;

public class Application {
    public static void main(String[] args) {
//        Product p = new Product();

            Phone smartPhone = new Phone();
            smartPhone.abstractMethod();

            Product smartPhone2 = new Phone();          // 다형성 적용
            smartPhone2.abstractMethod();
    }
}
