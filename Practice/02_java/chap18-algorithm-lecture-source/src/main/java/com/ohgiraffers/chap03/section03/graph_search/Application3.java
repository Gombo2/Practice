package com.ohgiraffers.chap03.section03.graph_search;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Application3 {

    static boolean[][] visit;
    static int[][] map;
    static int[] dirX = {0, 0, -1, 1};
    static int[] dirY = {1, -1, 0, 0};
    static int N;
    static int M;

    public static BufferedReader toBufferedReader(String str) {
        InputStream is = new ByteArrayInputStream(str.getBytes());
        return new BufferedReader(new InputStreamReader(is));
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

        bfs(0, 0);      // 도착지(우하단) 위치까지 BFS가 돌아가며 알고리즘 진행

        return map[N - 1][M - 1]; // 마지막 칸 까지가는 최적의 경로 수
    }

    private static void bfs(int y, int x) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));

        while (!q.isEmpty()) {
            Node n = q.poll();

            /* 설명. 상하좌우를 둘러보는 개념의 for문 */
            for (int i = 0; i < 4; i++) {
                int curX = n.x + dirX[i];
                int curY = n.y + dirY[i];


                /* 설명. 상하좌우를 둘러볼 때 미로 범위를 넘어가면 다른 방향을 보도록 한다. */
                if (curX < 0 || curY < 0 || curX >= M || curY >= N) {
                    continue;
                }

                /* 설명. 방문했거나, 벽을 만나면 */
                if (visit[curY][curX] || map[curY][curX] == 0) {
                    continue;
                }

                q.offer(new Node(curX, curY));
                map[curY][curX] = map[n.x][n.y] + 1;

                System.out.println("curX = " + curX);
                System.out.println("curY = " + curY);
                System.out.println("map[curY][curX] = " + map[curY][curX]);

                visit[curY][curX] = true;
            }
        }

    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
