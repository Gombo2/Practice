package com.ohgiraffers.section02.encapsulation.problem1;

public class Monster {
    String name;
    int hp;

    public void setHp(int hp) {
        if(hp >= 0) {
            this.hp = hp;
        } else {
            this.hp = 0;
        }
    }
}
