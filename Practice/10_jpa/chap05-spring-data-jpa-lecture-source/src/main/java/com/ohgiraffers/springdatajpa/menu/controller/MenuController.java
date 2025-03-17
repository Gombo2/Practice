package com.ohgiraffers.springdatajpa.menu.controller;

import com.ohgiraffers.springdatajpa.menu.dto.MenuDTO;
import com.ohgiraffers.springdatajpa.menu.entity.Menu;
import com.ohgiraffers.springdatajpa.menu.repository.MenuRepository;
import com.ohgiraffers.springdatajpa.menu.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/menu")
@Slf4j
public class MenuController {

    private final MenuService menuService;
    private final MenuRepository menuRepository;

    /* 설명.
     *  Logger를 활용한 로그 생성 이유?
     *   1. println보다 성능적으로 우수하다.
     *   2. 외부 리소스 파일로 따로 저장 및 송출이 가능하다.
     *   3. 로그레벨에 따른 확인이 가능하다.(개발: debug, 서비스: info)
    * */
//    Logger logger = LoggerFactory.getLogger(MenuController.class);
//    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    public MenuController(MenuService menuService, MenuRepository menuRepository) {
        this.menuService = menuService;
        this.menuRepository = menuRepository;
    }

    @GetMapping("/{menuCode}")
    public String findMenuByCode(@PathVariable int menuCode, Model model) {
//        System.out.println("menuCode = " + menuCode);
//        logger.debug("menuCode = {}", menuCode);
        log.debug("menuCode = {}", menuCode);

        MenuDTO menu = menuService.findMenuByCode(menuCode);

        model.addAttribute("menu", menu);

        return "menu/detail";
    }

    /* 설명. 페이징 처리 전*/
    @GetMapping("/list")
    public String findMenuList(Model model) {
        List<MenuDTO> menuList= menuService.findMenuList();

        model.addAttribute("menuList", menuList);

        return "menu/list";
    }

    /* 설명. 페이징 처리 후 */
    /* 설명.
    *   @PageableDefault
    *   1. 기본 한 페이지에 10개의 데이터(size, value)
    *   2. 기본 1페이지 부터(0부터 == 사실상 idx)
    *   3. 기본 오름차순(ASC)
    * */
    @GetMapping("/list")
    public String findMenuList(@PageableDefault Pageable pageable, Model model) {

        /* 궁금. 왜 페이지 타입? */
        Page<Menu> menuList = menuRepository.findAll(pageable);

        log.debug("조회한 내용 목록: {}", menuList.getContent());
        log.debug("총 페이지 수: {}", menuList.getTotalPages());
        log.debug("총 메뉴 수: {}", menuList.getTotalElements());
        log.debug("해당 페이지에 표시 될 요소 수: {}", menuList.getSize());
        log.debug("해당 페이지에 실제 요소 수: {}", menuList.getNumberOfElements());

        return "menu/list";
    }

}
