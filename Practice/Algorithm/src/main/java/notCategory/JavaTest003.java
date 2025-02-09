package notCategory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JavaTest003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int allMinute = Integer.parseInt(st.nextToken())*60 + Integer.parseInt(st.nextToken());
        int time = Integer.parseInt(br.readLine());
        int sumMinute =  allMinute + time;
        int hour = sumMinute / 60;
        int minute = sumMinute % 60;

        if (hour >= 24) {
            hour -= 24;
        }

        System.out.println(hour + " " + minute);


    }
}
