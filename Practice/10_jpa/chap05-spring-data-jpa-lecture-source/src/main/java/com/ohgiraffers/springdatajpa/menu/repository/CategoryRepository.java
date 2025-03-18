package com.ohgiraffers.springdatajpa.menu.repository;

import com.ohgiraffers.springdatajpa.menu.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    
    //    쿼리를 직접 짜보는거임
    @Query(value="SELECT m FROM Category m ORDER BY m.categoryCode ASC")
    List<Category> findAllCategories();
}
