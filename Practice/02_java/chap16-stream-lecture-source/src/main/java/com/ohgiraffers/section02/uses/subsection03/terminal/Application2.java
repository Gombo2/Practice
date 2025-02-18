package com.ohgiraffers.section02.uses.subsection03.terminal;

import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Application2 {
    public static void main(String[] args) {

        /* 수업목표. 스트림의 최종 연산 중 하나인 reduce에 대해 이해하고 사용할 수 있다. */
        /* 설명. reduce()는 스트림의 요소들을 하나의 값으로 줄이는(reduce) 최종 연산이다. */

        /* 목차. 1. 인자가 1개일 경우 */
        OptionalInt reduceOneParam = IntStream.range(1, 4)
                                              .reduce((a, b) -> a + b);
        System.out.println("reduceOneParam = " + reduceOneParam);

        /* 설명. 2. 인자가 2개일 경우 */
        int reduceTwoParam = IntStream.range(1, 4)
                                      .reduce(100, Integer::sum);
        System.out.println("reduceTwoParam = " + reduceTwoParam);

        /* 설명. 3. 인자가 3개일 경우 */
        /* 설명.
         *  매개변수 3번째는 좀 더 효율적인 가산 누적연산을 위한 중계 합계 처리용 람다식을
         *  작성한다.(2번째 인자의 결과와 호환이 가능해야 한다.)
        * */
        Integer reduceThreeParam = Stream.of(4, 5, 1, 2, 3, 9, 6, 7, 8, 10)
                .reduce(100, Integer::sum, (x, y) -> x + y);
        System.out.println("reduceThreeParam = " + reduceThreeParam);
    }
}
