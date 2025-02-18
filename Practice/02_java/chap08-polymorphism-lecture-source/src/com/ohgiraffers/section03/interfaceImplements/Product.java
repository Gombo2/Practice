package com.ohgiraffers.section03.interfaceImplements;

import java.io.Serializable;

public class Product implements InterProduct, Serializable {
    @Override
    public void nonStaticMethod() {
        System.out.println("InterProduct의 nonStaticMethod 오버라이딩 메소드...");
    }
}
