package com.ohgiraffers.chap06.section01.dp;

public class Application2 {


    public static Integer solution(int input) {
       int[] dp = new int[1000 + 1];
       dp[1] = 1;
       dp[2] = 2;

       for(int i = 3; i <= input; i++) {
           dp[i] = dp[i - 1] + dp[i - 2];
       }
       return dp[input];
    }
}
