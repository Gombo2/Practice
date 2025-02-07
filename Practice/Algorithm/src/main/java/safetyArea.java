import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class safetyArea {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for(int i = 0; i < arr.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = getMax(arr);

        for(int j = 1; j <= max; j++) {

        }
    }

    private static int getMax(int[][] arr) {
        int max = 0;

//        for(int i : arr) {
//            if(i > max) {
//                max = i;
//            }
//        }

        return max;
    }

    private static boolean isOver(int rain, int area) {
        return rain >= area;
    }

}
