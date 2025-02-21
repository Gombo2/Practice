package com.ohgiraffers.section01.statement;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application2 {
    public static void main(String[] args) {
        Connection con = getConnection();       //사용자가 요청할때마다 감당함. 길임.

        Statement stmt = null;
        ResultSet rset = null;

        try {
            stmt = con.createStatement();

            /* 설명. 사용자로부터 사변을 입력받아 사원 조회 */
            Scanner sc = new Scanner(System.in);
            System.out.println("사번을 입력해 주세요: ");
            int empId = sc.nextInt();

            /* 설명. java에서 쿼리를 작성해 전달하게 될 때는;(세미콜론)을 생략한다.*/
            String query = "SELECT * FROM EMPLOYEE WHERE EMP_ID = '" + empId + "'";
            rset = stmt.executeQuery(query);

            if(rset.next()) {
                System.out.println("조회하신 " + empId + "번 사원은 " +
                        rset.getString("EMP_NAME") + "입니다.");
            } else {
                System.out.println("해당 사원은 존재하지 않습니다.");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rset);
            close(stmt);
            close(con);
        }

    }
}
