package com.ohgiraffers.section02.looping;

import java.util.Scanner;

public class B_nestedFor {
    public void printGugudanFromTwoToNine() {

        /* 설명.
         *  2단
         *   2 * 1 = 2
         *   2 * 2 = 4
         *   ...
         *  9단
         *   9 * 1 = 9
         *   9 * 2 = 18
         *   ...
         *   9 * 9 = 81
        * */
//        for (int dan = 2; dan <= 9; dan++) {
//            System.out.println(dan + "단");
//            for (int su = 1; su <= 9; su++) {
//                System.out.println(dan + " * " + su + " = " + (dan * su));
//            }
//            System.out.println();
//        }

        for (int dan = 2; dan <= 9; dan++) {
            System.out.println(dan + "단");
            printGugudanOf(dan);
            System.out.println();
        }
    }

    /* 설명. dan을 넘겨주면 해당 단수의 구구단을 출력하는 메소드 */
    private void printGugudanOf(int dan) {
        for (int su = 1; su <= 9; su++) {
            System.out.println(dan + " * " + su + " = " + (dan * su));
        }
    }


    /*설명.
     * 아래와 같은 별모양이 나오도록 작성해 보자.
     * 정수를 입력하시오: 5
     *     *
     *    **
     *   ***
     *  ****
     * *****
    * */
    public void printStars() {
        Scanner sc = new Scanner(System.in);
        System.out.print("정수를 입력하시오: ");
        int input = sc.nextInt();
        for (int i = 0; i < input; i++) {

            /* 설명. 공백 찍기 */
            printSpace(input, i);

            /* 설명. 별 찍기 */
            printStars(i);
            System.out.println();
        }
    }

    private void printStars(int row) {
        for (int j = 0; j < (row + 1); j++) {
            System.out.print("*");
        }
    }

    private void printSpace(int input, int row) {
        for (int j = 0; j < input - (row + 1); j++) {
            System.out.print(" ");
        }
    }
}
