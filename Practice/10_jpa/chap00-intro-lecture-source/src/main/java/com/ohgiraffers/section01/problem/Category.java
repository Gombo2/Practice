package com.ohgiraffers.section01.problem;

public class Category {
    private int categoryCode;
    private String category;

    public Category() {
    }

    public Category(int categoryCode, String category) {
        this.categoryCode = categoryCode;
        this.category = category;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public String getCategory() {
        return category;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryCode=" + categoryCode +
                ", category='" + category + '\'' +
                '}';
    }
}
