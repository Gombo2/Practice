package com.ohgiraffers.section03.reference;

import java.util.function.BiFunction;

public class Application1 {
    public static void main(String[] args) {

        /* 수업목표. 기존에 존재하는 메소드를 참조해 람다식을 적용할 수 있다. */
        BiFunction<String, String, Boolean> biFunction;

        String str1 = "METHOD";
        String str2 = "METHOD";

        boolean result = false;

        /* 궁금. 밑에 코드 두개 동일한 역할을 함.*/
//        biFunction = (x, y) -> x.equals(y);
        biFunction = String::equals;        //참조


        result = biFunction.apply(str1, str2);
        System.out.println("result = " + result);
    }
}
