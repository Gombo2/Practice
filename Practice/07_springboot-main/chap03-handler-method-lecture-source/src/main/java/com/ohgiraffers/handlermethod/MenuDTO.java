package com.ohgiraffers.handlermethod;

public class MenuDTO {
    /* 궁금. 각각의 key값과 일치한 field 명을 사용해여 바로 직접 사용할 수 있다.*/

    private String name;
    private int price;
    private int categoryCode;
    private String orderableStatus;

    /* 설명. Spring은 기본생성자를 내부적으로 사용하기에 꼭 필요하다! */
    public MenuDTO() {
    }

    public MenuDTO(String name, int price, int categoryCode, String orderableStatus) {
        this.name = name;
        this.price = price;
        this.categoryCode = categoryCode;
        this.orderableStatus = orderableStatus;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }

    public void setOrderableStatus(String orderableStatus) {
        this.orderableStatus = orderableStatus;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public String getOrderableStatus() {
        return orderableStatus;
    }

    @Override
    public String toString() {
        return "menuDTO{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", categoryCode=" + categoryCode +
                ", orderableStatus='" + orderableStatus + '\'' +
                '}';
    }

}
