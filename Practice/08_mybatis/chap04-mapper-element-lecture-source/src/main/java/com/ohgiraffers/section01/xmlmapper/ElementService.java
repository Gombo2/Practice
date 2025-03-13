package com.ohgiraffers.section01.xmlmapper;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.section01.xmlmapper.Template.getSqlSession;

public class ElementService {

    public void selectResultMapTest() {
        SqlSession sqlSession = getSqlSession();
        ElementMapper mapper = sqlSession.getMapper(ElementMapper.class);

        List<MenuDTO> menus = mapper.selectResultMapTest();
        menus.forEach(System.out::println);

        sqlSession.close();
    }

    public void selectResultMapAssociationTest() {
        SqlSession sqlSession = getSqlSession();
        ElementMapper mapper = sqlSession.getMapper(ElementMapper.class);

        /* 설명. association 관게를 이용해서 메뉴가 카테고리를 가지고 있는 구조 (메뉴를 기준으로 category를 join)*/
        List<MenuAndCategoryDTO> menus = mapper.selectResultMapAssociationTest();
        menus.forEach(System.out::println);

        /* 설명. 객체 그래프 탐색이라고 한다.*/
        System.out.println("첫 번째 메뉴의 카테고리 이름 볼래: " + menus.get(0).getCategory().getCategoryName());

        sqlSession.close();

    }

    public void selectResultMapCollectionTest() {
        SqlSession sqlSession = getSqlSession();
        ElementMapper mapper = sqlSession.getMapper(ElementMapper.class);

        /* 설명. collection 관게를 이용해서 카테고리가 메뉴를 가지고 있는 구조 (카테고리를 기준으로 메뉴를 join)*/
        List<CategoryAndMenuDTO> categories = mapper.selectResultMapCollectionTest();
        categories.forEach(System.out::println);

        sqlSession.close();

    }
}
