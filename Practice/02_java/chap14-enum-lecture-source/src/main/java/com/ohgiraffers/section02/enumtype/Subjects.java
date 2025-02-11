package com.ohgiraffers.section02.enumtype;

public enum Subjects {
    JAVA,
    MARIADB,
    JDBC,
    HTML,
    CSS,
    JAVASCRIPT;

    Subjects() {
        System.out.println("기본 생성자 실행됨...");
    }

    @Override
    public String toString() {
        return "@@@@" + this.name() + "@@@@";
    }
}
