package notCategory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int minNum = Math.min(a, b);
        int LCD = 0; //최소공배수
        int GCD = 0; //최대공약수

        for (int i = 1; i <= minNum; i++) {
            if (a % i == 0 && b % i == 0) {
                if (GCD < i) {
                    GCD = i;
                }
            }
        }

        LCD = a * b / GCD;  //최대공약수  A * B /최소공배수

        System.out.println(GCD + "\n" + LCD);

    }
}
