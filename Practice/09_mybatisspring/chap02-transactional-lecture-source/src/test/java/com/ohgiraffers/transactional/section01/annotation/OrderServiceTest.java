package com.ohgiraffers.transactional.section01.annotation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


@SpringBootTest
//오히려 커밋을 하지 않고 테스트만 할 수 있게 해줌.
@Transactional
class OrderServiceTest {

    @Autowired
    OrderService orderService;

    private static Stream<Arguments> getOrderInfo() {
        OrderDTO orderInfo = new OrderDTO();
        orderInfo.setOrderDate(LocalDate.now());
        orderInfo.setOrderTime(LocalTime.now());

//        List<OrderMenuDTO> orderMenuList = new ArrayList<>();
//        orderMenuList.add(new OrderMenuDTO(3, 10));
//        orderMenuList.add(new OrderMenuDTO(4, 10));
//        orderInfo.setOrderMenus(orderMenuList);

        orderInfo.setOrderMenus(
                List.of(
                        new OrderMenuDTO(2, 1),
                        new OrderMenuDTO(3, 2),
                        new OrderMenuDTO(5, 3),
                        new OrderMenuDTO(8, 4)
                )
        );

        return Stream.of(
                Arguments.of(orderInfo)
        );
    }

    @DisplayName("주문 등록 테스트")
    @ParameterizedTest
    @MethodSource("getOrderInfo")
    void testRegistNewOrder(OrderDTO orderInfo) {
        Assertions.assertDoesNotThrow(
                () -> orderService.registNewOrder(orderInfo)
        );
    }
}