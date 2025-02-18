package com.ohgiraffers.section07.initblock;

public class Product {
    private String name = "아이폰";        // 상품명
    private int price;                    // 상품단가
    private static String brand;          // 제조

    /* 설명. 초기화 블럭은 생성자 이전에 실행되며 어떤 생성자로 객체를 생성하든 공통적인 로직이 있다면 작성 */
    {
        System.out.println("초기화 블럭 실행...");
        price = 170;
//        Product.brand = "삼성";
    }

    static {
//        price = 200;      // static 초기화 블럭에서는 인스턴스 변수에 접근이 불가능하다.
        Product.brand = "엘쥐";
    }

    public Product() {
        System.out.println("Product 기본 생성자 호출...");
        name = "샤오미폰";
    }

    public Product(String name) {
        this.name = name;
    }

    public Product(int price) {
        this.price = price;
    }

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", brand='" + Product.brand + '\'' +
                '}';
    }
}
