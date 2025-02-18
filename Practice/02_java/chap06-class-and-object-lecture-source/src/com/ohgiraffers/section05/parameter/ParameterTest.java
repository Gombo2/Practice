package com.ohgiraffers.section05.parameter;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

public class ParameterTest {
    public void testPrimitiveTypeParameter(int num) {
        num = 10;
        System.out.println("매개변수로 전달받아 수정한 값: " + num);
    }

//    public void testPrimitiveArrayTypeParameter(int[] iArr) {
//    public void testPrimitiveArrayTypeParameter(Rectangle rectangle) {
    public void testPrimitiveArrayTypeParameter(AtomicReference<int[]> ref) {
//        iArr[0] = 100;
//        rectangle.setHeight(11);
        ref.set(new int[]{100, 2, 3, 4, 5});

//        System.out.println("메소드 내에서 수정 후: " + Arrays.toString(iArr));
//        System.out.println("메소드 내에서 수정 후: " + rectangle);
        System.out.println("메소드 내에서 수정 후: " + Arrays.toString(ref.get()));
    }

    public void testClassTypeParameter(Rectangle rectangle) {
        rectangle.calArea();
        rectangle.calRound();
    }

    /* 설명. 가변인자는 넘어온 인자들을 받아내어 배열로 바꿔준다. */
    public void testVariableLengthArrayParameter(String... str) {
        System.out.println("넘어온 인자들 출력: " + Arrays.toString(str));
    }
}
