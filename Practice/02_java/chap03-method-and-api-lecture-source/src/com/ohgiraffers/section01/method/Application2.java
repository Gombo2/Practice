package com.ohgiraffers.section01.method;

public class Application2 {
    public static void main(String[] args) {
        System.out.println("main() 시작됨...");

        /* 설명. non-static 메소드인 경우 메소드를 new 연산자로 인지시켜 호출할 수 있다. */
        Application2 app = new Application2();
        app.methodA();
        app.methodB();

        System.out.println("main() 종료됨...");
    }
    
    public void methodA() {
        System.out.println("methodA() 호출됨...");
        System.out.println("methodA() 종료됨...");
    }

    public void methodB() {
        System.out.println("methodB() 호출됨...");
        System.out.println("methodB() 종료됨...");
    }
}
