import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int countSize;
    static List<Integer> countSizeList;
    static int[] moveX = {0, 0, -1, 1};
    static int[] moveY = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int rowCases = Integer.parseInt(st.nextToken());
        int columnCases = Integer.parseInt(st.nextToken());
        int squareCases = Integer.parseInt(st.nextToken());

        map = new int[rowCases][columnCases];
        visited = new boolean[rowCases][columnCases];
        countSizeList = new ArrayList<>();

        //직사각형 map에 초기화
        for(int i = 0; i < squareCases; i++) {
            st = new StringTokenizer(br.readLine());

            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            for(int j = startY; j < endY; j++) {
                for(int k = startX; k < endX; k++) {
                    map[j][k] = 1;
                }
            }

        }

        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[i].length; j++) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    countSize = 0;
                    bfs(j, i);
                    countSizeList.add(countSize);
                }
            }
        }

        sb.append(countSizeList.size())
                .append("\n");

        for(int count : countSizeList) {
            sb.append(count)
                    .append(" ");
        }

        System.out.println(sb);
    }

    private static void bfs(int x, int y) {
        Queue<Node> que = new LinkedList<>();
        que.offer(new Node(x,y));
        countSize++;
        visited[y][x] = true;

        while(!que.isEmpty()) {
            Node node = que.poll();

            if(!visited[node.y][node.x]) {
                visited[node.y][node.x] = true;
                countSize++;

                for(int i = 0; i < 4; i++) {
                    int curX = node.x + moveX[i];
                    int curY = node.y + moveY[i];

                    if(map[curY][curX] == 1 && !visited[curY][curX] && checkBoundary(curX, curY)) {
                        que.offer(new Node(curX,curY));
                    }
                }
            }

        }

    }

    public static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static boolean checkBoundary(int x, int y) {
        if(x >= 0 && x < map[0].length && y >= 0 && y < map.length) {
            return true;
        }
            return false;
    }

}