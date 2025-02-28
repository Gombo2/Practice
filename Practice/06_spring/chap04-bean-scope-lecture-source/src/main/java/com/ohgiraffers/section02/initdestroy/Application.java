package com.ohgiraffers.section02.initdestroy;

import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import com.ohgiraffers.common.ShoppingCart;
import com.ohgiraffers.section01.scope.singleton.ContextConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(ContextConfiguration.class);

        String[] beanNames = context.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            System.out.println("beanName = " + beanName);
        }
        /* 설명. 붕어빵, 딸기우유, 지리산 암반수를 진열. */
        Product carpBread = context.getBean("carpBread", Bread.class);
        Product milk = context.getBean("milk", Beverage.class);
        Product water = context.getBean("water", Beverage.class);

        /* 설명. 첫 번째 손님이 입장해서 쇼핑카트를 꺼내 물건을 담는다.*/
        ShoppingCart cart1 = context.getBean("cart", ShoppingCart.class);
        cart1.addItem(carpBread);
        cart1.addItem(milk);

        System.out.println("첫 번째 손님의 카트  = " + cart1);

        /* 설명. 두 번재 손님이 입장해서 쇼핑카트를 꺼내 물건을 담는다. */
        ShoppingCart cart2 = context.getBean("cart", ShoppingCart.class);

//        System.out.println("두 번째 손님의 카트  = " + cart2);
//        System.out.println("두 카트가 같은 객체인가?  = " + (cart1 == cart2));        //singleton이다.

        cart2.addItem(water);
        System.out.println("두 번째 손님의 카트: " + cart2);

        /* 설명. main 메소드 종료 전에 Container를 제거(bean 제거 강제화)*/
        ((AnnotationConfigApplicationContext)context).close();
    }
}
