package com.ohgiraffers.chap06.section01.dp;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Application5 {

    public static BufferedReader toBufferedReader(String str) {
        InputStream is = new ByteArrayInputStream(str.getBytes());
        return new BufferedReader(new InputStreamReader(is));
    }

    public static int solution(String input) {
        BufferedReader br = toBufferedReader(input);

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[i + 1];
        int[] arr = new int[i + 1];

        for(int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        if(n >= 1) {
            dp[1] = arr[1];
        }

        if(n >= 2) {
            dp[2] = arr[1] + arr[2];
        }

        for(int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + arr[i - 1]) + arr[i];
        }

        return dp[n];
    }
}
