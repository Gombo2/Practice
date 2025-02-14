package com.ohgiraffers.section02.uses.subsection01.generation;

import java.util.Arrays;
import java.util.stream.Stream;

public class Application1 {
    public static void main(String[] args) {

        /* 수업목표. 배열이나 컬렉션은 스트림을 이용할 수 있고 이를 이해해서 활용할 수 있다. */
        String[] sArr = new String[]{"java", "mariaDB", "jdbc"};

        /* 설명. Arrays.stream(배열) : 배열 자료형을 Stream 자료형으로 변환*/
        System.out.println("==== 배열로 스트림 생성 ====");
//        Stream<String> strStream1 = Arrays.stream(sArr);

        /* 설명. forEach는 자신의 매개변수에 정의된 람다식의 매개변수로 stream의 각 요소들을 자동으로 넘기며 순회(매번 람다식 실행)*/
//        strStream1.forEach(x -> System.out.println(x));
//        strStream1.forEach(System.out::println);

        Arrays.stream(sArr).forEach(System.out::println);
        System.out.println();

    }
}
