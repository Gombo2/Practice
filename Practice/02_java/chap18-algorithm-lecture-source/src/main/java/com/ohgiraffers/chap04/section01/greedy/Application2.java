package com.ohgiraffers.chap04.section01.greedy;

import java.io.*;
import java.util.StringTokenizer;

public class Application2 {
    public static BufferedReader toBufferedReader(String str) {
        InputStream is = new ByteArrayInputStream(str.getBytes());
        return new BufferedReader(new InputStreamReader(is));
    }

    public static int solution(String input) throws IOException {
        BufferedReader br = toBufferedReader(input);

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());       // 동전 종류의 수
        int K = Integer.parseInt(st.nextToken());       // 계산할 금액

        int[] coin = new int[N];                        // 동전의 종류들을 담을 배열
        for (int i = 0; i < coin.length; i++) {
            coin[i] = Integer.parseInt(br.readLine());

        }
        int count = 0;

        for (int i = N-1; i >= 0; i--) {
            if(coin[i] <= K) {

                /* 설명. 현재의 동전 종류로 최대 지불할 수 있는 금액 */
                count += K / coin[i];    // 문제를 해결하기 위한 동전이 2개 이상일 경우를 감안(누적)

                /* 설명. 큰 금액의 동전으로 처리하고 남는 금액을 K에 대입(다음 동전 단위를 위해) */
//                K = K - coin[i] * count;
//                K = K % coin[i];
                K %= coin[i];
            }

            /* 설명. 1원까지 있어 else는 고려하지 않는다.(실제 문제도 가진 동전으로 해결할 수 있는 K원이 주어진다.) */
        }

        return count;
    }
}