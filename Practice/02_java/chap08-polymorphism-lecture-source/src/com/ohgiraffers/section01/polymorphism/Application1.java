package com.ohgiraffers.section01.polymorphism;

public class Application1 {
    public static void main(String[] args) {


        /* 수업목표. 다형성과 타입 형변환에 대해 이해할 수 있다.*/
        Animal animal = new Animal();
        animal.eat();
        animal.run();
        animal.cry();

        System.out.println();

        Tiger tiger = new Tiger();
        tiger.eat();
        tiger.run();
        tiger.cry();
        tiger.bite();

        System.out.println();

        Rabbit rabbit = new Rabbit();
        rabbit.eat();
        rabbit.run();
        rabbit.cry();
        rabbit.jump();

        Animal an1 = new Animal();      //다형성 X
        Animal an2 = new Tiger();       //다형성 O
        Animal an3 = new Rabbit();      //다형성 O
        /* 설명. 정적 바인딩. */
        /* 설명. Animal은 Tiger나 Rabbit이 아니다.(Tiger 또는 Rabbit 타입을 지니고 있지 않다.) */
//        Tiger t1 = new Animal();        //다형성 X 에러남.


        /* 설명. 동적 바인딩 확인하기
        *    컴파일 당시에는 해당 타입의 메소드와 연결되어 있다.
        *    런타임 당시 실제 객체가 가진 오버라이딩 된 메소드로 바인딩 되어 바뀌어 동작하는 것을 의미한다.
        *    (동적 바인딩의 조건 : 상속, 다형성, 오버라이딩)
        * */
        an1.cry();
        an2.cry();
        an3.cry();

        /* 설명. 부모타입을 강제로 자식 타입으로 형변환 하는 것이 가능하다.(단 조심해야 한다. -> 강제 형변환 (int)같은 느낌 )*/

//        ((Tiger)an2).bite();
        /* 설명. instanceof란?
        *    해당 객체의 타입을 런타임 시정메 확인하기 위한 연산자
        * */
        if(an2 instanceof Tiger) {
            ((Tiger)an2).bite();
        }

        if(an3 instanceof Rabbit) {
            ((Rabbit)an3).jump();
        }

        if(an3 instanceof Animal) {
            System.out.println("Animal은 맞지~");
        }

        Animal animal2 = new Tiger();       // 다형성을 적용, 자동 형 변환(auto up-casting), 묵시적 형 변환
        Rabbit rabbit2 = (Rabbit)an3;       // 다형성 적용X , 강제 형 변환(down-casting), 명시적 형 변환
    }
}
