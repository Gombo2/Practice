package com.ohgiraffers.handlermethod;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Map;

@Controller
@RequestMapping("/first")   // Controller에서 1차적으로 /first @ 에 대한 요청을 받아옴.
/* 설명. 이 Controller 클래스의 핸드러 메소드에서 Model에 "id"라는 키 값으로 담긴 값은 HttpSession에 추가하는 어노테이션 */
/* 설명. HttpSession에서 제공하는 invalidate()가 아닌 SessionStatus가 제공하는 setComplete()를 통해 만료시킬 수 있다. */
@SessionAttributes({"id"})
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

    @GetMapping("search")
    public void serachMenu() {}


    /* 설명.
     *   핸들러 메소드에 우리가 작성한 클래스(bean X) 를 매개변수로 작성하면 스프링이 객체를 만들어 주고(기본생성자)
     *   setter로 값도 주입해 준다. 이러한 클래스의 객체를 '커맨드 객체'라고 부른다.
     *   (커맨드 객체는 기본 생성자와 setter가 필수 */
    /* 설명.
    *   @ModelAttribute 어노테이션을 활용하면 커맨드 객체를 모델에 attriute로 담아주며 이후 view의 재료로
    *   사용할 수 있다.(키 값 작성 유무에 따라 화면에서 활용하는 방법이 다르다.)*/

    @PostMapping("search")
    public String searchMenu(@ModelAttribute(name="menu") MenuDTO menu) {
        System.out.println("menu = " + menu);

        return "first/searchResult";
    }

    @GetMapping("login")
    public void login() {}

    @PostMapping("login")
    /* 설명. @RequestParam 형식으로 받은거(변수명이 같아 생략) + 추가 설정 없을시 기본 30분 지속 session 발생. */
    public String sessionTest1(String id, String pwd, HttpSession session){
        System.out.println("id = " + id);
        System.out.println("pwd = " + pwd);

    /* 설명. 로그인 성공을 가정(회원 조회 이후) HttpSession에 로그인 성공한 회원 정보 저장 */
        session.setAttribute("id",id);
        session.setAttribute("pwd",pwd);


        return "first/loginResult";
    }

    @GetMapping("logout1")
    public String logoutTest1(HttpSession session) {
        session.invalidate();

        return "first/loginResult";
    }

    /* 설명. Model에 담은 값 중에 일부를 HttpSession에 자동으로 담도록 어노테이션 활용 */
    @PostMapping("login2")
    public String sessionTest2(Model model, String id) {
        model.addAttribute("id",id);

        return "first/loginResult";
    }

    @GetMapping("logout2")
    public String logoutTest2(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        /* 설명. annotation을 통해 활성화된 session은 invalidate로 처리가 안되게 되있어서 SessionStatus를 활용해야 한다.*/

        return "first/loginResult";
    }

    @GetMapping("body")
    public void body() {}

    @PostMapping("body")
    public void body(@RequestBody String body,
                     @RequestHeader("content-type") String contentType,
                     @CookieValue(value="JSESSIONID") String sessionId) {
        System.out.println("body = " + body);
        System.out.println("contentType = " + contentType);
        System.out.println("sessionId = " + sessionId);
    }
}
