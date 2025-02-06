package com.ohgiraffers.section03.uses;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Application2 {
    public static void main(String[] args) {

        /* 수업목표. try-with-resource 구문을 이해하고 활용할 수 있다.(feat.finally 안씀) */
        try (BufferedReader br = new BufferedReader(new FileReader("test.dat"))) {
            //br.readLine(); 처럼 test.dat에서 글자하나씩 받아오면서 확인한다던지.
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
