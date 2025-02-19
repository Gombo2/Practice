package com.ohgiraffers.chap04.section01.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


/* 설명. 람다식을 활용한 풀이. */
public class Application3_1 {
    public static BufferedReader toBufferedReader(String str) {
        InputStream is = new ByteArrayInputStream(str.getBytes());
        return new BufferedReader(new InputStreamReader(is));
    }

    public static Integer solution(String input) throws IOException {
        int max_count = 0;

        BufferedReader br = toBufferedReader(input);
        int N = Integer.parseInt(br.readLine());            // 회의 수
        int[][] time = new int[N][2];                       // 회의 시간 배열

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            time[i][0] = Integer.parseInt(st.nextToken());  // 시작 시간
            time[i][1] = Integer.parseInt(st.nextToken());  // 종료 시간

        }

        Arrays.sort(time, (o1, o2) -> {
            if(o1[1] == o2[1]) {        // 종료 시간이 같다면
                return o2[0] - o1[0];   // 시작 시간은 내림차순
            }

            return o1[1] - o2[1];
        });

        return max_count;
    }
}
