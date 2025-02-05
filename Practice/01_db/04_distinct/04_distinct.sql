-- distinct   (중복값을 제거)
-- 메뉴가 할당된 카테고리를 조회.

SELECT
		 category_code
	FROM tbl_menu
ORDER BY category_code;

SELECT
		 DISTINCT category_code  -- distinct를 활용해 메뉴가 할당된 카테고리들의 종류를 조회.
	FROM tbl_menu
ORDER BY category_code;  

-- 2개 이상의 colume 묶어서 처리 가능.
-- 다중형 distinct
SELECT -- 10, Y 가 묶여서 중복되어 하나만 나옴.
		  distinct
		  category_code
		, orderable_status
	FROM tbl_menu; 