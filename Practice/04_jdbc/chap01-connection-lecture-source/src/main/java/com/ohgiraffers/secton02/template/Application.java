package com.ohgiraffers.secton02.template;

import java.sql.Connection;
import java.sql.SQLException;

/* 설명. 다른 클래스의 static method를 클래스명을 쓰지 않고 메소드만 호출 할려면 import static을 한다. */
import static com.ohgiraffers.secton02.template.JDBCTemplate.close;
import static com.ohgiraffers.secton02.template.JDBCTemplate.getConnection;
//import static 을 사용하면 다른 클래스의 static 메소드를 소속을 밝히지 않고 사용 가능하다. (메소드 이름까지 써야함)

public class Application {
    public static void main(String[] args) {

        Connection con = getConnection(); // 모듈화

        /* 설명. 비즈니스 로직(트랜잭션 관련) 실행 */
        System.out.println("con = " + con);
        System.out.println("Connection 객체를 활용해 DB와 SQL로 소통 ");

        close(con);                       // 모듈화
    }
}
