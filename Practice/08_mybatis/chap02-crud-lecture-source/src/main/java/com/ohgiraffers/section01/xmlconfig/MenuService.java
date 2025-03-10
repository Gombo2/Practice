package com.ohgiraffers.section01.xmlconfig;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.section01.xmlconfig.Template.getSqlSession;

public class MenuService {
    private final MenuDAO menuDAO;

    public MenuService() {
        menuDAO = new MenuDAO();
    }

    // 열고 닫는거까지 서비스 계층이 담당.
    public List<MemberDTO> findAllMenus() {
        SqlSession sqlSession = getSqlSession();

        List<MemberDTO> menuList = menuDAO.selectAllMenus(sqlSession);

        sqlSession.close();

        return null;
    }
}
