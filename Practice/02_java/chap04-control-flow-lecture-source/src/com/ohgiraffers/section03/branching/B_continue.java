package com.ohgiraffers.section03.branching;

public class B_continue {
    public static void testSimpleContinueStatement() {

        /* 설명. 1부터 100까지 증가하면서 4와 5의 공배수일 경우 출력 */
        for (int i = 1; i <= 100 ; i++) {
            if (!(i % 4 == 0 && i % 5 == 0)) {
                continue;       // 반복문의 나머지 구문을 건너뛰고 다음 스텝으로 이동(증감식으로 이동)
            }

            System.out.println(i + "는 4와 5의 공배수입니다.");
        }
    }
}
