package com.ohgiraffers.section01.method;

public class Application1 {
    public static void main(String[] args) {

        /* 수업목표. 메소드의 호출 흐름에 대해 이해할 수 있다. */
        System.out.println("main() 시작함...");
        methodA();
        System.out.println("main() 종료함...");
    }

    public static void methodA() {
        System.out.println("methodA() 호출됨...");
        methodB();
        System.out.println("methodA() 종료됨...");
    }
    
    public static void methodB() {
        System.out.println("methodB() 호출됨...");
        System.out.println("methodB() 종료됨...");
    }
}
