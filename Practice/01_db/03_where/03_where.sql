
-- where절
-- 주문가능한 메뉴만 조회 

SELECT * FROM tbl_menu;

DESC tbl_menu; 						 -- 테이블의 구조(scheme) 바로 확인 가능.

SELECT 
		 orderable_status
	FROM tbl_menu
 WHERE orderable_status = 'y';   -- (Y, y)대소문자 상관 없음.


-- 메뉴명만 조회할때
SELECT
		 menu_name
	FROM tbl_menu
 WHERE orderable_status = 'y'; -- mariadb는 대소문자 크게 상관 x , 순서 잘 인지할 것. (해석의 순서) FROM -> WHERE -> SELECT 순. ++ -> ORDER BY까지.
 
 -- ------------------------------------------------------------------
 -- '기타' 카테고리에 해당하지 않는 메뉴를 조회하시오.
 
SELECT
		 *
	FROM tbl_category
 WHERE category_name = '기타';
 
 
 -- 카테고리 테이블을 통해 메뉴이도 있는 카테고리 코드 번호를 알게 됨(10번)
 SELECT
 		 *
	FROM tbl_menu
 WHERE category_code <> 10;  -- <>와 != 동일한 역할. (같지 않냐 mariadb 기준)
 

SELECT                        -- 위 두 함수와 동일한 기능.
		 *
	FROM tbl_menu
 WHERE category_code != (SELECT category_code
 									FROM tbl_category
 								 WHERE category_name = '기타');
 
 -- -------------------------------------------------------------
 
 -- =, != 과 같이 대소 비교 연산자(> , < . >= , <=)을 통해서도 where절에 활용할 수 있다.
 -- 5000원 이상의 메뉴 모든 컬럼 보기
 SELECT
 		*
	FROM tbl_menu
 WHERE menu_price >= 5000
 ORDER BY menu_price ASC;   -- 추가적으로 menu_price 기준으로 오름차순 정렬.
 
 
-- 5000원 이상이면서 7000원 미만인 메뉴 조합(AND)
SELECT
		 *
	FROM tbl_menu
 WHERE menu_price >= 5000 
 	AND menu_price < 7000;
 	
-- 10000원보다 초과하거나 5000원 이하인 메뉴 추천(OR)

SELECT
		 *
	FROM tbl_menu
 WHERE menu_price > 10000
 OR menu_price <= 5000
 ORDER BY menu_price ASC;
 
 -- 5000원 이하거나 카테고리 번호가 10번인 메뉴 조회
 SELECT
 		menu_code
 		, menu_name
 		, menu_price
 		, category_code
 		, orderable_status
	FROM tbl_menu
 WHERE menu_price <= 5000
	OR category_code = 10
 ORDER BY menu_price ASC;
 -- 수업끝나고서브쿼리 넣어보기.
 
 -- -----------------------------------------------------------------------
 -- between 연산자 활용하기.
 -- 가격이 5000원 이상이면서 9000원 이하인 메뉴 전체 컬럼 조회
 SELECT
 		 *							-- 전체 불러오는것 효율적이지 못함. 해당 값들만 불러와야.
   FROM tbl_menu
 WHERE menu_price >= 5000
   AND menu_price <= 9000;
   

SELECT
		 *
	FROM tbl_menu
 WHERE menu_price BETWEEN 5000 AND 9000; -- ( BETWEEN  a AND b ) 하한값, 상한값 순. / 또한 위와 동일. 초과나 미만 들어가면 사용 X
 
 
 SELECT
		 *
	FROM tbl_menu
 WHERE menu_price not BETWEEN 5000 AND 9000; -- 5000미만, 9000 초과
 
 -- ---------------------------------------------------------------------
 -- like문
 -- 제목, 작성자 등을 검색할 때 사용
 -- %라는 와일드카드는 0개 이상의 문자를 뜻하는 특수기호이다.
 
 
 SELECT
 		 *
	FROM tbl_menu
 WHERE menu_name LIKE '%밥%';   -- % 은 wildcard ///  % % 전후로 0개 이상의문자가 있다.


 SELECT
 		 *
	FROM tbl_menu
 WHERE menu_name not LIKE '%밥%';   -- % 은 wildcard ///  % % 전후로 0개 이상의문자가 있다. 
 
 -- --------------------------------------------------------------------------------
 -- in 연산자
 -- 카테고리가 '중식' or '커피' or '기타'인 매뉴 조회하기
 
SELECT
		 *
	FROM tbl_menu
	WHERE category_code = 5
	OR category_code = 8
	OR category_code = 10;
	
SELECT
		 *
	FROM tbl_menu
	WHERE category_code IN(5,8,10); -- 위의 코드와 동일.
 
 
 SELECT
		 *
	FROM tbl_menu
	WHERE category_code not IN(5,8,10); -- 카테고리 코드가 5,8,10이 아닌 나머지 전체.
	
-- ----------------------------------------
-- is null 연산자 활용

-- 1) 상위 카테고리 조회
SELECT
		*
	FROM tbl_category
 WHERE ref_category_code IS NULL;
 
 
 -- 2) 하위 카테고리  조회
 SELECT
		*
	FROM tbl_category
 WHERE ref_category_code IS NOT NULL;