import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class StringTokenizerSample {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a String");
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[6];
        for(int i = 0; i < 6; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            System.out.println(arr[i]);
        }



//        for (int i = 0; i < 6; i++) {
//            System.out.println(st.nextToken());
//        }
    }
}
