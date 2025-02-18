package com.ohgiraffers.section03.branching;

public class A_break {
    public static void testSimpleBreakStatement() {
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += i;
            System.out.println("sum = " + sum);

            if(i == 3) break;   // 반복문을 멈추고자 할 때 조건문과 함께 break를 쓴다.
                                // 중첩 반복문일 때는 자신과 가장 가까운 반복문만 빠져 나간다.
        }
    }
}
