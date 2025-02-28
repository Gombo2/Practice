package com.ohgiraffers.common;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
//@AllArgsConstructor       // 상속받은 부모 생성자는 물려받지 않아서 없다. 못씀..
//@ToString
public class Beverage extends Product{
    private int capacity;       // 용량(ml)

    public Beverage(String name, int price, int capacity) {
        super(name, price);
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Beverage{" +
                "capacity=" + capacity +
                "} " + super.toString();
    }
}
