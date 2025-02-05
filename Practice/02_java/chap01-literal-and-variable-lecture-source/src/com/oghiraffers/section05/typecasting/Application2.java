package com.oghiraffers.section05.typecasting;

public class Application2 {
    public static void main(String[] args) {

        /* 수업목표. 강제 형변환 규칙에 대해 이해할 수 있다.*/
        /* 설명.
            강제형변환
             바꾸려는 자료형으로 캐스팅 연산자((자료형))를 이용하여 형변환한다.
        * */

        long lNum = 8000000000L;
        int iNum = (int)lNum;  // 데이터 손실 발생, 경우에 따라 부호 및 값까지 바뀜.
        System.out.println("iNum = " + iNum);

        /* 설명. 실수형 자료형 -> 정수형 자료형으로 강제 형변환하면 의도적으로 소수점 이하를 제거할 수 있다.*/
        float avg = 31.235f;
        int floorNum = (int)avg;
        System.out.println("floorNum = " + floorNum);
        }
}
