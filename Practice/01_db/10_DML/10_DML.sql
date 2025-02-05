/* DML(Data Manipulation Language) */
-- insert, update, delete, select(DQL)

/* insert */
-- 새로운 행을 추가하는 구문
SELECT 
		 * 
	FROM tbl_menu;
INSERT
 INTO tbl_menu
(
	menu_name
,	menu_price
,	category_code
,	orderable_status
)
VALUES
(
	'초콜릿죽'
,	6500
,	7
,	'Y'
);

DESC tbl_menu;

-- 컬럼명 미작성시에는 실제 테이블의 컬럼 갯수만큼 컬럼 순서를 지켜 작성해야 한다.
-- 하나의 insert 구문으로 여러 데이터를 insert 할 수 있다.
-- Multi insert
INSERT
 INTO tbl_menu
VALUES
(NULL, '참치맛아이스크림', 1700, 12, 'Y'),
(NULL, '멸치맛아이스크림', 1500, 11, 'Y'),
(NULL, '소시지맛커피', 2500, 18, 'Y');

SELECT * FROM tbl_menu ORDER BY 1 DESC;