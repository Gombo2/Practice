package com.ohgiraffers.parameter.section02.formdata;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/formdata")
public class FormDataTestServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /* 설명. tomcat 9버전 이하는 post 방식 요청일때 한글이 깨지지 않으려면 UTF-8로 인코딩 설정 해 주어야 한다. */
//        req.setCharacterEncoding("UTF-8");

        String name = req.getParameter("name");
        System.out.println("name = " + name);

        /* 설명. parameter들을 한번에 순회하며 확인하고 싶을 때 (key 값) */
        Enumeration<String> keyNames = req.getParameterNames();
        while (keyNames.hasMoreElements()) {
            System.out.println("keyNames = " + keyNames.nextElement());
        }
    }
}
