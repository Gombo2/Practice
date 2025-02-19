package com.ohgiraffers.chap06.section01.dp;

public class Application3 {
    /* 설명. NULL을 활용하기 위해 Integer 배열로 객체 생성 */
    public static Integer[] dp = new Integer[101];


    public static int solution(int n) {
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;


        return padovan(n);
    }


    /* 설명. 재귀 호출에 의한 stackoverflow를 막기 위해 null이 아닌 값을 만날 때까지만 */
    private static int padovan(int n) {
        if(dp[n] == null) {
            dp[n] = padovan(n - 2) + padovan(n - 3); // n 앞 부분의 dp를 채우기 위해 재귀호출
        }
        return dp[n];
    }
}
