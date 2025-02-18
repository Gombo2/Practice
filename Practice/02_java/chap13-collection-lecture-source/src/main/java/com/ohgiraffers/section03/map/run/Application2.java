package com.ohgiraffers.section03.map.run;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Application2 {
    public static void main(String[] args) {

        /* 수업목표. Properties에 대해 이해하고 활용할 수 있다. */
        /* 설명.
         *  Properties란?
         *   HashMap과 거의 유사하지만 key와 value 모두를 String으로만 사용할 수 있는
         *   자료구조이다.(제네릭을 별도로 요구 X)
         *   주로 설정과 관련된 파일과의 입출력에 사용된다.(store, load 등)
        * */
        Properties prop = new Properties();

        prop.setProperty("driver", "oracle.jdbc.driver.OracleDriver");
        prop.setProperty("url", "jdbc:oracle:thin:@localhost:1521:xe");
        prop.setProperty("user", "swcamp");
        prop.setProperty("password", "swcamp");

        System.out.println("prop = " + prop);

        try {
            prop.store(new FileOutputStream("driver.dat"),
                    "jbdc driver");
            prop.storeToXML(new FileOutputStream("driver.xml"),
                    "jdbc driver xml version");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        /* 설명. 방금 출력으로 내보낸 파일을 읽어와서 새로운 Properties에 담아보자. */
        Properties prop2 = new Properties();
        System.out.println("읽어오기 전: " + prop2);

        try {
//            prop2.load(new FileInputStream("driver.dat"));
            prop2.loadFromXML(new FileInputStream("driver.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("===== 읽어와 담긴 값 =====");
        System.out.println("드라이버: " + prop2.getProperty("driver"));
        System.out.println("경로: " + prop2.getProperty("url"));
        System.out.println("아이디: " + prop2.getProperty("user"));
        System.out.println("패스워드: " + prop2.getProperty("password"));

    }
}
