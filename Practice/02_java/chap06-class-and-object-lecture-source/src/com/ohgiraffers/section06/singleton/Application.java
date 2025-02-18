package com.ohgiraffers.section06.singleton;

import java.util.Calendar;

public class Application {
    public static void main(String[] args) {

        /* 수업목표. 싱글톤 패턴에 대해 이해할 수 있다. */
        /* 설명.
         *  singleton pattern이란?
         *   애플리케이션이 시작되고 난 후 어떤 클래스가 최초 한번만 메모리에 할당(객체)되고
         *   그 메모리에 인스턴스가 단 하나만 생성되어 공유되게 하는 것을 싱글톤 패턴이라고 한다.
         *   (메모리 및 리소스 낭비 방지 목적)
         *
         * 설명.
         *  장점
         *   1. 첫 번째 이용 시에는 인스턴스를 생성해야 하므로 속도 차이가 나지 않지만
         *      두 번째 이후 이용 시에는 인스턴스 생성 시간 없이 바로 사용할 수 있다.(feat.재사용)
         *   2. 인스턴스가 절대적으로 한 개만 할당 되는 것을 보증할 수 있다.
         *  단점
         *   1. 싱글톤 인스턴스가 너무 많은 일을 하거나 많은 데이터를 공유하면 결합도가 높아진다.
         *   2. 동시성 문제를 고려해서 설계해야 하기 때문에 난이도가 높다.
         *
         * 설명.
         *  구현 방법
         *   1. 이른 초기화(Eager Initialization)
         *   2. 늦은 초기화(Lazy Initialization)
        * */

        /* 설명. EagerSingleton은 프로그램 시작 시 바로 객체가 할당 */
        EagerSingleton eager1 = EagerSingleton.getInstance();
        EagerSingleton eager2 = EagerSingleton.getInstance();
        System.out.println("eager1의 주소: " + System.identityHashCode(eager1));
        System.out.println("eager2의 주소: " + System.identityHashCode(eager2));

        LazySingleton lazy1 = LazySingleton.getInstance();  // LazySingleton은 최초 호출 시 객체가 할당
        LazySingleton lazy2 = LazySingleton.getInstance();
        System.out.println("lazy1의 주소: " + System.identityHashCode(lazy1));
        System.out.println("lazy2의 주소: " + System.identityHashCode(lazy2));
    }
}
