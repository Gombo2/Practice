import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());
        int divNum = Integer.parseInt(br.readLine());
        int lastTwoDigit = num % 100;

        if(isDivided(num , divNum)) {
            System.out.println("00");
        } else {

        }



    }

    private static boolean isDivided(int num, int divNum) {
        return num / divNum == 0 ? true : false;
    }
}