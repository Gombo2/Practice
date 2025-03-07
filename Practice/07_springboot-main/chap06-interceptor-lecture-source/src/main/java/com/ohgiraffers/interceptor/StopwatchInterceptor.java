package com.ohgiraffers.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;


/* 설명.
*   1. bean을 다룰 수 있다.(필터와의 차이점)
*   2. 핸들러 메소드 직전/직후에 동작하여 전후 처리를 한다.
*   (forward 및 redirect 일지라도 매번 핸들러 메소드 실행시 동작)
*   3. 이후에 진행될 핸들러 메소드의 동작 여부를 제어할 수 있다.(preHandle 의반환형을 통해 [true,false])
*   인터셉트를 사용하는 경우(목적)
*   : 로그인 체크, 권환 체크, 프로그램 실행 시간 게산 작업 로그 처리, 업로드 파일 사이즈 처리(리사이징), 로케일(지역) 설정 등
* */
@Component
public class StopwatchInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("preHandle 호출함..(핸들러 메소드 이전)");


        /* 설명. requestHeadder에서 지역 추출 후 */
//        HttpSession session = request.getSession();
//        //사용자 전용 사물함.
//
//        Locale locale = (Locale)session.getAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME);
//        System.out.println("요청자의 국가: " + locale);
//
//        if(locale != null) {
//
//        } else {
//            session.setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, Locale.KOREA);
//        }

        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);

        /* 설명. 핸들러 인터셉터는 bean을 활용할 수 있으며 이후 핸들러 메소드 동작 여부를 반환형으로 제어할 수 있다.*/
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle 호출형...(핸들러 메소드 이후)");

        long startTime = (Long)request.getAttribute("startTime");
        long endTime = System.currentTimeMillis();


        /* 설명. postHandle의 ModelAndView는 Handler Method가 반환한 ModelAndView에 해당된다. */
        modelAndView.addObject("interval", endTime - startTime);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
