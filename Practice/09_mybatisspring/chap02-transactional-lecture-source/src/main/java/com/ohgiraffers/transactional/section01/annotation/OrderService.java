package com.ohgiraffers.transactional.section01.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class OrderService {

    /* 설명. Order 도메인과 Menu 도메인 두개를 하나의 Service에서 트랜잭션 상 쓰는 경우를 상정 */
    private OrderMapper orderMapper;
    private MenuMapper menuMapper;

    @Autowired
    public OrderService(OrderMapper orderMapper, MenuMapper menuMapper) {
        this.orderMapper = orderMapper;
        this.menuMapper = menuMapper;
    }

    /* 설명. Service 계층의 메소드가 DML 작업용 트랜잭션이면 @Transactional을 추가한다. */
    @Transactional
    public void registNewOrder(OrderDTO orderInfo) {

        /* 설명. 1. 주문한 메뉴 코드만 추출(DTO에서) */
//        List<Integer> menuCodes = new ArrayList<>();
//        List<OrderMenuDTO> orderMenus = orderInfo.getOrderMenus();
//        for (OrderMenuDTO orderMenu : orderMenus) {
//            menuCode.add(orderMenu.getMenuCode());
//        }
        List<Integer> menuCodes = orderInfo.getOrderMenus()
                                        .stream()
                                        .map(OrderMenuDTO::getMenuCode)
                                        .collect(Collectors.toList());

        Map<String, List<Integer>> map = new HashMap<>();
        map.put("menuCodes", menuCodes);

        /* 설명. 2. 주문한 메뉴 별로 Menu엔티티에 담아서 조회(select)해 오기(부가적인 메뉴의 정보 추출) */
        List<Menu> menus = menuMapper.selectMenuByMenuCodes(map);
        menus.forEach(System.out::println);

        /* 설명. 3. 이 주문건에 대한 주문 총 합계를 계산 */
        int totalOrderPrice = calcTotalPrice(orderInfo.getOrderMenus(), menus);

        /* 설명. 4. 1부터 3까지 하면 tbl_order 테이블에 추가(insert) */
        /* 설명. 4-1. OrderDTO -> Order */
        Order order = new Order(orderInfo.getOrderDate(), orderInfo.getOrderTime(), totalOrderPrice);

        /* 설명. 4-2. Order로 insert  (도메인마다 다른 매퍼 사용 // 수정 : selectKey를 통해 insert 하고 나서의 주문번호를) */
        /* 설명. orderCode에 담긴 상태로 돌아옴.*/
        orderMapper.registOrder(order);

        /* 설명. 5. tbl_order_menu 테이블에도 주문한 메뉴 갯수만큼 메뉴를 추가(insert) */

        /* 설명. 5 - 1. OrderDTO -> List<OrderMenuDTO> -> List<OrderMenu> */
        List<OrderMenu> oMenus = new ArrayList<>();
        List<OrderMenuDTO> orderMenuDTO = orderInfo.getOrderMenus();
        for (OrderMenuDTO menuDTO : orderMenuDTO) {
            oMenus.add(new OrderMenu(order.getOrderCode(), menuDTO.getMenuCode(), menuDTO.getOrderAmount()));
        }
    }

    private int calcTotalPrice(List<OrderMenuDTO> orderMenus, List<Menu> menus) {
        int totalPrice = 0;

        int orderMenuSize = orderMenus.size();
        for(int i = 0; i < orderMenuSize; i++) {
            OrderMenuDTO orderMenu = orderMenus.get(i);
            Menu menu = menus.get(i);
            totalPrice += orderMenu.getOrderAmount() * menu.getMenuPrice();
        }

        return totalPrice;
    }
}
