package com.ohgiraffers.section02.enumtype;

public class Application {
    public static void main(String[] args) {
//        Subjects subject1 = new Subjects(); // 우리가 enum 타입의 생성자를 직접 사용 X
        Subjects subject1 = Subjects.JAVA;
        Subjects subject2 = Subjects.HTML;
        Subjects subject3 = Subjects.JAVASCRIPT;


        /* 설명.
        *   1. 열기 타입으로 선언된 인스턴스는 싱글톤으로 관리되며 인스턴스가 각각 한 게ㅣㅁ을 보전한다.
        *       적당한 순서에 따라 각각은 다른 인스턴스가 생성되며 최초 호출 시에 enum에 생성자를 활용해
        *       생성된다(lazy singleton)
        *
        *  설명.
        *   2. 단일 인스턴스를 보장하기에 == 비교가 가능하다.(동일 객체 비교)
        * */
        //if (subject1 == subject2) {       //서로 다르다라고 뜨는 건 다른 객체이ㅣ기때문
        if(subject1 == subject3) {          //서로 다르다라고 뜨는건 다른 객체기 때문
            System.out.println("두 과목은 같은 과목이다.");
        } else {
            System.out.println("서로 다른 과목이다.");
        }

        /* 설명. 3. 상수 필드명을 문자열로 변경하기 쉽다.*/
        System.out.println(Subjects.JAVA.toString()); //우리가 재정의 해서사용할 수 있다.
        System.out.println(Subjects.JAVA);

        /* 설명. 4. values()를 이용하면 상수값 배열을 반환받고 이를 활용하여 연속처리해 줄 스 있다.*/
        Subjects[] subjects = Subjects.values();
        for (Subjects sub : subjects) {
            System.out.println(sub.toString());
            System.out.println(sub.ordinal()); //enum에 선언된 사수들의 순서를 인덱스 체계로 추출.
        }

        /* 설명. 5. 타입 안정성을 보장한다.*/
        printSubjects(Subjects.JAVA);
//        printSubjects(0); //Subjets 타입이 아니면 전달할 수 없다.
    }

    private static void printSubjects(Subjects subjects) {
    }
}
