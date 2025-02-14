import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
//        /* 설명. 1번 풀이법. 숫자로 자리수 확인하기. */
        int clap = 0;
//        for(int i = 1; i <= num; i++) {
//            int digit = 0;
//            int currentNum = i;
//            while (currentNum > 0) {
//                digit = currentNum % 10;
//                if(digit == 3 || digit == 6 || digit == 9) {
//                    clap++;
//                }
//                currentNum /= 10;
//            }
//        }
//
//
//        bw.write(clap + "\n");
//        bw.flush();
//        bw.close();
//
//
        for(int i = 1; i <= num; i++) {
            String str = i + "";
            if(str.contains("3") || str.contains("6") || str.contains("9")) {
                for(int j = 0; j < str.length(); j++) {
                    if(str.charAt(j) == '3' || str.charAt(j) == '6' || str.charAt(j) == '9') {
                        clap++;
                    }
                }
            }
        }

        bw.write(clap + "\n");
        bw.flush();
        bw.close();

    }
}