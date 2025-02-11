package com.ohgiraffers.section02.extend.run;

import com.ohgiraffers.section02.extend.vo.*;

public class Application1 {
    public static void main(String[] args) {

        /* 수업목표. extends 키워드를 활용해서 특정 키워드만 넣는, 제네릭 클래스를  좀더 활용하는 예제를 이해할 수 있다.*/
//        RabbitFarm<Animal> farm1 = new RabbitFarm<>();       // 컴파일 에러 발생
//        RabbitFarm<Mammel> farm2 = new RabbitFarm<>();       // 컴파일 에러 발생
//        RabbitFarm<Snake> farm3 = new RabbitFarm<>();        // 컴파일 에러 발생

        /* 설명. <T extends Rabbit> 에  의해 Rabbit 및 하위 타입으로만 제네릭 객체 생성 가능.*/
        RabbitFarm<Rabbit> farm4 = new RabbitFarm<>();         // Rabbit/Bunny/DrunkenBunny 다 가능.
        RabbitFarm<Bunny> farm5 = new RabbitFarm<>();          // Bunny만 가능.
        RabbitFarm<DrunkenBunny> farm6 = new RabbitFarm<>();   // DrunkenBunny만 가능.

        farm4.setRabbit(new Rabbit());
        farm4.getRabbit().cry();

        farm4.setRabbit(new Bunny());
        farm4.getRabbit().cry();                                //동적 바인딩


//        farm5.setRabbit(new Rabbit());                        // 컴파일 에러 발생.
        farm4.setRabbit(new DrunkenBunny());
        farm4.getRabbit().cry();
    }
}
