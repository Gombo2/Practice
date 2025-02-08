package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj4153 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int[] length = new int[3];

        while (true) {
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < length.length; i++) {
                length[i] = Integer.parseInt(st.nextToken());
            }

            if (length[0] == 0) {
                break;
            }

            Arrays.sort(length);

            if (Math.pow(length[0], 2) + Math.pow(length[1], 2) == Math.pow(length[2], 2)) {
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }
        }

    }
}
