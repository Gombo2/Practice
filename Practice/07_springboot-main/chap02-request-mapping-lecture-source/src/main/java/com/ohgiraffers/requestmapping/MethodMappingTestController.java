package com.ohgiraffers.requestmapping;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MethodMappingTestController {
//    @RequestMapping(value = "/menu/regist")   // GET 요청 뿐 아니라 다른 요청도 받음
    @RequestMapping(value = "/menu/regist", method= RequestMethod.GET)
    public String registMenu(Model model) {     //Model은 SSR에서 쓰는 것으로 응답형 페이지의 재료가 됨.
        System.out.println("/menu/regist 경로의 GET 요청 받아보기");

        model.addAttribute("message", "신규 메뉴 등록용 핸들러 메소드 호출함...");



        /* 설명. 핻늘러 메소드에서 반환환 String은 응답 값이 아닌 view(html 파일 이름)이 된다. -> pre,sub fix가 접두 접미에 붙어서.*/
        return "mappingResult";
        // 내가 동적으로 만들어낸 view의 이름이 됨. (그냥 Controller의 기준)
        // servlet때 07-forwarding이랑 같은 느낌.

    }

    @RequestMapping(value="/menu/modify", method=RequestMethod.POST)
    public String modifyMenu(Model model) {
        model.addAttribute("message", "POST 방식의 메뉴 수정용 핸들러 메소드 호출용...");

        return "mappingResult";
    }
}
