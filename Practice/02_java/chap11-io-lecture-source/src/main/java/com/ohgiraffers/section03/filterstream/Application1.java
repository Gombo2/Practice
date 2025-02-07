package com.ohgiraffers.section03.filterstream;

import java.io.*;

public class Application1 {
    public static void main(String[] args) {

        /* 수업목표. BufferedWriter와 BufferedReader에 대해 이해하고 사용할 수 있다.*/
        /* 설명.
         *   내부적으로 버퍼(buffer)를 활용해서 입출력 성능을 향상 시킨다.
         *   추가적인 메소드가 제공된다.
         * */

        /* 궁금. BufferedWriter은 기본 바이트사이즈가 8192인데, 이 바이트가 다 채워지기 전까지 이동하지 않음.
         *   그래서 bw.close()할 때 flush()를 내부적으로 해주지않는이상 출력하고 싶을 때 직접 flush()를 걸어줘야함.*/
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter( //bw.의 보조스트림의 주소를 사용하게 됨.
                    new FileWriter(
                            "src/main/java/com/ohgiraffers/section03/filterstream/testbuffered.txt"));

            bw.write("눈이\n");
            bw.write("하늘에서\n");
            bw.write("내려오네\n");

            /* 설명. 내부적으로 버퍼가 다 차지 않으면 출력으로 내보내 지지 않는데 flush()를 호출하여 버퍼가 지워진다. */
            bw.flush();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        BufferedReader br = null;
        try {
            br = new BufferedReader(
                    new FileReader(
                            "src/main/java/com/ohgiraffers/section03/filterstream/testbuffered.txt"
                    )
            );

//            String str = br.readLine();
//            System.out.println(str);
            String str = "";
            while ((str = br.readLine()) != null) {
                System.out.println("str = " + str);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
