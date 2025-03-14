package com.ohgiraffers.section02.onetomany;

import jakarta.persistence.*;

import java.util.List;

@Entity(name="category_and_menu")
@Table(name = "tbl_category")
public class CategoryAndMenu {

    @Id
    @Column(name="category_code")
    private int categoryCode;

    @Column(name="category_name")
    private String categoryName;

    @Column(name="ref_category_code")
    private Integer refCategoryName;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="category_code")  // 자식이 되는 menu의 fk컬럼 명을 작성.
    private List<Menu> menuList;

    public CategoryAndMenu() {
    }

    public CategoryAndMenu(int categoryCode, String categoryName, Integer refCategoryName, List<Menu> menuList) {
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
//                ", menuList=" + menuList +
                '}';
    }
}
