package com.ohgiraffers.section01.connection;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Application2 {
    public static void main(String[] args) {
        Properties prop = new Properties(); //Properties 객체 생성
        Connection con = null;              //통로 선언

        /* 궁금3. prop.load(new FileReader "경로") 후
            필요한 값들을 properties.getProperty("key") 메소드 이용하여 value 반환
            중요한 값들을 숨기며 사용할 수 있다는 장점이 있다. */
        try {
            prop.load(new FileReader("src/main/java/com/ohgiraffers/section01/connection/jdbc-config.properties"));

            String driver = prop.getProperty("driver");
            String url = prop.getProperty("url");
            String user = prop.getProperty("user");
            String password = prop.getProperty("password");

            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            System.out.println("con = " + con);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
}
