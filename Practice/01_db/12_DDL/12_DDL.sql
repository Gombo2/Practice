/* DDL(Data Definition Language) */

CREATE TABLE tb1 ( -- 생성 CREATE 테이블 이름 tb1
	 pk INT PRIMARY KEY, --  , 단위로 column 나뉨.(종류 및 크기 & 제약사항 작성)
	 fk INT,
	 col1 VARCHAR(255),
	 check(col1 IN ('Y', 'N'))	-- col1 안에는 y,n만 들어가게 체크 제약조건 생성
);

-- 존재하는 테이블을 요약해서 간략히 보고 싶다면 desc 키워드 사용
DESCRIBE tb1;
DESC tb1;

INSERT
	INTO tb1
VALUES
(
	1, 2, 'Y'
);

/* auto_increment */
/* if not exists */
/* drop */ -- 보통 테이블보다 위에 적음, 테이블 삭제


DROP TABLE tb2;

CREATE TABLE if not exists tb2 (
	pk INT PRIMARY KEY AUTO_INCREMENT,
	fk INT,
	col1 VARCHAR(255),
	CHECK(col1 IN ('Y', 'N'))
);

DESC tb2;

INSERT
	INTO tb2
VALUES
(
	NULL, 2, 'N'
);

SELECT * FROM tb2;
COMMIT;

-- ------------------------------------------------
/* alter */
-- 컬럼 추가
ALTER TABLE tb2 ADD col2 INT NOT NULL;

DESC tb2;

-- 컬럼 삭제
ALTER TABLE tb2 DROP COLUMN col2;
DESC tb2; 

-- 컬럼 이름 및 컬럼 정의 변경
ALTER TABLE tb2 CHANGE COLUMN fk change_fk INT NOT NULL;
DESC tb2;

-- auto_increment 먼저 제거 (dorp 이 아닌 ㅡmodify)
ALTER TABLE tb2 MODIFY pk INT;


-- 다시 primary key 제거
ALTER TABLE tb2 DROP PRIMARY KEY;

DESC tb2;

/* truncate */
-- 절삭(truncate) vs 삭제(delete)
-- 테이블 초창기 상태로 돌아감 vs 데이터 값만 날림.
-- 테이블의 데이터(데이터 및 관련 제약조건 등 깔끔하게 제거)
-- 테이블의 초기화(테이블의 초기 만들 당시로 돌려줌)

CREATE TABLE IF NOT EXISTS tb3 (
	pk INT AUTO_INCREMENT,
	fk INT, 
	col1 VARCHAR(255) CHECK(col1 IN ('Y','N')),
	PRIMARY KEY(PK)
);

INSERT
	INTO tb3
 VALUES
 (
 	NULL, 1, 'N'
);

SELECT * FROM tb3;

TRUNCATE TABLE tb3;    