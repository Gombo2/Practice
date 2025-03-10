package com.ohgiraffers.section01.javaconfig;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

public class Application {
    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/employeedb";
    private static String user = "practice";
    private static String password = "practice";

    public static void main(String[] args) {
        /* 설명. 환경변수. ibatis -> 구글가서 만든게 mybatis 이름, JdbcTranscationFactory, PooledDataSource 필요.*/
        /* 설명. JdbcTranscationFactory : 수동
                ManagedTransactionFactory : 자동 커밋
                ------------------------------------
                PooledDataSource: ConnectionPool 사용    -> hikaricp 사용예정(springboot)
                UnPooledDataSource: ConnectionPool 미사용
        */
        Environment environment = new Environment(
                "dev",                                         // 이름이 겹치면 안된다.
                new JdbcTransactionFactory(),                   // 수동 커밋하겠다는 얘기.
                new PooledDataSource(driver, url, user, password) //저장공간이자 버퍼 만들고 필요할때 꺼내겠다는 얘기
        );


        /* 설명.
        *   SqlSessionFactory: SqlSession 객체를 생성하기 위한 팩토리 역할의 인터페이스
        *   SqlSessionFactoryBuilder: SqlsessionFactory 인터페이스 타입의 하위 구현 객체를 생성하기
        *                             위한 빌드 역할
        *   build(): 설정에 대한 정보를 담고 있는 Configuration 타입의 객체(java 방식) 혹은 외부 설정 파일과 연결된
        *            stream을 매개변수로 전달(xml 방식)하면 SqlSessionFactory 인터페이스 타입의 객체를 반환하는
        *            메소드
        * */

        /* 설명. 일꾼한테 줄 설계도 만들기. */
        Configuration configuration = new Configuration(environment);
        configuration.addMapper(Mapper.class);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration); // 공장 설립.
        SqlSession session = sqlSessionFactory.openSession(false); // 상품 생성. 수동커밋을 위해 false로 넣어줘야함.

        Mapper mapper = session.getMapper(Mapper.class); // 쿼리 불러오기.

        java.util.Date date = mapper.selectNow(); // 쿼리의 메소드 호출 및 출력
        System.out.println("date = " + date);

        session.close();    // connection 객체는 닫아주어야 함.
    }
}
