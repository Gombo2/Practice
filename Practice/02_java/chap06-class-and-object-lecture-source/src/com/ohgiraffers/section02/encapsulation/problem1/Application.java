package com.ohgiraffers.section02.encapsulation.problem1;

public class Application {
    public static void main(String[] args) {

        /* 수업목표. 필드에 직접 접근하는 경우 발생하는 문제점을 이해할 수 있다. */
        /* 설명. monster1 생성 */
        Monster monster1 = new Monster();
        monster1.name = "드라큘라";
        monster1.hp = 200;

        System.out.println("monster1의 이름: " + monster1.name);
        System.out.println("monster1의 체력: " + monster1.hp);

        /* 설명. monster2 생성 */
        Monster monster2 = new Monster();
        monster2.name = "프랑켄";
//        monster2.hp = -300;
        monster2.setHp(-300);              // 이 때 내부의 setHp 메소드의 this.은 monster2.과 같은 의미이다.

        System.out.println("monster2의 이름: " + monster2.name);
        System.out.println("monster2의 체력: " + monster2.hp);
    }
}
