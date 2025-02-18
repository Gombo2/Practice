package com.ohgiraffers.section03.increment;

public class Application1 {
    public static void main(String[] args) {

        /* 수업목표. 단항 연산자이자 증감연산자에 대해 이해하고 활용할 수 있다. */
        int num = 20;
        System.out.println("num = " + num);

        num++;          // 후위 연산자
        System.out.println("num = " + num);

        ++num;          // 전위 연산자
        System.out.println("num = " + num);

        num--;
        System.out.println("num = " + num);

        --num;
        System.out.println("num = " + num);

        /* 설명. 다른 연산자와 함께 쓰이거나 출력문 안에서는 전위/후위 연산자가 해석의 차이를 일으킨다. */
        int firstNum = 20;
        int result = firstNum++ + 3;
        System.out.println("result = " + result);           // 23
        System.out.println("firstNum = " + firstNum);       // 21
        System.out.println("firstNum++ = " + firstNum++);   // 21
        System.out.println("firstNum = " + firstNum);       // 22

        int a = 3;
        int b = 5;
        int c = -1;
        int d = a + --b;
        b = 2 * (-c + a++) - d;
        c *= 2;
        a = b++ + c;

        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
        System.out.println("d = " + d);

    }
}
