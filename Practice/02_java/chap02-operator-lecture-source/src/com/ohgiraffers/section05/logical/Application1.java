package com.ohgiraffers.section05.logical;

public class Application1 {
    public static void main(String[] args) {

        /* 수업목표. 논리 연산자에 대해 이해하고 활용할 수 있다. */
        /* 설명.
        *   논리연산자의 종류
        *   1. 논리 연결 연산자
        *    1-1. &&(논리 AND) : 두 논리값(또는 논리식)이 둘 다 참이면 참이고 나머지는 거짓
        *    1-2. ||(논리 OR) : 두 논리값(또는 논리식)이 모두 거짓이면 거짓이고 나머지는 참
        *   2. 논리 부정 연산자
        *    2-1. !(논리 NOT): 논리식의 결과가 참이면 거짓으로, 거짓이면 참으로 변환
        * */

        /* 목차. 1. 논리 연산자 결과값 확인*/
        System.out.println(true && true);
        System.out.println(true && false);
        System.out.println(false && true);
        System.out.println(false && false);
        System.out.println();
        System.out.println(true || true);
        System.out.println(true || false);
        System.out.println(false || true);
        System.out.println(false || false);
        System.out.println();
        System.out.println(!true);
        System.out.println(!false);

        /* 목차. 2. 논리식에 논리 연산자 활용 */
        int num1 = 10;
        int num2 = 20;
        int num3 = 30;
        int num4 = 40;

        System.out.println((num1 < num2) && (num3 < num4));
        System.out.println((num1 < num2) && (num3 > num4));
        System.out.println((num1 > num2) && (num3 < num4));
        System.out.println((num1 > num2) && (num3 > num4));
    }
}
