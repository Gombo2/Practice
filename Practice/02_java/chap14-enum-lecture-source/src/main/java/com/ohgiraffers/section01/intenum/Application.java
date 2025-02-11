package com.ohgiraffers.section01.intenum;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        /* 수업목표. 단순 정수 열거 패턴과 이의 단점을 이해할 수 있다.(enum이 아닐 때) */
        int subject1 = Subjects.JAVA;
        int subject2 = Subjects.HTML;

        /* 설명. 1. 둘 다 같은 상수이자 숫자일 뿐 구분할 수 없다.(런타임 시점) */
        if (subject1 == subject2) {
            System.out.println("두 과목은 같은 과목입니다.");
        }

        /* 설명. 2. 변수명에 쓰인 이름(문자열)을 출력하기 어렵다.(feat.switch) */
        Scanner sc = new Scanner(System.in);
        System.out.print("과목 번호를 입력하세요(0 ~ 2): ");
        int fieldNo = sc.nextInt();

        /* 설명. 심지어 모든 필드를 문자열로 바꿀 수 없는 상황 */
        String subName = "";
        switch(fieldNo) {
            case Subjects.JAVA: subName = "JAVA"; break;
            case Subjects.MARIADB: subName = "MARIADB"; break;
            case Subjects.JDBC: subName = "JDBC"; break;
        }

        System.out.println("선택한 과목명은: '" + subName + "'입니다.");

        /* 설명. 3. 같은 클래스에 속한 상수들을 순회(반복자/반복문)할 수 없다.
         *         (필드가 총 몇 개이고 어떤 것들이 있는지)
        * */
        /* 설명. 4. 타입 안정성을 보장할 수 없다. */
        printSubject(Subjects.JAVA);
        printSubject(0);
    }

    private static void printSubject(int subjectsNo) {
    }
}
