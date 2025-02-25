package com.ohgiraffers.forward;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/print")
public class PrintLoginSuccessServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("===== 포워딩되어 서블릿에서 넘겨받은 request 객체에 담긴 값 확인 =====");
        System.out.println("이름 = " + req.getAttribute("username"));
        System.out.println("아이디 = " + req.getParameter("userId"));
        System.out.println("비밀번호 = " + req.getParameter("password"));
    }
}
