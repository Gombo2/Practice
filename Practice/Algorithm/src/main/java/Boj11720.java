import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj11720 {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numCount = Integer.parseInt(br.readLine());
        String[] num = br.readLine().split("");
        int answer = 0;
        for (int i = 0; i < numCount; i++) {

            answer += Integer.parseInt(num[i]);
        }
        System.out.println(answer);


    }
}
