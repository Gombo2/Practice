package com.ohgiraffers.section01.xml;

import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

import static com.ohgiraffers.section01.xml.Template.getSqlSession;

public class MenuService {
    public void findMenuByPrice(int maxPrice) {
       SqlSession sqlSession = getSqlSession();
       MenuMapper mapper =
               sqlSession.getMapper(MenuMapper.class);

       List<MenuDTO> menus = mapper.selectMenuByPrice(maxPrice);
       System.out.println("===== Service Layer");
       menus.forEach(System.out::println);
       sqlSession.close();
    }

    public void searchMenu(SearchCriteria searchCriteria) {
        SqlSession sqlSession = getSqlSession();
        MenuMapper mapper = sqlSession.getMapper(MenuMapper.class);

        List<MenuDTO> menus = mapper.searchMenu(searchCriteria);
        System.out.println("===== Service Layer");
        menus.forEach(System.out::println);


        sqlSession.close();
    }

    public void searchMenuBySupCategory(SearchCriteria searchCriteria) {
        SqlSession sqlSession = getSqlSession();
        MenuMapper mapper = sqlSession.getMapper(MenuMapper.class);

        List<MenuDTO> menus = mapper.searchMenuBySupCategory(searchCriteria);
        System.out.println("===== Service Layer");
        menus.forEach(System.out::println);


        sqlSession.close();
    }

    public void searchMenuByRandomMenuCode(List<Integer> randomList) {
        SqlSession sqlSession = getSqlSession();
        MenuMapper mapper = sqlSession.getMapper(MenuMapper.class);

        List<MenuDTO> menus = mapper.searchMenuByRandomMenuCode(randomList);
        System.out.println("===== Service Layer");
        menus.forEach(System.out::println);


        sqlSession.close();

    }

    public void searchMenuByCodeOrSearchAll(SearchCriteria searchCriteria) {
        SqlSession sqlSession = getSqlSession();
        MenuMapper mapper = sqlSession.getMapper(MenuMapper.class);

        List<MenuDTO> menus = mapper.searchMenuByCodeOrSearchAll(searchCriteria);
        System.out.println("===== Service Layer");
        menus.forEach(System.out::println);


        sqlSession.close();
    }

    public void searchMenuByNameOrCategory(Map<String, Object> criteria) {
        SqlSession sqlSession = getSqlSession();
        MenuMapper mapper = sqlSession.getMapper(MenuMapper.class);

        List<MenuDTO> menus = mapper.searchMenuByNameOrCategory(criteria);
        System.out.println("===== Service Layer");
        menus.forEach(System.out::println);


        sqlSession.close();
    }

    public void modifyMenu(Map<String, Object> criteria) {
        SqlSession sqlSession = getSqlSession();
        MenuMapper mapper = sqlSession.getMapper(MenuMapper.class);

        int result = mapper.updateMenu(criteria);

        if(result == 1) {
            System.out.println("메뉴 정보 변경에 성공하였습니다.");
            sqlSession.commit();
        } else {
            System.out.println("메뉴 정보 변경에 실패하였습니다.");
            sqlSession.rollback();
        }

        sqlSession.close();
    }
}
