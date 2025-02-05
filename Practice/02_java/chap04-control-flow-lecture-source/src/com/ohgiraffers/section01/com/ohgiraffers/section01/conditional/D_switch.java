package com.ohgiraffers.section01.com.ohgiraffers.section01.conditional;

import java.util.Scanner;

public class D_switch {
    public static void testSimpleSwitchStatement() {
        Scanner sc = new Scanner(System.in);

        System.out.println("등급을 입력하세요(G, S, B): ");
        char grade = sc.next().charAt(0);  //method chaining
        System.out.println("grade = " + grade);
        boolean flag = true;
        int point = 0;

        switch (grade) {
            case 'G':
                point += 10;
            case 'S':
                point += 10;
            case 'B':
                point += 10;
                break;
            default:
                System.out.println("거 입력 똑바로 합시다!");
        }

        if(flag == true) {
            System.out.println("당신의 등급은 " + grade + "이고, 현재 포인트는 " + point + "입니다.");
        } else {
            System.out.println("등급도 모르는 거 같으니 이참에 회원가입 고고씽!~");
        }

    }
}
