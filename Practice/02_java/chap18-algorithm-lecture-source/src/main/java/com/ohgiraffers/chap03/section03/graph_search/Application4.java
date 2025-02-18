package com.ohgiraffers.chap03.section03.graph_search;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Application4 {

    /* 설명. 양방향이므로 1차원 배열의 visit 배열 */
    static boolean[] visit;
    static int[][] arr;
    static int node;
    static int line;
    static int start;
    static Queue<Integer> q = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();

    public static BufferedReader toBufferedReader(String str) {
        InputStream is = new ByteArrayInputStream(str.getBytes());
        return new BufferedReader(new InputStreamReader(is));
    }

    public static String solution(String input) throws IOException {

        /* 설명. 여러개의 테스트 코드가 존재하기에 StringBuilder에 쌓인 값들을 지워 초기화 해주어야한다. */
        sb.delete(0, sb.length());

        BufferedReader br = toBufferedReader(input);

        StringTokenizer str1 = new StringTokenizer(br.readLine());

        node = Integer.parseInt(str1.nextToken());
        line = Integer.parseInt(str1.nextToken());
        start = Integer.parseInt(str1.nextToken());     //시작할 노드의 번호

        arr = new int[node + 1][node + 1];
        visit = new boolean[node + 1];


        for (int i = 0; i <= line; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = arr[b][a] = 1;
        }
        dfs(start);
        sb.append("\n");


        visit = new boolean[node + 1];

        bfs(start);

        return sb.toString();
    }

    private static void dfs(int start) {
        visit[start] = true;
        sb.append(start + " ");

        for(int i = 1; i <= node; i++) {
            if(arr[start][i] == 1 && !visit[i]) {
                dfs(i);
            }
        }
    }

    private static void bfs(int start) {
        q.offer(start);
        visit[start] = true;

        while(!q.isEmpty()) {
            start = q.poll();
            sb.append(start + " ");

            for(int i = 1; i<= node; i++) {
                if(arr[start][i] == 1 && !visit[i]) {
                    q.offer(i);
                    visit[i] = true;
                }
            }
        }
    }


}
