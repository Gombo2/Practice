package com.ohgiraffers.orderservice.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.ohgiraffers.orderservice", annotationClass = "Mapper.class")
public class MybatisConfiguration {

}
