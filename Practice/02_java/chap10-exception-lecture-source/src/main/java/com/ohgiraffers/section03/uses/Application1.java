package com.ohgiraffers.section03.uses;

import java.io.*;

public class Application1 {
    public static void main(String[] args) {

        /* 수업목표.예외 처리를 많이 사용하는 io패키지와 관련된 try-catch 구문을 이해할 수 있다. */
        /* 설명.
        *   예외 처리를 가장 많이 사용하게 되는 상황(io 패키지 관련)에서 try-catch 구문을 실제 상황과
        *   유사하게 연습해 보자.
        *   (아직 배우지 않았으니 입출력 관련 구문을 하나하나 신경쓰기 보다는 전체 흐름과 구조를 신경쓰자.)
        * */

        /* 궁금. intput, output의 기준?
        *   -> 컴퓨터를 기준으로 input, output 이 정해진다. (키보드 마우스 -> input, 모니터 -> output)
        *   -> 여기서는 ram도 아니고 java Applicaton 기준으로 input과 output이 정해진다.
        *   -> 콘솔 창에서 받는것도 input이 된다. */

        /* 설명. 프로젝트 바로 아래 경로에 test.dat 파일이 있다면 그걸 인지한 File 객체를 생성해 절대경로 출력*/
        System.out.println(new File("test.dat").getAbsolutePath()); //경로없이 파일명을 호출하면 패키지 내의 dat 찾음

        BufferedReader br = null;

        try { //예외처리시 객체가 생성되는데 이 스트림을 닫아주야됨 -> finally 사용.
            br = new BufferedReader(new FileReader(new File("test.dat"))); //FileReader -> 통로 생성.
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            /* 설명.
            *   예외처리 구문과 상관 없이 반드시 수행해야 하는 경우 finally에 작성하는데
            *   보통 사용한 자원(resource)를 반납하는 용도로 사용하게 된다.
            * */
            try {
                if(br != null) {

                    /* 설명.
                    *   입출력에서 사용한 스트림(통로)를 닫아주는 용도의 메소드이다.
                    *   스트림이 없을 때(null)를 고려하고 IOExcepton을 처리해야 제대로 쓸 수 있다.
                    * */
                    br.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
