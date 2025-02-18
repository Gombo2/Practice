package com.ohgiraffers.section02.looping;

import java.util.Scanner;

public class C_while {
    public void testSimpleWhileStatement() {

        int i = 1;
        while (i <= 10) {
            System.out.println("i = " + i);
            i++;
        }
    }

    /* 설명. while은 주로 사용자의 입력값에 따라 반복 횟수가 정해지는 형태에서 쓰인다. */
    public void testWhileExample() {
        Scanner sc = new Scanner(System.in);
        
        /* 설명. 'y' 또는 'Y'를 입력하면 반복을 멈추는 while문 작성 */
        char answer = '\0';
        while(!(answer == 'y' || answer == 'Y')) {
            System.out.print("이 지옥에서 탈출하고 싶다면 'y' 또는 'Y'를 누르시오: ");
            answer = sc.next().charAt(0);
        }

        System.out.println("천국에 오신 것을 환영합니다!");
    }
}
