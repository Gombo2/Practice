package notCategory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numSockets = Integer.parseInt(br.readLine());
        int[] numArr = new int[numSockets];
        StringTokenizer st = st = new StringTokenizer(br.readLine());
        int max = 0;

        for(int i = 0; i < numSockets; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        max = getMaxNum(numArr);
        double average = 0;

        for(int eachScore : numArr) {
            average += eachScore;
        }

        System.out.println(average/(double)max * 100.0 / (double)numSockets);

    }

    private static int getMaxNum(int[] Arr) {
        int max = 0;

        for(int i = 0; i < Arr.length; i++) {
            if (max < Arr[i]) {
                max = Arr[i];
            }
        }

        return max;
    }
}
