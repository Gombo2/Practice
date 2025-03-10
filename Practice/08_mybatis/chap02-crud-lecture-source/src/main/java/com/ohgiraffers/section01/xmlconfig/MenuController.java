package com.ohgiraffers.section01.xmlconfig;

import java.util.List;

public class MenuController {
    private final MenuService menuService; //수동 의존성 주입

    public MenuController() {
        menuService = new MenuService();
    }

    public void findAllMenus() {
        List<MemberDTO> menuList = menuService.findAllMenus();
        System.out.println("Controller에서 출력");
        menuList.forEach(System.out::println);
    }
}
