-- order by(정렬)

-- 오름차순(Ascending, ASC)
-- 내림차순(Descending, DESC)

-- ---------------------------------------

SELECT
		menu_code
		,menu_name
		,menu_price
	FROM tbl_menu
-- ORDER BY menu_price ASC;
-- FROM -> SELECT -> ORDER BY 순으로 진행. (ORDER BY는 항상 제일 마지막 작동)
-- ORDER BY menu_price, menu_name;      --생략가능(생략시 default ASC)
-- ORDER BY menu_price, menu_name DESC; -- 정렬의 우선순위를 가지고 여러 정렬 기준 적용 가능.
ORDER BY 3, 2 DESC;   	                -- select 절의 작성한 컬럼의 순븐을 활용 가능.

SELECT
		 menu_code AS 메뉴코드
		,menu_name AS 메뉴명
		,menu_price AS 메뉴단가
	FROM tbl_menu
 ORDER BY 메뉴코드 DESC; -- 별칭에 특수기호가 있을 시 별칭을 활용한 정렬 x(특수기호 사용 x)
 
 -- ----------------------------------------------------------
--  field 함수를 활용한 정렬이 가능하다.
SELECT FIELD('a', 'b', 'c', 'a'); -- 처음 값이 나머지 몇번째 자리에 있는지 (본인 자리 포함 x)



-- 주문 불가능한 메뉴부터 정렬.
SELECT 
		 orderable_status
		 , FIELD(orderable_status, 'Y' , 'N')
 FROM tbl_menu
ORDER BY FIELD(orderable_status, 'Y', 'N') DESC; -- ORDER BY 2 DESC; 또한 가능 / ORDER BY 기능여부 DESC; 또한 가능.

-- ------------------------------------------------------ 02_order_by 정렬 끝
-- null 값(비어 이쓴ㄴ 정렬 값)에 대한 정렬
SELECT * FROM tbl_category;


-- 1) 오름차순 시 : NULL값이 먼저 나옴
SELECT
		 *
	FROM tbl_category
 ORDER BY ref_category_code ASC;
 
-- 2) 내림차순 시 : NULL 값이 마지막에 나옴
SELECT
		 *
	FROM tbl_category
 ORDER BY ref_category_code DESC;
 
 
 -- 3) 오름차순 시 : - DESC -> null에 대해서만 desc 적용. (나머지는 -에 따라 asc)
SELECT
		 *
	FROM tbl_category
 ORDER BY -ref_category_code DESC;
 
-- 4) 내림차순 시 : - ASC -> null에 대해서만 asc 적용. (나머지 컬럼값은  - 에 따라 desc)
SELECT
		 *
	FROM tbl_category
 ORDER BY -ref_category_code ASC;