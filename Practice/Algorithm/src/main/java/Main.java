import java.util.*;
import java.io.*;

public class Main {
    public static int[] memoization;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        memoization = new int[46];
        int answer = Fibonacci(num);
        System.out.println(answer);

    }

    private static int Fibonacci(int num) {
        if(num <= 1) {
            return num;
        } else if(memoization[num] != 0) {
            return memoization[num];
        } else {
            return memoization[num] = Fibonacci(num - 1) + Fibonacci(num - 2);
        }
    }
}