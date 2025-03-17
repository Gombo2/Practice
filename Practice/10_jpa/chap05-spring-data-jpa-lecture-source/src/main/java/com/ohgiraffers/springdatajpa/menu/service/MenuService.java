package com.ohgiraffers.springdatajpa.menu.service;

import com.ohgiraffers.springdatajpa.menu.dto.MenuDTO;
import com.ohgiraffers.springdatajpa.menu.entity.Menu;
import com.ohgiraffers.springdatajpa.menu.repository.MenuRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class MenuService {

    private final MenuRepository menuRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public MenuService(MenuRepository menuRepository, ModelMapper modelMapper) {
        this.menuRepository = menuRepository;
        this.modelMapper = modelMapper;
    }


    /* 설명. 1. findById()*/
    public MenuDTO findMenuByCode(int menuCode) {

//        Menu menu = menuRepository.findById(menuCode).get();
        Menu menu = menuRepository.findById(menuCode).orElseThrow(IllegalArgumentException::new);
        log.debug("menu: {}", menu);

        return modelMapper.map(menu, MenuDTO.class);


    }

    /* 설명. 2. findAll() (페이징 처리 전)*/
    public List<MenuDTO> findMenuList() {
        List<Menu> menus = menuRepository.findAll(Sort.by("menuCode").descending());

        return menus.stream()
                .map(menu -> modelMapper.map(menu, MenuDTO))
                .collect(Collectors.toList());
    }

    /* 궁금. default page 보여주는 개수 변경 가능?*/
    /* 설명. 3. findAll() (페이징 처리 후)*/
    public Page<MenuDTO> findMenuList(@PageableDefault Pageable pageable){
        //페이지 인덱스 설정
        pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0: pageable.getPageNumber() - 1,
                pageable.getPageSize(),                         // 한 페이지에 표시할 데이터 개수 설정.
                Sort.by("menuCode").descending()); //menuCode 기준으로 내림차순 정렬.
        Page<Menu> menuList = menuRepository.findAll(pageable);

        return menuList.map(menu -> modelMapper.map(menu, MenuDTO.class));
    }
}
