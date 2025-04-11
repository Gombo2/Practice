package com.ohgiraffers.bootproject.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ohgiraffers.bootproject.dto.CalculatorDTO;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class CalculatorController {

	@GetMapping("/health")
	public String healthCheck() {
		return "I'm alive!!";
	}

	//커맨드 객체로 프론트걸 받을거임 -> DTO로 한번에 받기
	//fetch의 결과로 promise에 담길 성공 결과가 response~DTO. 뒤의 DTO는  num1,num2받을 용도
	@GetMapping("/plus")
	public ResponseEntity<CalculatorDTO> plusTwoNumbers(CalculatorDTO calculatorDTO) {

		log.info("calculatorDTO: {}", calculatorDTO);

		return ResponseEntity.ok().body(null);
	}
}
