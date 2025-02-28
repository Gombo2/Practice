package com.ohgiraffers.section01.subsection03.constructor;

import com.ohgiraffers.section01.subsection03.constructor.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.ohgiraffers.section01");

        BookService bookService = context.getBean("bookServiceConstructor", BookService.class);
        bookService.findAllBook().forEach(System.out::println);
        System.out.println("2번 책: " + bookService.findBookBySequence(2));
    }
}