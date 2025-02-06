package com.ohgiraffers.section02.userexception;

import com.ohgiraffers.section02.userexception.exception.NotEnoughMoneyException;
import com.ohgiraffers.section02.userexception.exception.PriceNegativeException;

public class ExceptionTest {

    public void checkEnoughMoney(int price, int money) throws Exception {
        if(price < 0) {
            throw new PriceNegativeException("상품 가격은 음수일 수 없습니다.");
        }

        if(money < 0) {
            throw new NotEnoughMoneyException("돈이 부족하시네요.");
        }

        if(money < price) {

        }

    }
}
