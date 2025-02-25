package com.ohgiraffers.section02;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;

@WebServlet("/header")
public class ResponseHeaderPrintServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();

        long currentTime = System.currentTimeMillis();      //현재 서버의 시간을 알려줌
        writer.print("<h1>" + currentTime + "</h1>");
        writer.print("<h1>" + new java.util.Date(currentTime) + "</h1>");
        writer.flush();
        writer.close();

        /* 설명. response 객체의 header 값에 대한 키-밸류 확인하기(개발자 도구에서도 확인 가능)*/
        Collection<String> responseHeaders = resp.getHeaderNames();
        Iterator<String> iter = responseHeaders.iterator();
        while (iter.hasNext()) {
            String headerName = iter.next();
            System.out.println("headerName = " + resp.getHeader(headerName));
        }

    }
}
