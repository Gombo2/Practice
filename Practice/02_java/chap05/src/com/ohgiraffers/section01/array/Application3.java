package com.ohgiraffers.section01.array;

import java.util.Arrays;

public class Application3 {
    public static void main(String[] args) {

        /* 수업목표. 배열에 초기화 되는 자료형별 기본값을 이해할 수 있다. */
        /* 설명.
        *   값의 형태별 기본값
        *   정수 : 0
        *   실수 : 0.0
        *   논리 : false
        *   문자 : \u0000
        *   참조 : null
        * */

        /* 설명. 선언과 동시에 크기 할당 및 초기화를 한번에 진행하고 싶을 때 */
        int[] iArr = {10, 11, 12, 13, 14};
        int[] iArr2 = new int[]{10, 11, 12, 13, 14};

        /* 설명. new int[]을 생략하는 안되는 경우 */
//        test({10, 11, 12, 13, 14});  //에러 발생
//        test(new int[]{10, 11, 12, 13, 14}); // test(배열의 쪽지)

        /* 설명. 1. 단순 for문 */
        for(int i = 0; i < iArr.length; i++) {
            System.out.println(iArr[i]);
        }

        /* 설명. 2. 향상된 for문(foreach 문) -> 받아낼 변수를 활용해 처음부터 끝까지 순회하고자 할 때 쓸 수 있다. */
        for(int i : iArr) {
            System.out.println(i);
        }

        /* 설명. 3. 배열의 값들을 단순 확인 */
        System.out.println(Arrays.toString(iArr));
    }

    public static void test(int[] arr) {

    }
}
