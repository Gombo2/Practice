package com.ohgiraffers.chap04.section01.greedy;

public class Application1 {
    public static int solution(int n) {
        
        /* 설명. 5킬로 봉지 또는 3킬로 봉지로 가져갈 수 있는 최소 봉지의 수 */
        int count = 0;

        while(true) {
            if(n % 5 == 0) {            // 남은 설탕을 5kg 봉지로 해결할 수 있는 경우
                return n / 5 + count;
            } else {
//                n = n - 3;
                n-=3;
                count++;

                if(n == 0) break;       // 마지막에 3kg 봉지로 해결한 경우
                if(n < 0) return -1;    // 5kg 또는 3kg으로 해결할 수 없는 경우
            }
        }

        return count;
    }
}
