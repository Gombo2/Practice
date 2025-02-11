import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> deque = new LinkedList<>();
        StringTokenizer st = null;
        int orderCount = Integer.parseInt(br.readLine());
        for(int i = 0; i < orderCount; i++) {
            String curOrder = br.readLine();
            int num = 0;
            if(curOrder.length() >= 6) {
               st = new StringTokenizer(curOrder);
               st.nextToken();
               num = Integer.parseInt(st.nextToken());
               deque.offer(num);
            } else {
                if(curOrder.equals("front")) {
                    if(deque.isEmpty()) {
                        System.out.println("-1");
                    } else {
                        System.out.println(deque.peek());
                    }
                } else if(curOrder.equals("back")) {
                    if(deque.isEmpty()) {
                        System.out.println("-1");
                    } else {
                        System.out.println(deque.peekLast());
                    }
                } else if(curOrder.equals("size")) {
                    System.out.println(deque.size());
                } else if(curOrder.equals("empty")) {
                    if(deque.isEmpty()) {
                        System.out.println("1");
                    } else {
                        System.out.println("0");
                    }
                } else {
                    if(deque.isEmpty()) {
                        System.out.println("-1");
                    } else {
                        System.out.println(deque.poll());
                    }
                }

            }
        }


    }
}
