package com.ohgiraffers.section02.xmlconfig;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Application {
    public static void main(String[] args) {

        /* 설명. 공장을 짓는 과정을 Application에서 진행. */
        String resource = "mybatis-config.xml";

        SqlSession session = null;
        try {
            InputStream inputStream = Resources.getResourceAsStream(resource); // xml파일 사용시 Stream 형태로 만들어야 한다.

            SqlSessionFactory sqlSessionFactory =
                    new SqlSessionFactoryBuilder().build(inputStream);
            // 설계도를 쥐어주는데 설계도가 inputStream이다.
            session = sqlSessionFactory.openSession(false);
            // 여기서 session -> connection이고 상품 만들기.

            java.util.Date date = session.selectOne("mapper.selectNow");
            //제공하는 메소드(selectOne을 통해 우리가 지정한 쿼리를 호출해야함) 개요 및 환경설정 자료에 그림으로 나와있음. 기능6가지
            System.out.println("date = " + date);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            session.close();
        }
    }
}
