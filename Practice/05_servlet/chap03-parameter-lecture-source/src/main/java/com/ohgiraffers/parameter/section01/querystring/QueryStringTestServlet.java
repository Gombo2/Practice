package com.ohgiraffers.parameter.section01.querystring;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;

@WebServlet("/querystring")
public class QueryStringTestServlet extends HttpServlet {

    /* 설명. get 요청이 오면 doGet이 실행되고 이때 매개변수로 넘어온 HttpServletRequest에서 꺼낼 수 있다. */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        System.out.println("name = " + name);

        int age = Integer.parseInt(req.getParameter("age"));
        System.out.println("age = " + age);

        java.sql.Date birthday = java.sql.Date.valueOf(req.getParameter("birthday"));
        System.out.println("birthday = " + birthday);

        String gender = req.getParameter("gender");
        System.out.println("gender = " + gender);

        String national = req.getParameter("naitonal");
        System.out.println("national = " + national);

        String[] hobbies = req.getParameterValues("hobbies");
        System.out.println("hobbies = " + Arrays.toString(hobbies));
    }
}
