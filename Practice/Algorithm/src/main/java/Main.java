import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int hP = Integer.parseInt(st.nextToken());
        int sP = Integer.parseInt(st.nextToken());
        Set<String> notHeardPeopleList = new HashSet<>();
        List<String> answer = new ArrayList<>();
        int count = 0;

        for(int i = 0; i < hP; i++) {
            String people = br.readLine();
            notHeardPeopleList.add(people);
        }

        for(int j = 0; j < sP; j++) {
            String peoples = br.readLine();
            if(notHeardPeopleList.contains(peoples)) {
                count++;
                answer.add(peoples);
            }
        }



        System.out.println(count);
        Collections.sort(answer);
        for(String people : answer) {
            System.out.println(people);
        }
    }
}
