package com.ohgiraffers.chap05.section01.tree;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/* 수업목표. 트리(Tree) 알고리즘을 활용하는 예제를 이해할 수 있다. */
/* 설명.
 *  그래프에서 계층적인 구조를 나타내기 위해 최상위 노드인 루트(root) 노드에서 시작하여
 *  하위 노드들로 분기하는 방식으로 구성된 알고리즘이다.(일반적으로 이진트리만 다루게 된다.)
 * */
public class Application1 {

    static int N;
    static int[] parent;
    static boolean[] isVisit;
    static StringTokenizer st;
    static List<Integer>[] list;
    static StringBuilder sb = new StringBuilder();

    public static BufferedReader toBufferedReader(String str) {
        InputStream is = new ByteArrayInputStream(str.getBytes());
        return new BufferedReader(new InputStreamReader(is));
    }

    public static String solution(String input) throws IOException {
        BufferedReader br = toBufferedReader(input);
        sb.delete(0, sb.length());             // 알고리즘과는 무관하지만 테스트 코드 환경이라 앞선 내용 삭제

        N = Integer.parseInt(br.readLine());

        isVisit = new boolean[N + 1];
        list = new ArrayList[N + 1];
        parent = new int[N + 1];

        /* 설명. 각각의 노드(인덱스 번호와 일치)들이 ArrayList를 하나씩 가지도록 초기화 */
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        /* 설명. N-1개 줄에 걸쳐서 각 노드들 정보 입력 */
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        dfs(1);

        /* 설명. 2번 노드의 부모부터 확인해서 StringBuilder에 누적 */
        for (int i = 2; i <= N; i++) {
            sb.append(parent[i]);
            sb.append(" ");
        }

        return sb.toString();
    }

    private static void dfs(int parentNode) {
        isVisit[parentNode] = true;

        for(int node: list[parentNode]) {
            if(!isVisit[node]) {
                parent[node] = parentNode;
                dfs(node);
            }
        }
    }
}