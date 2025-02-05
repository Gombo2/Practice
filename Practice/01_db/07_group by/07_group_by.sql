-- group by 절
-- 메뉴가 존재하는 카테고리 그룹 조회
-- 그룹 함수(sum, avg, count, max, min)를 적용하기 위한 설정
SELECT
		 category_code -- 그룹의 갯수만큼 select가 일어남
	FROM tbl_menu
  GROUP BY category_code;
  
-- 메뉴로 할당된 카테고리의 종류를 출력
-- FROM -> GROUP BY -> FROM 순 처리.

-- count 함수 활용
SELECT
		 COUNT(*) --  해당하는 그룹의 행의 갯수를 세어준다.
		,category_code
	FROM tbl_menu
  GROUP BY category_code;
		
-- count 함수
-- count (컬럼명 또는 *)
-- count (컬럼명): 해당 컬럼에 null이 없는 행의 갯수
-- count (*): 모든 행의 갯수.

SELECT
		 COUNT(*)
		,COUNT(ref_category_code) -- null이 아닌 카테고리 코드만 카운트.
	FROM tbl_category;
	
-- ----------------------------------------
-- sum 함수 활용

SELECT
		 category_code
		, SUM(menu_price)
	-- , menu_name 의미가 없음
	FROM tbl_menu
 GROUP BY category_code;

-- group by에 사용된  컬럼외에 다른 컬럼은 select절에 작성하지 말자(의미 x)
-- group by 절에서 사용된 컬럼 + group 함수만 select절에서 작성할 것.


-- avg 함수 활용
-- 반올림 : round, 올림 : ceil, 버림 : floor
SELECT 
		 category_code
		, ceil(AVG(menu_price))
	FROM tbl_menu
 GROUP BY category_code;
 
 
 -- -----------------------------------------------------------------------
 -- having 절
 -- group에 대한 조건을 작성하는 절.
 -- group을 설정할 때 쓰인 컬럼 또는 그룹함수로 조건을 거는 절 
 SELECT
 		 SUM(menu_price)
 	   , category_code
 	FROM tbl_menu
  GROUP BY category_code
--  HAVING category_code BETWEEN 5 AND 9;
HAVING SUM(menu_price) >= 20000;

-- -------------------------------------------------------
-- 6가지 절 모두 활용하기
SELECT
		 category_code
		, AVG(menu_price)
	FROM tbl_menu
 WHERE menu_price > 10000
 GROUP BY category_code
HAVING AVG(menu_price) > 12000
ORDER BY 1 DESC;
-- from절에 join , order by 절에 limit을 사용할 수 있음.

-- --------------------------------------------------------
-- rollup 함수 : 집계 함수
SELECT
		 SUM(menu_price)
		, category_code
	FROM tbl_menu
 GROUP BY category_code
	WITH ROLLUP;
	
-- group을 묶을 때 두개 이상의 기준(컬럼들)으로 그룹화하여 rollup	
SELECT
		 SUM(menu_price)
		, menu_price
		, category_code
	FROM tbl_menu
GROUP BY menu_price, category_code
	WITH ROLLUP;
-- 두개 이상의 컬럼일때 처음 group으로 중간합계가 나옴 : null
