package com.ohgiraffers.section02.prepared;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application2 {
    public static void main(String[] args) {
        Connection con = getConnection();

        PreparedStatement pstmt = null;
        ResultSet rset = null;

        Scanner sc = new Scanner(System.in);
        System.out.print("사번을 입력하세요: ");
        String empId = sc.next();

        System.out.print("퇴사 여부를 입력하세요(Y/N): ");
        String entYn = sc.next();


        try {
            /* 설명. PreparedStatement는 Statement와 달리 placeholder('?')를 활용해 하나의 문자열 형태로 작성이 가능하다. */
            pstmt = con.prepareStatement("SELECT EMP_ID, EMP_NAME FROM EMPLOYEE WHERE EMP_ID  = ? AND ENT_YN = ?");
            pstmt.setString(1, empId);
            pstmt.setString(2, entYn);

            rset = pstmt.executeQuery();
            if (rset.next()) {
                System.out.println("조회하신 사원의 사번과 이름은 " + rset.getString("EMP_ID") +
                        ", " + rset.getString("EMP_NAME") + "입니다.");
            } else {
                System.out.println("조건에 해당하는 사원이 없습니다. ");
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
