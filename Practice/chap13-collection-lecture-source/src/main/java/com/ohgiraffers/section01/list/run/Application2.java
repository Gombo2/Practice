package com.ohgiraffers.section01.list.run;

import com.ohgiraffers.section01.list.comparator.AscendingPrice;
import com.ohgiraffers.section01.list.dto.BookDTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application2 {
    public static void main(String[] args) {
        List<BookDTO> bookList = new ArrayList<>();

        /* 궁금. 정렬기준을 어떻게 잡을것인가? 각 요소 x2(오름차순,내림차순) */
        /* 설명. BookDTO 객체(필드 4개)는 정렬의 기준이 8가지 있다. */
        /* 목차. 1. Comparable 인터페이스 구현 방법 활용 */

        bookList.add(new BookDTO(1, "홍길동전", "허균", 50000));
        bookList.add(new BookDTO(2, "목민심서", "정약용", 30000));
        bookList.add(new BookDTO(3, "동의보감", "허준", 40000));
        bookList.add(new BookDTO(4, "삼국사기", "김부식", 46000));
        bookList.add(new BookDTO(5, "삼국유사", "일연", 58000));



//        Collections.sort(bookList);   //comparable 일때

        /* 설명. 아래와 같은 기능을 한다.*/
        Collections.sort(bookList, new AscendingPrice());

        /* 설명. List 계열도 sort 메소드를 쓸 수 있는데 Comparator를 구현한 클래스의 객체만 넘겨주면 된다. */
        bookList.sort(new AscendingPrice());


        for (int i = 0; i < bookList.size(); i++) {
            System.out.println(bookList.get(i));
        }

    }
}
