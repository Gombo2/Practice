package com.ohgiraffers.section01.insert;


import java.sql.Connection;

import static com.ohgiraffers.common.JDBCTemplate.*;

/* 설명. Service 계층은 Connection 객체 생성 및 소멸(close) 및 비즈니스 로직, 트랜잭션 처리(commit/rollback)*/
public class MenuService {


    public void registMenu(Menu menu) {
        /* 설명. Connection 객체는 메소드 내부에서 생성하고 소멸한다.(요청별/트랜잭션별) */
        Connection con = getConnection();

        MenuRepository repository = new MenuRepository();
        int result = repository.insertMenu(con, menu);

        /* 설명. JDBC에 메소드 추가.*/
        if(result == 1) {
            commit(con);
        } else {
            rollback(con);
        }
    }
}
