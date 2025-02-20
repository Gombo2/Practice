package com.ohgiraffers.section01.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/* 수업목표. 해당 DBMS 경로와 계정에 맞는 Connection 객체를 생성할 수 있다.(feat. 해당 DBMS driver 라이브러리 필요) */
public class Application1 {
    public static void main(String[] args) {
        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb",
                    "practice",
                    "practice");
            System.out.println("Connection 객체: " + con);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try{
                if(con != null) con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
