package com.ohgiraffers.chap04.section01.greedy;

import java.io.IOException;

public class Application1 {


    public static int solution(int n) throws IOException {

        /* 설명. 5킬로 봉지 또는 3킬로 봉지로 가져갈 수 있는 최소 봉지의 수 */
        int count = 0;

        while (true) {
            if (n % 5 == 0) {    // 남은 설탕을 5kg 봉지로 해결할 수 있는 경우
                return (n / 5) + count;
            } else {
                n -= 3;
                count++;
            }

            if (n == 0) {        //마지막에 3kg 봉지로 해결한 경우
                break;
            }

            if (n < 0) {         //가지고있는 5,3kg로 해결 못하는 경우.
                return -1;
            }
        }

        return count;
    }
}
