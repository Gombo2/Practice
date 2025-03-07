package com.ohgiraffers.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/* 설명. Interceptor 추가 및 static(정적) 리소스 호출 경로 등록 설정. */
@Configuration
public class WebConfiguration implements WebMvcConfigurer {
    private StopwatchInterceptor stopwatchInterceptor;

    @Autowired
    public WebConfiguration(StopwatchInterceptor stopwatchInterceptor) {
        this.stopwatchInterceptor = stopwatchInterceptor;
    }
    //Pojo여서 Bean화시키기위해 interceptor @Component로 만들어 Bean화 (생성자를 통한 의존성 주입)


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(stopwatchInterceptor)
                .excludePathPatterns("/css/**");
    }


    //정적 화면 핸들러
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**")
                .addResourceLocations("classpath:static/css")
                .setCachePeriod(100);
    }
}
