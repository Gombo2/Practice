package com.ohgiraffers.section02.xmlconfig;

import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new GenericXmlApplicationContext("section02/xmlconfig/spring-context.xml");


        /* 설명. 컨테이너에 들어있는 모든 bean의 이름(id)을 확인 */
        String[] beanNames = context.getBeanDefinitionNames();
        for(String beanName : beanNames) {
            System.out.println("beanName = " + beanName);
        }

        /* 설명. 1. bean의 id를 가지고 추출 */
//        MemberDTO member = (MemberDTO)context.getBean("member");
//        System.out.println("member = " + member);

        /* 설명. 2. bean의 클래스의 메타 정보*/
//        MemberDTO member = context.getBean(MemberDTO.class);

        /* 설명. 3. bean의 id와 클래스의 메타 정보를 전달하여 추출.*/
        MemberDTO member = context.getBean("member", MemberDTO.class);
        /* 궁금. bean의 이름은 unique한데, class 정보가 필요한 이유? */

        System.out.println("member = " + member);
    }
}
