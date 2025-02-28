package com.ohgiraffers.common;

import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
public class ShoppingCart {

    private final List<Product> items;      //fianl -> 생성자 통해서 반드시들어가도록 해줘야함.

    public ShoppingCart() {
        this.items = new ArrayList<Product>();
    }

    /* 설명. 카트에 물품을 담는 기능 */
    public void addItem(Product item) {
        items.add(item);
    }


    /* 설명. 카트에 물품 꺼내는 기능 */
    public List<Product> getItems() {
        return items;
    }


}
