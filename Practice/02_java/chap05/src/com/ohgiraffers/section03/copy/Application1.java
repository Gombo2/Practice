package com.ohgiraffers.section03.copy;

import java.util.Arrays;

public class Application1 {
    public static void main(String[] args) {

        /* 수업목표. 배열의 복사 개념 중 얕은 복사에 대해 이해할 수 있다. */
        /* 설명.
         *   배열의 복사에는 크게 두가지 개녕미 잇다.
         *   1. 얕은 복사(shallow copy): stack의 주소 값만 복사
         *   2. 깊은 복사(deep copy): heap의 배열에 저장된 값을 복사
         *  */

        int[] originArr = {1, 2, 3};
        int[] copyArr = originArr;      //Shallow copy

        System.out.println(Arrays.toString(copyArr));

        copyArr[2] = 100;
        System.out.println(Arrays.toString(originArr));

        /* 설명. 메소드를 호출에서 넘기는 전달인자가 참조 자료형(주소값)일 경우
            얕은 복사가 일어난다.(feat.call by reference) */
        test(originArr);
    }

    public static void test(int[] arr) {
        System.out.println("메소드 안: " + Arrays.toString(arr));
    }
}
