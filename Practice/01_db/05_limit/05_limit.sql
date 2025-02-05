-- limit

SELECT
		 menu_code
		, menu_name
		, menu_price
	FROM tbl_menu
 ORDER BY menu_price DESC, menu_code DESC
 LIMIT 4, 3;
 -- LIMIT n, m -> n번째 순서부터 m개만큼 추출 [index 형식이라 0부터 시작]
 
 SELECT
		 *
	FROM tbl_menu
ORDER BY menu_code LIMIT 10; -- 첫번째 행부터 10개 (length의 의미만 가진다.)
 
-- --------------------------------------------------------------
 SELECT
 		 *
 	FROM tbl_menu;