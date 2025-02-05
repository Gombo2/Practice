package com.ohgiraffers.section02.abstractclass;

public class Phone extends Product {
    public Phone() {
        super();
    }

    @Override
    public void abstractMethod() {
        System.out.println("안 빼먹고 오버라이딩 했다잉~");
    }
}
