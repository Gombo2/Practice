package com.ohgiraffers.section02.extend.vo;

/* 설명.
 *  와일드카드(wildcard)
 *   제네릭 클래스 타입의 객체를 메소드의 매개변수로 받을 때 타입 변수를 제한할 수 있다.
 *   <?>: 제한 없음
 *   <? extends Type>: 와일드카드의 상한 제한(해당 Type과 Type의 후손을 이용해 생성된 제네릭 인스턴스만 가능)
 *   <? super Type>: 와일드카드의 하한 제한(해당 Type과 Type의 부모를 이용해 생성된 제네릭 인스턴스만 가능)
* */
public class WildCardFarm {

    /* 설명. 어떤 타입의 RabbitFarm(제네릭 타입)이 와도 상관 없다. */
    public void anyType(RabbitFarm<?> farm) {
        farm.getRabbit().cry();
    }

    /* 설명. RabbitFarm 중에서도 Bunny 또는 하위 타입이 있는 RabbitFarm만 가능 */
    public void extendsType(RabbitFarm<? extends Bunny> farm) {
        farm.getRabbit().cry();
    }

    /* 설명. RabbitFarm 중에서도 Bunny 또는 상위 타입이 있는 RabbitFarm만 가능 */
    public void superType(RabbitFarm<? super Bunny> farm) {
        farm.getRabbit().cry();
    }
}
