package com.ohgiraffers.section01.intro;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Application1 {
    public static void main(String[] args) {

        /* 수업목표. Stream에 대해 이해하고 활용할 수 있다. */
        /* 설명.
         *   Arrays.asList(): 매개변수로 요소들을 전달하면 List로 반환
         *   ArrayList<>(Collection 타입): Collection 타입을 ArrayList 객체로 생성할 때
         *                                쓰이는 생성자
         * */
        List<String> stringList = Arrays.asList("hello", "world", "stream");

        /* 설명. main 쓰레드 상에세 스트림을 사용하지 않고 확인*/
        System.out.println("===== for each =====");
        for (String str : stringList) {
            System.out.println(str + " : " + Thread.currentThread().getName());
        }

        /* 설명. main 쓰레드 상에서 단순 스트림을 사용하고 확인*/
        System.out.println("===== normal stream =====");
//        stringList.stream().forEach(x -> Application1.print(x));
        stringList.forEach(x -> Application1.print(x));      //컬렉션은 stream()을 생략해도 좋다.


        /* 설명. main 쓰레드 상에서 병렬 스트림을 사용하고 확인*/
        System.out.println("===== parallel stream =====");

        stringList.parallelStream().forEach(Application1::print);  //cpu 코어들을 효율적으로 사용해 성능 향상(속도 향상)

//        Arrays.stream(sArr).forEach(System.out::println);
//        System.out.println();
//
//        /* 설명. Stream으로 관리되는 요소들을 원하는 갯수만큼 반복할 수 있다. */
//        Stream<String> strStream2 = Arrays.stream(sArr, 0, 2);
//        strStream2.forEach(System.out::println);

        /* 설명.
         *   Builder를 활용한 스트림 생성
         *   builder는 static<T>로 되어 있는 메소드이며, 호출 시 타입 파라미터를 메소드 호출 방식으로 전달한다.
         * */
        System.out.println("===== Builder로 스트림 생성 =====");
        Stream<String> builderStream =
                Stream.<String>builder()
                .add("홍길동")
                .add("유관순")
                .add("윤봉길")
                .build();

        builderStream.forEach(x -> System.out.println(x));
        builderStream.forEach(System.out::println);

    }

    private static void print(String x) {
        System.out.println(Thread.currentThread().getName());

    }

}
