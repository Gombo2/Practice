package com.ohgiraffers.section02;

import java.util.Scanner;

public class B_nestedFor {
    public void printGugudanFromTwoToNine() {
        /* 설명.
        *   2단
        *    2 * 1 = 2 / 2 * 2 = 4 ....
        *   9단
        *    9 * 1 = 9 / 9 * 2 = 18 .... 9 * 9 = 81
        *  */
        int sum = 1;
        for(int dan = 2; dan <= 9; dan++) {
            System.out.println(dan + "단");
            printGugudanOf(dan);
        }
    }

    /* 설명. dan을 넘겨주면 해당 단수의 구구단을 출력하는 메소드.  */
    private static void printGugudanOf(int dan) {
        for(int su = 1; su <= 9; su++) {
            System.out.println(dan + " * " + su + " = " + dan *su);
        }
    }


    /* 설명.
     *   아래와 같은 별양이 나오도록 작성해 보자.
     *   정수를 입력하시오 : 5
     *      *
     *     **
     *    ***
     *   ****
     *  *****
     *  */

    public void printStarts() {
        Scanner sc = new Scanner(System.in);
        System.out.println("정수를 입력하시오 : ");
        int input = sc.nextInt();

        printStars(input);

    }

    private static void printStars(int input) {
        for(int i = 1; i <= input; i++) {
                for(int j = 0; j < (input -i); j++) {
                    System.out.print(" ");
                }
                for(int k = 0; k < i; k++) {
                    System.out.print("*");
                }
            System.out.println();
                /* 설명. 공백 찍기 */

                /* 설명. 별 찍기 */
        }
    }

}
