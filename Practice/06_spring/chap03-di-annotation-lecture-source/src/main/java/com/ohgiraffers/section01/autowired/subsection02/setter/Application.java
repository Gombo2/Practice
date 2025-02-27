package com.ohgiraffers.section01.autowired.subsection02.setter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.ohgiraffers.section01");

        BookService bookService = context.getBean("bookServiceSetter", BookService.class);

        bookService.findAllBook().forEach(System.out::println);

        System.out.println(bookService.findBookBySequence(1));
        System.out.println(bookService.findBookBySequence(2));

//        System.out.println("bookService = " + bookService);
    }
}
