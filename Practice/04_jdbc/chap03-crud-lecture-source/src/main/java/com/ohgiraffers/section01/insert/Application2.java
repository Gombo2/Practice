package com.ohgiraffers.section01.insert;

import java.util.Scanner;

/* 설명.
 *  Service 계층과 Repository(DAO(Data Access Object)) 계층을 구분하고 XML파일에서부터 쿼리를 불러와서
 *  insert 해보기
 * */
public class Application2 {

    /* 설명. view이자 controller개념(입력 받은 데이터로 하나의 Menu객체로 만들기) */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("메뉴의 이름을 입력하세요: ");
        String menuName = sc.nextLine();
        System.out.print("메뉴의 가격을 입력하세요: ");
        int menuPrice = sc.nextInt();
        System.out.print("카테고리 코드를 입력하세요: ");
        int categoryCode = sc.nextInt();
        System.out.print("판매 상태를 입력하세요: ");
        sc.nextLine();
        String orderableStatus = sc.nextLine();

        Menu menu = new Menu(menuName, menuPrice, categoryCode, orderableStatus);

        MenuService service = new MenuService();
        service.registMenu(menu);




    }
}