package com.ohgiraffers.orderservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ohgiraffers.orderservice.dto.OrderDTO;
import com.ohgiraffers.orderservice.vo.ResponseOrderVO;
import com.ohgiraffers.orderservice.service.OrderService;

@RestController
public class OrderController {
	private final OrderService orderService;

	@Autowired
	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}

	//주문에서 사용자정보를 userId에 해당하는 사람 요청받기
	@GetMapping("/users/orders/{userId}")
	public ResponseEntity<List<ResponseOrderVO>> getUserOrders(@PathVariable int userId) {
		List<OrderDTO> orderDTOList = orderService.getOrderByUserId(userId);
	}

}
