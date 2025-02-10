import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int wordCount = Integer.parseInt(br.readLine());
        String[] wordArr = new String[wordCount];
        for (int i = 0; i < wordCount; i++) {
            wordArr[i] = br.readLine();
        }
        br.close();

        Arrays.stream(wordArr)
                .distinct()
                .sorted()
                .sorted(Comparator.comparing(String::length))
                .forEach(System.out::println);


    }
}
