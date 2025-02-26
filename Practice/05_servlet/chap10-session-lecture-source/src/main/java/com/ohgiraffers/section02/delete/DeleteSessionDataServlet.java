package com.ohgiraffers.section02.delete;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/delete")
public class DeleteSessionDataServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        System.out.println("attribute 무효화 전 firstName: " + session.getAttribute("firstName"));
        System.out.println("attribute 무효화 전 lastName: " + session.getAttribute("lastName"));

        session.invalidate();       // HttpSession 객체의 Attribute 값들을 무효화(로그아웃 개념으로 많이 쓰게 된다.)

//        /* 설명. 무효화된 session에 attribute 접근을 하려면 500에러가 나타난다.*/
//        System.out.println("attribute 무효화 후 firstName: " + session.getAttribute("firstName"));
//        System.out.println("attribute 무효화 후 lastName: " + session.getAttribute("lastName"));

        /* 설명. session이 무효화되어 attribute를 가져올 수 없게 된다.(가져오려고 하면 500에러 발생) */

    }
}
