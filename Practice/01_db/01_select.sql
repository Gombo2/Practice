SELECT * FROM tbl_menu;

SELECT
		 menu_name
		,menu_code
	   ,category_code
	FROM tbl_menu;
	
SELECT
	 	 menu_code
		,menu_price
		,orderable_status
	FROM tbl_menu;

SELECT
		 * 
	 FROM tbl_menu;

-- -----------------------------------
SELECT 
		*
	FROM tbl_category;	 

-- -----------------------------------
-- from절 없는  select 해보기
SELECT 7 + 3;
SELECT 10 * 2;
SELECT 6 % 3, 6 % 4;
SELECT NOW(); -- 서버의 현재 시간
SELECT CONCAT('유', ' ' , '관순');	-- 문자열 병합.

-- ------------------------------------------------
-- 별칭(alias)
SELECT 7 + 3 AS 합; -- 7 + 3 결과값을 합이라는 별칭으로 처리.
-- SELECT 2 * 3 AS '곱입니다.'; -- 특수기호(띄어쓰기를 포함한) 사용 사례는 (')싱글 쿼테이션 생략 불가.
										  -- AS는 생략 가능하지만, 가독성을 위해 생략하지 말자.
SELECT menu_name AS 메뉴명 FROM tbl_menu;

	