package com.ohgiraffers.section02.dimensional;

import java.util.Arrays;

public class Application1 {
    public static void main(String[] args) {

        /* 수업목표. 다차원 배열의 구조를 이해하고 사용할 수 있다. */
        /* 설명.
         *  다차원 배열
         *   다차원 배열은 2차원 이상의 배열을 의미한다.
         *   (일반적으로 3차원 정도까지 고려한다.(∵사람의 인지 범위))
        * */

        int[][] iArr1;
        int[] iArr2[];      // 추천 X
        int iArr3 [][];     // 추천 X

        iArr1 = new int[3][2];             // 정변 배열
        iArr2 = new int[3][];              // 가변 배열

        int num = 0;
        for (int i = 0; i < iArr1.length; i++) {
            System.out.println("iArr1[i]: " + iArr1[i]);
            for (int j = 0; j < iArr1[i].length; j++) {     // iArr1[i].length: i번째에서 관리되는 배열의 길이
                iArr1[i][j] = ++num;
            }
            System.out.println(Arrays.toString(iArr1[i]));
            System.out.println(System.identityHashCode(iArr1[i]));
        }

        /* 설명. 가변배열에 다양한 길이의 1차원 배열을 적용해 보자. */
        iArr2[0] = new int[]{1, 2, 3};
        iArr2[1] = new int[]{1, 2, 3, 4};
        iArr2[2] = new int[]{3, 3};

        /* 설명. 1차원 배열을 출력하는 구문을 관리되는 1차원 배열의 갯수만큼 진행 */
        for (int i = 0; i < iArr2.length; i++) {
            System.out.println(Arrays.toString(iArr2[i]));
        }
    }
}
