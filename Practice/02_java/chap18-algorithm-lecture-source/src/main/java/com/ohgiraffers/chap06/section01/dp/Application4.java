package com.ohgiraffers.chap06.section01.dp;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Application4 {

    public static BufferedReader toBufferedReader(String str) {
        InputStream is = new ByteArrayInputStream(str.getBytes());
        return new BufferedReader(new InputStreamReader(is));
    }

    public static int solution(String input) throws IOException {
        BufferedReader br = toBufferedReader(input);

        int n = Integer.parseInt(br.readLine());  //층 수

        int[][] dp = new int[n + 1][n + 1];       //dp 배열(누적값 담을 배열)
        int[][] p = new int[n + 1][n + 1];        //입력값 존재 배열

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= i; j++) {
                p[i][j] = Integer.parseInt(st.nextToken()); // 각 depth의 갯수만큼 토큰이 들어있음.
            }
//            System.out.println("p[i] = " + Arrays.toString(p[i]));
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                /* 설명. dp배열의 한층 위의 좌상단/ 우상단 값 중 큰 값과 자신의 값을 더한다.*/
                dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j])+p[i][j];
            }
        }

        int max_ans = 0;

        for(int i = 1; i<= n; i++) {
            if(max_ans < dp[n][i]) {
                max_ans = dp[n][i];
            }
        }

        return max_ans;
    }
}
