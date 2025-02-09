package notCategory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1259 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean isPalindrome = true;
        String str = "";
        while(!(str = br.readLine()).equals("0")) {
            isPalindrome = true;
            for (int i = 0; i < str.length() / 2; i++) {
                if(str.charAt(i) != str.charAt((str.length() - 1) - i)) {
                    isPalindrome = false;
                    break;
                }
            }

            System.out.println(isPalindrome ? "yes" : "no");
        }
    }
}
