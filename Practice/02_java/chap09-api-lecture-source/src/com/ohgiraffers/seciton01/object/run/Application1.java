package com.ohgiraffers.seciton01.object.run;

import com.ohgiraffers.seciton01.object.dto.BookDTO;

public class Application1 {
    public static void main(String[] args) {
        BookDTO book1 = new BookDTO(1, "홍길동전", "허균", 50000);
        BookDTO book2 = new BookDTO(2, "홍길동전", "허균", 50000);

        /* 설명. 동일 비교(주소값이 같냐?)*/
        System.out.println("두 인스턴스를 == 연산자로 비교: " + (book1 == book2)); //주소값 비교 참조 자료형 변수

        /* 설명. 동등 비교(들어있는 값이 같냐?)*/
        System.out.println("두 인스턴스를 equals() 메소드로 비교: " + book1.equals(book2));

        System.out.println("book1의 hashCode: " + book1.hashCode());
        System.out.println("book2의 hashCode: " + book2.hashCode());
    }
}
