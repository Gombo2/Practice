package com.ohgiraffers.section02.abstractclass;

public abstract class Product {
    private int nonStaticField;
    private static int staticField;

    public Product() {
    }

    public void nonStaticMethod() {}

    public static void staticMethod() {}

    /* 설명. 추상메소드가 하나라도 있다면 해당 클래스는 추상 클래스가 되어야 된다. */
    public abstract void abstractMethod();
}
