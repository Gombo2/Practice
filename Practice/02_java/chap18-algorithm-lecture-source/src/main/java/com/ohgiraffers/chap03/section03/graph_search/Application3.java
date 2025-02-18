package com.ohgiraffers.chap03.section03.graph_search;

import java.io.*;
import java.util.StringTokenizer;

public class Application3 {

    public static BufferedReader toBufferedReader(String str) {
        InputStream is = new ByteArrayInputStream(str.getBytes());
        return new BufferedReader(new InputStreamReader(is));
    }

    static boolean[][] visit;
    static int[][] map;
    static int[] dirX = {0, 0, -1, 1};
    static int[] dirY = {1, -1, 0, 0};
    static int N;
    static int M;

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static Integer solution(String input) throws IOException {
        BufferedReader br = toBufferedReader(input);
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visit = new boolean[N][M];

        /* 설명. 입력값이 공백 없이 이어서 들어옴에 따라 한 문자씩 뜯어서 int 배열(map)에 옮겨담는 반복문 */
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            char[] chArr = str.toCharArray();                           // String char 배열로 바꾸는 메소드
            for (int j = 0; j < M; j++) {
                map[i][j] = Character.getNumericValue(chArr[j]);        //getNumericValue -> char형 그냥 받으면 아스키코드값
                                                                        //이기에 입력한 거 그대로 받으려고 사용.
            }
        }

        /* 설명. 시작과 동시에 첫 번째 칸 방문 체크 */
        visit[0][0] = true;

        dfs(0, 0);      // 도착지(우하단) 위치까지 DFS가 돌아가며 알고리즘 진행

        return map[N - 1][M - 1]; // 마지막 칸 까지가는 최적의 경로 수
    }

    private static void dfs(int y, int x) {

    }

}
