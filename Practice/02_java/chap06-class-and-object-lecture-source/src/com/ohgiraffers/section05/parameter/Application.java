package com.ohgiraffers.section05.parameter;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

public class Application {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(args));

        /* 수업목표. 메소드의 파라미터(매개변수)에 대해 이해하고 사용할 수 있다. */
        ParameterTest pt = new ParameterTest();

        /* 목차. 1. 기본자료형을 매개변수로 전달 받는 메소드 호출 */
        /* 설명. 리터럴 값(참조 주소값X)을 전달해서 메소드를 호출 시에는 서로 다른 지역변수로 서로 영향 X */
        int num = 20;
        System.out.println("call by value 전: " + num);
        pt.testPrimitiveTypeParameter(num);
        System.out.println("call by value 후: " + num);

        /* 목차. 2. 기본자료형 배열을 매개변수로 전달 받는 메소드 호출 */
        /* 설명. 참조 주소값을 전달해서 메소드를 호출 시에는 서로 영향 O(feat.반환할 필요가 없다.) */
//        int[] iArr = new int[]{1, 2, 3, 4, 5};                // 배열 값 수정
//        Rectangle rectangle = new Rectangle(1, 2);            // 객체 필드 수정
        AtomicReference<int[]> ref = new AtomicReference<>(new int[]{1, 2, 3, 4, 5});   // 객체 교체

//        System.out.println("call by reference 전: " + Arrays.toString(iArr));
//        System.out.println("call by reference 전: " + rectangle);
        System.out.println("call by reference 전: " + Arrays.toString(ref.get()));

//        pt.testPrimitiveArrayTypeParameter(iArr);
//        pt.testPrimitiveArrayTypeParameter(rectangle);
        pt.testPrimitiveArrayTypeParameter(ref);

//        System.out.println("call by reference 후: " + Arrays.toString(iArr));
//        System.out.println("call by reference 후: " + rectangle);
        System.out.println("call by reference 후: " + Arrays.toString(ref.get()));

        /* 목차. 3. 클래스 자료형을 매개변수로 전달 받는 메소드 호출 */
        Rectangle r = new Rectangle(22, 12);
//        r.calArea();
//        r.calRound();
        pt.testClassTypeParameter(r);

        /* 목차. 4. 객체 배열은 배우지 않았으므로 뒤에서 다시 나올 예정 */
        /* 목차. 5. 가변인자를 매개변수로 전달 받는 메소드 호출(자바는 왠만하면 사용을 권장하지 X) */
        pt.testVariableLengthArrayParameter();
        pt.testVariableLengthArrayParameter("홍길동");
        pt.testVariableLengthArrayParameter("유관순", "볼링");
        pt.testVariableLengthArrayParameter(new String[]{"강감찬", "낚시", "독서"});
    }
}
