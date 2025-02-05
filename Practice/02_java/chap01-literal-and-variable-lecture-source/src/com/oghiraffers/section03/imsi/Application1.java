package com.oghiraffers.section03.imsi;

import java.sql.SQLOutput;

public class Application1 {
    public static void main(String[] args) {

        /* 수업목표. 상수에 대해 이해하고 사용할 수 있다. */
        final int AGE;

        AGE = 10;
//        AGE = 20;         // 초기화 이후 값을 담을 수 없다.

        System.out.println("AGE = " + AGE);

        /* 설명. 프로그램 전체에서 고정해서 사용할 값을 지정할 용도 */
        final double PI = 3.14;

    }
}
