package com.oghiraffers.section03.overriding;

/* 설명. Class의 접근 제어자는 public/default 2가지가 있다.*/
public class SuperClass {

    /* 수업목표. 오버라이딩에 대해 이해할 수 있다.*/

    /* 설명. 멤버(필드/메소드)들은 public/protected/default/private 네 가지가 있다.
    *   전역 / 패키지 내에서나 + 상속받은 경우에만 사용 / 패키지 내에서 사용 / 클래스 내에서만
    * */
    public void method(int num) {}

    public Object method2(int num) {
        return null;
    }

    private void privateMethod() {}

    public final void finalMethod() {}

    protected void protectedMethod() {}

    void defaultMethod() {} //default는 적으면 에러남. 안적으면 default임

}
