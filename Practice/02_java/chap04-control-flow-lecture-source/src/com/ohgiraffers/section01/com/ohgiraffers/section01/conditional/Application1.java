package com.ohgiraffers.section01.conditional;

import com.ohgiraffers.section01.com.ohgiraffers.section01.conditional.D_switch;

public class Application1 {
    public static void main(String[] args) {
        A_if aClass = new A_if();

        /* 설명. 단독 if문 흐름 확인용 메소드 호출 */
//        aClass.testSimpleIfStatement();

        /* 설명. 중첩 if문 흐름 확인용 메소드 호출 */
//        aClass.testNestedIfStatement();

        B_ifElse bClass = new B_ifElse();

        /* 설명. 단독 if-else문 흐름 확인용 메소드 호출 */
//        bClass.testSimpleIfElseStatemet();

        /* 설명. 중첩 if-else문 흐름 확인용 메소드 호출 */
//        bClass.testNestedIfElseStatement();

        /* 설명. 중첩 if-else if문 흐름 확잉뇽 메소드 호출*/
//        C_ifElseIf cClass = new C_ifElseIf();
//        cClass.testSimpleIfElseIfStatement();

//        cClass.testNestedIfElseIfStatement();

        /* 설명. static 메소드로 switch문 흐름 확인용 메소드 호출*/
        D_switch.testSimpleSwitchStatement();
    }
}