-- join 

SELECT * FROM tbl_menu;
SELECT * FROM tbl_category;

SELECT
		 menu_name
		 , category_name
		--  , category_code -- ambiguos 에러 발생
	FROM tbl_menu 
	JOIN tbl_category ON tbl_menu.category_code = tbl_category.category_code;
	
	
	-- 별칭 작성 시
	-- 적어둔 테이블 순서대로 a,b,c.... 로 별칭을 부여함
	-- 테이블 또는 from 절에 별칭을 추가할 때는 mariadb는 싱글쿼테이션(') 없이 별칭을 작성해야한다.
	-- as는 생략이 가능.
	
	SELECT
		 a.menu_name
		 , b.category_name
		 , a.category_code
	FROM tbl_menu a -- AS는 생략 가능(table)달때
	JOIN tbl_category b ON a.category_code = b.category_code;
	
	-- -----------------------------------------------------
	-- inner join 25.01.06 (반드시 매칭될때)
	-- 1)on 활용(join할 조건 작성)(컬럼명이 다를 때는 반드시 on을 작성)
	
	SELECT
			a.menu_name
		, b.category_name
		, a.category_code
	FROM tbl_menu a
	INNER JOIN tbl_category b ON a.category_code = b.category_code;
	
	-- 위와 동일.
	-- using 활용(columns 명이  동일할때 같을 때는 using 활용해서 짧은 구문으로 작성 가능)
	SELECT
			a.menu_name
		, b.category_name
		, a.category_code
	FROM tbl_menu a
	INNER JOIN tbl_category b USING (category_code);
	
	SELECT * FROM tbl_category;
	-- ----------------------------------------------------------
	-- outer join
	-- 1) left join
	SELECT 
			a.category_name
			, b.menu_name
	 FROM tbl_category a
	 LEFT JOIN tbl_menu b ON a.category_code = b.category_code;
	 -- 상위 카테고리와 할당되지 않은 퓨젼 또한 출력.
	 
	-- 2) right join
SELECT 
			b.category_name
			, a.menu_name
	 FROM tbl_menu a
	 RIGHT JOIN tbl_category b ON a.category_code = b.category_code; 
	
-- ---------------------------------------------
-- n개의 join 실행 시. 1) from~ t a / right join t b / join t c / join t d
-- from~b 하고 나서 c랑 같이할때 보고싶은 값이 지워질수도 있음.( --> c,d에서 left join 을 통해서 계속 유지시켜줘야)


-- ------------------------------------------------------------
-- 3) cross join (모든 경우의 수가 매핑될때) ->  잘못된 경우. 직접쓸일 x 12*21 출력됨.
SELECT
		 *
	FROM tbl_menu a
  CROSS JOIN tbl_category b; 

-- ----------------------------------------------------------------
-- 4) self join (한,중,일 -> 식사에 해당  1/ 커피 쥬스 -> 음료 해당 2)
SELECT
		 *
	FROM tbl_category;

SELECT
		 *
	FROM tbl_category a
	JOIN tbl_category b ON (a.ref_category_code = b.category_code);


-- nested loop	
SELECT
		 *
	FROM tbl_menu a
	JOIN tbl_category b ON (a.category_code = b.category_code);