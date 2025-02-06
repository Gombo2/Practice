import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class inputOutput {
    public static void main(String[] args) throws IOException {
        /* 수업목표. 코딩 알고리즘 테스트에 필요한 기본 입력 함수를 이해한다. */
        /* 설명. 원리를 무시한다. */

        /* 궁금. 왜 쓰느냐?
         *   A. 빠르니까.*/
        System.out.println("문자를 입력해주세요");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        System.out.println(input);
    }
}
