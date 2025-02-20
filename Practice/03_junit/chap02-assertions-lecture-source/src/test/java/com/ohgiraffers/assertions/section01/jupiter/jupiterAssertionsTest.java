package com.ohgiraffers.assertions.section01.jupiter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class jupiterAssertionsTest {

    /* 수업목표. Junit5에서 제공하는 Assertions에서 제공하는 메소드에 대해 이해하고 활용할 수 있다. */

    /* 설명. 1. assertEquals */
    /* 설명. assertEquals는 equals() 메소드를 기반으로 동일성 비교를 한다. */
    /* 설명. equals()와 hashCode()를 오버라이딩 해야 동등 비교를 할 수 있다.*/
    @Test
    public void testAssertEquals() {

        // given
        int firstNum = 10;
        int secondNum = 20;
        int expected = 30;

        // when
        Calculator calculator = new Calculator();
        int actual = calculator.plustTwoNumbers(firstNum, secondNum);

        // then 구조로 됨
        //단정문 (~.assert) , 1 -> 오차범위 설정 가능 / , "원하는 문자열" -> 메시지 전송해줌
        Assertions.assertEquals(expected, actual, "이건 정확해야해");
//        Assertions.assertEquals(expected, actual, 1);
//        Assertions.assertEquals(expected, actual);
    }

    /* 설명. 2. assertNotEquals */
    @Test
    @DisplayName("인스턴스 동일성 비교 테스트")
    void testAssertNotEqualsWithInstances() {

        // given
        Object obj1 = new Object();


        // when
        Object obj2 = new Object();

        // then
        Assertions.assertNotEquals(obj1, obj2);
    }

    /* 목차. 3. assertNull */
    @Test
    @DisplayName("null인지 테스트")
    void testAssertNull() {
        String str;
        str = null;
        Assertions.assertNull(str);
    }

    /* 목차. 4. assertNotNull */
    @Test
    @DisplayName("null이 아닌지 테스트")
    void testAssertNotNull() {
        String str;
        str = "java";
        Assertions.assertNotNull(str);
    }

    /* 설명. 5. 자주 쓰는 나머지 간단한 단정문들 */
    /* 설명. 5-1. assertAll */
    @Test
    @DisplayName("동시에 여러 가지 값에 대해 검증을 수행하는 경우 테스트")
    void testAssertAll() {

        //given
        String firstName = "길동";
        String lastName = "홍";

        //when
        Person person = new Person(firstName + 1, lastName);

        //then
        Assertions.assertAll(
                "그룹화된 테스트의 이름(테스트 실패시 보여짐)",
                () -> Assertions.assertEquals(firstName, person.getFirstName(), () -> "firstName이 잘못됨"),
                () -> Assertions.assertEquals(lastName, person.getLastName(), () -> "lastName이 잘못됨")
        );

    }

    /* 설명. 5-2. assertThrows */
    /* 설명. 우리가 의도한 예외 타입과 메세지가 발생했는지도 테스트 케이스로 할 수 있다. -> 반환형이 void 메소드 테스트 용이 */
    @Test
    @DisplayName("void 메소드를 테스트 하는 경우 어떤 exception이 발생하는지 테스트")
    void testAssertThrows() { // 예외 메세지가 같은지 다른지 확인하는 테스트 케이스

        int firstNum = 10;
        int secondNum = 0;
        String expectedMessage = "0으로 나눌 수 없습니다!!";

        NumberValidator validator = new NumberValidator();
        Exception exception = Assertions.assertThrows(
                Exception.class,
                () -> validator.checkDividableNumbers(firstNum, secondNum)
        );

        Assertions.assertAll(
                () -> Assertions.assertInstanceOf(IllegalArgumentException.class, exception,
                        () -> "예외 타입이 일치하지 않음"),
                () -> Assertions.assertEquals(expectedMessage, exception.getMessage(),
                        () -> "예외 메세지가 일치하지 않음")
        );
    }

}
