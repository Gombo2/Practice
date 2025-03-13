import java.util.*;

class Solution {
    public static int[] moveY = {1,-1,0,0};
    public static int[] moveX = {0,0,1,-1};
    public static int n, m;
    public static int[][] visited;

    static class Node {
        int y, x;
        public Node(int y, int x){
            this.x = x;
            this.y = y;
        }
    }

    public static int bfs(char start, char end, String[] maps){
        Queue<Node> queue = new LinkedList<Node>();
        visited = new int[n][m];
        for (int i = 0 ; i < n; i++){
            for (int j = 0; j < m; j++){
                if (maps[i].charAt(j) == start){
                    queue.offer(new Node(i,j));
                    visited[i][j] = 1;
                }
            }
        }

        while (!queue.isEmpty()){
            Node node = queue.poll();
            int y = node.y;
            int x = node.x;

            if (maps[y].charAt(x) == end){
                return visited[y][x] -1;
            }

            for (int i = 0 ; i < 4; i++){
                int curY = y + moveX[i];
                int curX = x + moveY[i];

                if(0 <= curY && curY < n && 0 <= curX && curX < m && visited[curY][curX] == 0){
                    if(maps[curY].charAt(curX) != 'X'){
                        visited[curY][curX] = visited[y][x] + 1;
                        queue.add(new Node(curY,curX));
                    }

                }
            }
        }
        return -1;
    }

    public int solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        int startToLebber = bfs('S','L',maps);
        int lebberToEnd = bfs('L','E',maps);
        if (startToLebber == -1 || lebberToEnd == -1){
            return -1;
        }
        else{
            return startToLebber + lebberToEnd;
        }
    }
}