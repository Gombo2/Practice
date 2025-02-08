package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj30802 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int visitor = 0;
        int[] sizePerNeedCount = new int[6];
        int tShirt = 0;
        int pen = 0;

        visitor = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 6; i++) {
            sizePerNeedCount[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        tShirt = Integer.parseInt(st.nextToken());
        pen = Integer.parseInt(st.nextToken());

        int[] penResult = getPenResult(visitor, pen);
        int tShirtResult = getTShirtResult(sizePerNeedCount, tShirt);
        System.out.println(tShirtResult);
        System.out.println(penResult[0] + " " + penResult[1]);


    }

    private static int[] getPenResult(int visitor, int pen) {
        int[] penResult = new int[2];
        penResult[0] = visitor / pen;
        penResult[1] = visitor % pen;

        return penResult;
    }

    private static int getTShirtResult(int[] sizePerNeedCount, int tShirt) {
        int answer = 0;

        for(int i = 0; i < sizePerNeedCount.length; i++) {
            if(sizePerNeedCount[i] % tShirt != 0) {
                answer += (sizePerNeedCount[i] / tShirt) + 1;
            } else {
                answer += sizePerNeedCount[i] / tShirt;
            }
        }

        return answer;
    }

}
