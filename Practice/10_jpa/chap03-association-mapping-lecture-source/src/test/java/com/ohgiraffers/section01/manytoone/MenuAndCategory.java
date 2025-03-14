package com.ohgiraffers.section01.manytoone;


import jakarta.persistence.*;

@Entity(name="menu_and_category")
@Table(name="tbl_menu")
public class MenuAndCategory {      //카테고리를 품은 메뉴
    @Id
    @Column(name="menu_code")
    private int menuCode;

    @Column(name="menu_name")
    private String menuName;

    @Column(name="menu_price")
    private int menuPrice;

    /* 궁금. join을 고려하여 대상과의 관계를 mapping 해줘야한다.
    *   1. menu , category 전체 카디널리티를 따져야함.
    *   -> 어떤 관계를 가지고 있느냐
    * */
    /* 궁금. 양쪽의 관계를 따져서 가장 큰 관계를 x : x 으로 표현.
    *   (1:n, n:m , 1:1 , .... -> 결과적으로 n:m이 됨)
    *   이럴 경우 교차 엔티티(중간단계가) 하나 생긴다*/
    @ManyToOne(fetch = FetchType.LAZY)                              // 메뉴 -> 카테고리의 전체 카디널리티 (fetch = FetchType.LAZY)
    @JoinColumn(name="category_code")       // FK 제약조건이 있는 컬럼명(자식 테이블에 있는 컬럼명만 쓴다.)
    private Category category;                      // 메뉴 1개가 카테고리 엔티티 객체를 몇개 가지는지(List<타입>/타입)

    @Column(name="orderable_status")
    private String orderableStatus;


    public MenuAndCategory() {
    }

    public MenuAndCategory(int menuCode, String menuName, int menuPrice, Category category, String orderableStatus) {
        this.menuCode = menuCode;
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.category = category;
        this.orderableStatus = orderableStatus;
    }

    public int getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(int menuCode) {
        this.menuCode = menuCode;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public int getMenuPrice() {
        return menuPrice;
    }

    public void setMenuPrice(int menuPrice) {
        this.menuPrice = menuPrice;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getOrderableStatus() {
        return orderableStatus;
    }

    public void setOrderableStatus(String orderableStatus) {
        this.orderableStatus = orderableStatus;
    }

    @Override
    public String toString() {
        return "MenuAndCategory{" +
                "menuCode=" + menuCode +
                ", menuName='" + menuName + '\'' +
                ", menuPrice=" + menuPrice +
//                ", category=" + category +
                ", orderableStatus='" + orderableStatus + '\'' +
                '}';
    }
}
