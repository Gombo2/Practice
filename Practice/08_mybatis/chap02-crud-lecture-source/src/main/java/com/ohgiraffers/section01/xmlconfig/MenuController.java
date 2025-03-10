package com.ohgiraffers.section01.xmlconfig;

import java.util.List;

public class MenuController {
    private final MenuService menuService;
    private final PrintResult printResult;

    public MenuController() {
        menuService = new MenuService();
        printResult = new PrintResult();
    }

    public void findAllMenus() {
        List<MenuDTO> menuList = menuService.findAllMenus();
//        System.out.println("===== Controller에서 출력");
//        menuList.forEach(System.out::println);
        if(!menuList.isEmpty()) {       // 조회 성공
            printResult.printMenus(menuList);
        } else {                        // 조회 실패
            printResult.printErrorMessage("전체 메뉴 조회 실패!");
        }
    }
}
