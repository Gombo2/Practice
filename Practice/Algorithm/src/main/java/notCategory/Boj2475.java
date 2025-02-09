package notCategory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int result = 0;

        for(int i = 0; i < 5; i++) {
            result += Math.pow((Integer.parseInt(st.nextToken())), 2);
        }

        result %= 10;

        System.out.println(result);
    }
}
