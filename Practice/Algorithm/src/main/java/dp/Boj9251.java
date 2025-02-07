package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Boj9251 {
    public static void main(String[] args) throws IOException {
    String[] words = new String[2];
    Map<String,Integer> word1 = new HashMap<>();
    Map<String,Integer> word2 = new HashMap<>();

    words = initializationString(words);
    word1 = getMap(words[0]);
    word2 = getMap(words[1]);


    }

    private static String[] initializationString(String[] words) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        words[0] = st.nextToken();
        st = new StringTokenizer(br.readLine());
        words[1] = st.nextToken();

        return words;
    }

    private static Map<String,Integer> getMap(String word) {
        Map<String, Integer> eachCountMap = new HashMap<>();
        String[] splited = word.split("");

        for (int i = 0; i < splited.length; i++) {
            if(eachCountMap.get(splited[i]) == null) {
                eachCountMap.put(splited[i], 0);
            } else {
                eachCountMap.put(splited[i], eachCountMap.get(splited[i]) + 1);
            }

        }

        return eachCountMap;
    }
}
