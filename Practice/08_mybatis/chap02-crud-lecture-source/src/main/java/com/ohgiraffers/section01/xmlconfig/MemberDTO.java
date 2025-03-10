package com.ohgiraffers.section01.xmlconfig;

public class MemberDTO {
    private int menuCode;
    private String menuName;
    private int menuPrice;
    private int categoryCode;
    private String oderableStatus;

    public MemberDTO() {
    }

    public MemberDTO(int menuCode, String menuName, int menuPrice, int categoryCode, String oderableStatus) {
        this.menuCode = menuCode;
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.categoryCode = categoryCode;
        this.oderableStatus = oderableStatus;
    }

    public int getMenuCode() {
        return menuCode;
    }

    public String getMenuName() {
        return menuName;
    }

    public int getMenuPrice() {
        return menuPrice;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public String getOderableStatus() {
        return oderableStatus;
    }

    public void setMenuCode(int menuCode) {
        this.menuCode = menuCode;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public void setMenuPrice(int menuPrice) {
        this.menuPrice = menuPrice;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }

    public void setOderableStatus(String oderableStatus) {
        this.oderableStatus = oderableStatus;
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "menuCode=" + menuCode +
                ", menuName='" + menuName + '\'' +
                ", menuPrice=" + menuPrice +
                ", categoryCode=" + categoryCode +
                ", oderableStatus='" + oderableStatus + '\'' +
                '}';
    }

}
