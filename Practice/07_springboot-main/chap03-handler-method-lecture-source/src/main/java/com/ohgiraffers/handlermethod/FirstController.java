package com.ohgiraffers.handlermethod;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/first")   // Controller에서 1차적으로 /first @ 에 대한 요청을 받아옴.
public class FirstController {

    /* 설명. 핸들러 메소드에서 반환형이 없을 경우 요청경로를 반환한다.(view의 경로 및 이름)*/
    @GetMapping("/regist") //안에서 2차 세부를 나누어 받음.
//    public String regist() {
//        return "/first/regist";
//    }

    public void regist() {}

    @PostMapping("regist")  //  '/'를 안적어도 된다.
    public String registMenu(HttpServletRequest request, Model model) {
        String name = request.getParameter("name");
//        String price = request.getParameter("price");
//        String category = request.getParameter("categoryCode");
//        System.out.println("price = " + price);
//        System.out.println("category = " + category);
        /* 궁금. 여기부분 주석은 직접 궁금해서 처리한거.*/

        int price = Integer.parseInt(request.getParameter("price"));
        int categoryCode = Integer.parseInt(request.getParameter("categoryCode"));

        String message = name + "을(를) 신규 메뉴 목록의 " + categoryCode + "번 카테고리에 "
                + price + "원으로 등록하였습니다!!";

        model.addAttribute("message", message);

        return "first/messagePrinter";
    }
}
