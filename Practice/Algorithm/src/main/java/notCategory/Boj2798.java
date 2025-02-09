package notCategory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int deckSize = Integer.parseInt(st.nextToken());
        int cardSum = Integer.parseInt(st.nextToken());
        int[] deck = new int[deckSize];
        int curSum = 0;
        int nearCardSum = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < deckSize; i++) {
            deck[i] = Integer.parseInt(st.nextToken());
        }

        for(int a = 0; a < deckSize; a++) {
            for(int b = a + 1; b < deckSize; b++) {
                for(int c = b + 1; c < deckSize; c++) {
                    curSum = deck[a] + deck[b] + deck[c];
                    if(curSum <= cardSum && curSum >= nearCardSum) {
                        nearCardSum = curSum;
                    }
                }
            }
        }

        System.out.println(nearCardSum);



    }
}
