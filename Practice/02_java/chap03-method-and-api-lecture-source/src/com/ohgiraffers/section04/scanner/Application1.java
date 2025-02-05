package com.ohgiraffers.section04.scanner;
import java.util.Scanner;

public class Application1 {
    public static void main(String[] args) {
        
        /* 수업목표. java.util.Scanner를 이용해 다양한 자료형의 값 입력 받기 */
        Scanner sc = new Scanner(System.in);

        /* 설명. 0. next()를 활용한 문자열 입력(next()는 띄어쓰기나 엔터가 인지되지 않는다.)*/
        System.out.println("소속을 입력하세요 : ");
        String className = sc.next();
        System.out.println("className = " + className);

        sc.nextLine();

        /* 설명. nextLine()을 활용한 콘솔(console)에서의 문자열 입력 */
        System.out.println("이름을 입력하세요: ");
        String name = sc.nextLine();
        System.out.println("name = " + name);

        /* 설명. 2. nextInt()를 활용한 정수 입력*/
        System.out.println("나이를 입력하세요 : ");
        int age = sc.nextInt();
        System.out.println("age = " + age);

        /* 설명. 3. nextDouble()을 활용한 실수 입력 */
        System.out.println("키를 입력하세요 : ");
        double height = sc.nextDouble();
        System.out.println("hegiht = " + height);
    }
}
