/* DML(Data Manipulation Language) */
-- insert, update, delete, select(DQL)

/* insert */
-- 새로운 행을 추가하는 구문
SELECT * FROM tbl_menu;
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

/* update */
-- 테이블에 기록된 컬럼값을 수정하는 구문이다.
-- 전체 행 갯수에는 변화가 없다.
SELECT 
		 *
	FROM tbl_menu;

-- 이렇게 할 경우 카테고리 코드 값 전체가 7로 바뀜. (절대 x)
-- UPDATE tbl_menu
-- 	SET category_code = 7;

UPDATE tbl_menu
	SET category_code = 8
 WHERE menu_code = 25;	
 
-- subquery를 활용한 update
UPDATE tbl_menu
	SET category_code = 9,
		 menu_price = 200
 WHERE menu_code = (SELECT menu_code
 							FROM tbl_menu
 							WHERE menu_name = '참치맛아이스크림');
 							
-- ---------------------------------------
/* delete */
-- 테이블의 행을 삭제하는 구문
-- 테이블의 행의 갯수가 줄어든다.
-- mariadb는 기본적으로 autocommit 설정이 'on'으로 되어 있으므로 우리가 수동적으로 하기 위해 autocommit을 꺼주어야한다.
SET autocommit = 0;  

DELETE 
	FROM tbl_menu;
	
SELECT * FROM tbl_menu;
ROLLBACK;

COMMIT; -- 실제 베이스 테이블에 적용 되어 값이  날아감

-- order by 및 limit을 통해 삭제(update, delete) 할 수도 있다.
DELETE
	FROM tbl_menu 
 ORDER BY menu_price -- 메뉴가격 오름차순
 LIMIT 2; -- 정렬된 첫 행부터 2개의 행에 해당

/* replace */
-- primary key를 이용하여 insert및 upadate를 일으킴
-- replace를 하는 테이블의 pk컬럼에 기존에 있는 값을 쓰면 update, 기존
REPLACE tbl_menu  -- REPLACE into tbl_menu   into는 생략 가능 
VALUES 
(17 -- PK 17일 경우 17기존 데이터값 존재하여 update 23일경우 데이터값이 없음으로 새로 insert
, '참기름소주'
, 5000
, 10
, 'Y'
);

SELECT * FROM tbl_menu WHERE menu_code = 17;