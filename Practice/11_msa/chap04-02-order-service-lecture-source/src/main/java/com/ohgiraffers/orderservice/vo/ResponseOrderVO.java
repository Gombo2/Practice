package com.ohgiraffers.orderservice.vo;

import java.util.List;

import com.ohgiraffers.orderservice.dto.OrderMenuDTO;

public class ResponseOrderVO {
	private String orderDate;
	private String orderTime;

	private List<OrderMenuDTO> orderMenus;
}
