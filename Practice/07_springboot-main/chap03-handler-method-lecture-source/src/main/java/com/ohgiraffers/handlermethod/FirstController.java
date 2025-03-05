package com.ohgiraffers.handlermethod;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("/first")   // Controller에서 1차적으로 /first @ 에 대한 요청을 받아옴.
public class FirstController {

    /* 설명. 핸들러 메소드에서 반환형이 없을 경우 요청경로를 반환한다.(view의 경로 및 이름)*/
    @GetMapping("/regist") //안에서 2차 세부를 나누어 받음.
//    public String regist() {
//        return "/first/regist";
//    }

    public void regist() {}


    /* 설명. request의 사용자의 입력값(parameter)를 담는 용도로 쓰고 Model은 백엔드에서 동적 페이지를 만들 때 사용. */
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

    @GetMapping("modify")
    public void modify() {} //handler의 이름(메소드명) 은 아무렇게나 지정 가능.


    /* 설명.
    *   request의 parameter로 넘어오는 값 들의 key값과 일치하는 변수명(어노테이션 생략 가능)을 작성하고 @RequestParam
    *   어노테이션을 적용하면 알아서 값을 꺼내고 해당 매개변수의 자료형에 맞게 변환까지 해 준다.(물론 가능한 경우)*/

    /* 설명.
    *   1. defaultValue: 사용자의 입력 값이 없거나("") 아니면 request의 parameter 키 값과 일치하지 않는
    *                    매개변수 사용 시 매개변수가 가질 기본 default값을 작성한다.
    *   2. name: request parameter의 키 값과 다른 매개변수 명을 사용하고 싶을 때 requeset parameter의
    *            키 값을 작성한다.
    * */

    @PostMapping("modify1")
    public String modify1(Model model,
//                          @RequestParam(name="name") String modifyName,
                          @RequestParam(name="name", defaultValue = "디폴트") String modifyName,
//                          @RequestParam(name="modifyPrice") int modifyPrice) {
                          @RequestParam(name="modifyPrice", defaultValue = "0") int modifyPrice) {
//                          int modifyPrice) {
        /* 설명. 넘어온 parameter의 키 값과 핸들러 메소드의 매개변수 이름이 같으면 생략 가능. */

        /* 설명. 넘어온 데이터들로 update를 하고 성공했다는 가정*/

        String message = modifyName + "메뉴의 가격을 " + modifyPrice + "로 변경하였습니다.";
        model.addAttribute("message", message);

        return "first/messagePrinter";
    }

    @PostMapping("modify2")
    public String modify2(Model model,
                          @RequestParam Map<String, String> parameterMap) {
        String modifyName = parameterMap.get("name");
        int modifyPrice = Integer.parseInt(parameterMap.get("pr"));

        String message = modifyName + "메뉴의 가격을 " + modifyPrice + "로 변경하였습니다.";
        model.addAttribute("message", message);

        return "first/messagePrinter";
    }
}
