package com.ohgiraffers.section03.sqlInjection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application2 {
    private static String empId = "200";
    private static String empName = "' OR 1=1 AND EMP_ID '200";

    public static void main(String[] args) {
        Connection con = getConnection();
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        /* 설명.
         *   아래 sql과 같이 PreparedStatement는 placeholder로 입력되는 값에 single quotation(')이 있다면
         * single quotation을 하나 더 이어 붙여주고, 양 옆에도 single quotation을 붙여준다.
         * 이를 통해 SQLInjection 공격을 막게 된다.*/
        try {
            pstmt = con.prepareStatement("SELECT * FROM EMPLOYEE WHERE EMP_ID = ? AND EMP_NAME = ?");
            pstmt.setString(1, empId);
            pstmt.setString(2, empName);
            rset = pstmt.executeQuery();

            if(rset.next()) {
                System.out.println(rset.getString("EMP_NAME") + "님 환영합니다. ");
            } else {
                System.out.println("해당 회원은 존재하지 않습니다.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rset);
            close(pstmt);
            close(con);
        }


    }
}
