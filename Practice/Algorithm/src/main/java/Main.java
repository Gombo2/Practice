import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int minSecond = Integer.MAX_VALUE;
    static int maxLoc = 100000;
    static boolean[] visited;
    static int startPoint;
    static int endPoint;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        startPoint = Integer.parseInt(st.nextToken());
        endPoint = Integer.parseInt(st.nextToken());
        visited = new boolean[maxLoc + 1];

        bfs();


    }

    private static void bfs() {
        Queue<Node> que = new LinkedList<>();
        que.offer(new Node(startPoint, 0));

        while(!que.isEmpty()) {
            Node node = que.poll();
            visited[node.x] = true;

            if(node.x == endPoint) {
                minSecond = Math.min(minSecond, node.second);
            }

            if(node.x <= maxLoc && )

        }
    }

    private static class Node {
        int x;
        int second;

        public Node(int x, int second) {
            this.x = x;
            this.second = second;
        }
    }
}