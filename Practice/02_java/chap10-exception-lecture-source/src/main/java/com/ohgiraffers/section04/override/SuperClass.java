package com.ohgiraffers.section04.override;

import java.io.IOException;

public class SuperClass {
    public void method() throws IOException {
        SuperClass subClass = new SubClass();


        try {
            subClass.method();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
