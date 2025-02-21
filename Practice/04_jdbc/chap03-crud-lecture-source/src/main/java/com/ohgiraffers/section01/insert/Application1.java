package com.ohgiraffers.section01.insert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application1 {
    public static void main(String[] args) {
        Connection con = getConnection();
        PreparedStatement pstmt = null;

        /* 설명.
        *   DML(insert, update, delete) 작업 시에는 반환 결과가 int값이 된다.(ResultSet X)
        *   그리고 조회에서는 excuteQuery()를 썼다면 excuetteUpdate()를 쓰게 된다.
        * */
        int result = 0;

        String query = "INSERT INTO tbl_menu\n" +
                "(MENU_NAME, menu_price, category_code , orderable_status)\n" +
                "VALUES\n" +
                "(?,?,?,?)";

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, "커피맛식혜");
            pstmt.setInt(2, 2000);
            pstmt.setInt(3, 6);
            pstmt.setString(4, "Y");

            result = pstmt.executeUpdate();

            /* 설명.
            *   잘못 작성된 부분 삭제
            *   delete form tbl_menu where menu_code > 24;
            *   내가 발생하고자 하는 번호로 초기화
            *   alter table tbl_menu auto_increment = 25;
            * */

            if(result > 0) {
                System.out.println("insert 결과: " + result + " 행이 추가됨.");
                /* 설명. JDBCTemplate에 setAutoCommit(false)설정할 것*/
                con.commit();
            } else {
                System.out.println("insert 실패: ");
                con.rollback();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
            close(con);
        }
    }
}
