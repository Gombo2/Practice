package com.ohgiraffers.chap04.section01.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/* 설명. 람다식을 활용한 풀이 */
public class Application3_1 {
    public static BufferedReader toBufferedReader(String str) {
        InputStream is = new ByteArrayInputStream(str.getBytes());
        return new BufferedReader(new InputStreamReader(is));
    }

    public static int solution(String input) throws IOException {
        int max_count = 0;

        BufferedReader br = toBufferedReader(input);
        int N = Integer.parseInt(br.readLine());                // 회의 수
        int[][] time = new int[N][2];                           // 회의 시간 배열(시작/종료)

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            time[i][0] = Integer.parseInt(st.nextToken());      // 시작 시간
            time[i][1] = Integer.parseInt(st.nextToken());      // 종료 시간
        }

        /* 설명. o1/o2는 각각의 회의를 뜻하고 두 개의 회의가 람다식에 넘어온(결과적으로 이차원 배열 안의 1차원 배열 순서가 정렬 됨) */
        Arrays.sort(time, (o1, o2) -> {

            /* 설명. 종료 시간이 같은 회의에 대해서는 */
            if (o1[1] == o2[1]) {           // 종료 시간이 같다면
                return o2[0] - o1[0];       // 시작 시간은 내림차순
            }

            /* 설명. 종료 시간이 다른 회의에 대해서는 */
            return o1[1] - o2[1];           // 종료 시간은 오름차순
        });

        int end = 0;
        int same = 0;

        /* 설명. 조건을 만족하는 회의들의 count를 증가시키는 반복문 */
        for (int i = 0; i < N; i++) {

            /* 설명. 최소한 앞선 회의의 끝나는 시간 이후에 열리는 i번째 회의라면 */
            if(end <= time[i][0] && same <= time[i][0]) {

                if(time[i][0] == time[i][1]) {
                    max_count++;
                    same = time[i][1];
                    continue;           // 종료 시간에 영향을 주지 않는다.
                }
                end = time[i][1];       // 진행된 회의의 end시간으로 업데이트
                max_count++;
            }
        }

        return max_count;
    }
}