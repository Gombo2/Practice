import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        String[][] virusArr = new String[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())];

        for(int i = 0; i < virusArr.length; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < virusArr.length; j++) {
                virusArr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


    }
}
