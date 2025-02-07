package com.ohgiraffers.section03.filterstream;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Application3 {
    public static void main(String[] args) {

        /* 수업목표. 데이터 타입 입출력 보조 스트림을 이해하고 활용할 수 있다. */
        DataOutputStream dos = null;
        try {
            //int,double,float 단위등 타입단위로 쏠 수 있음, 그대신 읽을때도 int,dobule,float 순으로 받아야함
            dos = new DataOutputStream(
                    new FileOutputStream(
                            "src/main/java/com/ohgiraffers/section03/filterstream/testData.txt"
                    )
            );
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (dos != null) {
                    dos.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
