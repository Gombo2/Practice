package com.ohgiraffers.section01.statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application1 {
    public static void main(String[] args) {

        /* 설명. Connection 객체 생성 */
        Connection con = getConnection();

//        System.out.println("con = " + con);

        Statement stmt = null; //트럭임

        /* 설명. 실행될 쿼리가 조회된 경우*/
        ResultSet rset = null; //결과 받아오는 트럭


        try {
            stmt = con.createStatement();

            rset = stmt.executeQuery("SELECT * FROM EMPLOYEE");

            /* 설명. 다중행 결과는 반복문 활용 */
            while(rset.next()) {
                /* 설명. 반복문 안에서의 rset은 한 행(단일 행)으로 해석한다. */
                System.out.println(rset.getString("EMP_NAME") + ", "
                + rset.getInt("SALARY"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
//            stmt.close();            // 선언한 순서 역순으로 닫아줘야함
            close(rset);
            close(stmt);
            close(con);
        }

    }

}
