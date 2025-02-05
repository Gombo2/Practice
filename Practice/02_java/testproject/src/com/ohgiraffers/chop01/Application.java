package com.ohgiraffers.chop01;

class Application {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name = "홍길동";
        s1.number = "1234";
        s1.birthYear = 1999;

        Student s2 = new Student();
        s2.name = "홍길동";
        s2.number = "1234";
        s2.birthYear = 1999;

        if(s1.equlas(s2)) {
            System.out.println("s1 = " + s1);
        } else {
            System.out.println("s2 = " + s2);
        }
    }
}
