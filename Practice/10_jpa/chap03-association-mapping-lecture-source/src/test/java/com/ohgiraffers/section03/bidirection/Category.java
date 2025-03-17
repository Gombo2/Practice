package com.ohgiraffers.section03.bidirection;

import jakarta.persistence.*;

import java.util.List;

@Entity(name="bidirection_category")
@Table(name = "tbl_category")
public class Category {

    @Id
    @Column(name="category_code")
    private int categoryCode;

    @Column(name="category_name")
    private String categoryName;

    @Column(name="ref_category_code")
    private Integer refCategoryName;

    @OneToMany(mappedBy="category")
    private List<Menu> menuList;

    public Category() {
    }

    public Category(int categoryCode, String categoryName, Integer refCategoryName, List<Menu> menuList) {
        this.categoryCode = categoryCode;
        this.categoryName = categoryName;
        this.refCategoryName = refCategoryName;
        this.menuList = menuList;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getRefCategoryName() {
        return refCategoryName;
    }

    public void setRefCategoryName(Integer refCategoryName) {
        this.refCategoryName = refCategoryName;
    }

    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }

    @Override
    public String toString() {
        return "CategoryAndMenu{" +
                "categoryCode=" + categoryCode +
                ", categoryName='" + categoryName + '\'' +
                ", refCategoryName=" + refCategoryName +
//                ", menuList=" + menuList +      // 둘중에 한곳이라도 참조를 안하면 순환참조가 일어나지 않는다.
                '}';
    }
}
