package notCategory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj2562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = Integer.parseInt(br.readLine());
        int idx = 1;

        for(int i = 1; i <= 8; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num > max) {
                max = num;
                idx = i + 1;
            }
        }

        System.out.println(max + "\n" + idx);
    }
}
