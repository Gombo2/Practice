package com.ohgiraffers.section01.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

//@WebFilter(filterName = "secondFilter", urlPatterns = "/first/*")
@WebFilter(filterName = "secondFilter")
public class SecondFilter implements Filter {
    public SecondFilter() {
        System.out.println("SecondFilter 인스턴스 생성");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("SecondFilter의 init 호출!");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("SecondFilter의 doFilter 호출! ");

        /* 설명. FilterChain에서 제공하는 doFilter는 다음 필터 또는 서블릿으로 진행하라는 의미이다. */
        filterChain.doFilter(servletRequest, servletResponse);

        System.out.println("서블릿 다녀온 후");
    }

    @Override
    public void destroy() {
        System.out.println("SecondFilter의 destory 호출!");
    }
}
