package com.ohgiraffers.section02.uses;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

@WebFilter
public class EncodingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;


        /* 설명.
        *   톰캣 10버전 이전에는 post 요청일 때는 설정을 하지 않으면 한글이 깨지곤 했다.
        *   우린 10버전의 톰캣이라 굳이 해 주지 않아도 동작하지만 현업에서 경우에 따라 필요할 수도
        *   있고 추가로 다른 인코딩 설정으로 바꿀 때도 해당 방식의 필터로 활용할 수 있다.*/
        if("POST".equals(httpRequest.getMethod())) {
            httpRequest.setCharacterEncoding("UTF0-8");
        }

        filterChain.doFilter(httpRequest, servletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
