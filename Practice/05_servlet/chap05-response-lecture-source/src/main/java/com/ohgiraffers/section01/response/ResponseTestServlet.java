package com.ohgiraffers.section01.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

 @WebServlet("/response")
public class ResponseTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder responseText = new StringBuilder();
        responseText.append("<!DOCTYPE html>\n")
                .append("<html>\n")
                .append("<head>\n")
                .append("</head>\n")
                .append("<body>\n")
                .append("<h1>한글 servlet response</h1>\n")
                .append("</body>\n")
                .append("</html>");

        /* 설명. MINE 타입과 인코딩 설정을 해 주어야 (9버전 이하는 무조건)
        *   다만 우린 jakarta는 굳이 해주지 않아도 된다. */
//        resp.setContentType("text/html");
//        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        PrintWriter out = resp.getWriter(); // 돌아갈 길을열어라
        out.print(responseText);
        out.flush();
        out.close();
    }
}
