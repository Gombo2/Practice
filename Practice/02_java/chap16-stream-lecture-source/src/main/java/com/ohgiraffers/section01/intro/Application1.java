package com.ohgiraffers.section01.intro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application1 {
    public static void main(String[] args) {

        int coreCount = Runtime.getRuntime().availableProcessors();
        System.out.println("CPU 코어 수: " + coreCount);
        
        /* 수업목표. Stream에 대해 이해하고 활용할 수 있다. */
        /* 설명. 
         *  Arrays.asList(): 매개변수로 요소들을 전달하면 List로 반환
         *  ArrayList<>(Collection 타입): Collection 타입을 ArrayList 객체로 생성할 때
         *                               쓰이는 생성자
        * */
        List<String> stringList = Arrays.asList("hello", "world", "stream");

        /* 설명. main 쓰레드 상에서 스트림을 사용하지 않고 확인 */
        System.out.println("===== for each");
        for (String str : stringList) {
            System.out.println(str + ": " + Thread.currentThread().getName());
        }

        /* 설명. main 쓰레드 상에서 단순 스트림을 사용하고 확인 */
        System.out.println("===== normal stream");
//        stringList.stream().forEach(x -> Application1.print(x));
        stringList.forEach(x -> Application1.print(x));     // 컬렉션은 stream()을 생략해도 된다.
        System.out.println();

        /* 설명. main 쓰레드 상에서 병렬 스트림을 사용하고 확인(cpu 코어 병렬 처리) */
        System.out.println("===== parallel stream");
        stringList.parallelStream().forEach(Application1::print);  // cpu 코어들을 효율적으로 사용해 성능 향상(속도 향상)
    }

    private static void print(String x) {
        System.out.println(x + ": " + Thread.currentThread().getName());
    }
}
