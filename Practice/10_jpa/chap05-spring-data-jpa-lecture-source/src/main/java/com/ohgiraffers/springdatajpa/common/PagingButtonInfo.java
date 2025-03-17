package com.ohgiraffers.springdatajpa.common;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/* 궁금. 페이지 버튼을 화면에 표시하기 위한 세가지 재료를 지닌 객체*/

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class PagingButtonInfo {
    private int currentPage;
    private int startPage;
    private int endPage;
}
