/* index */
SELECT * FROM tbl_menu;

-- 고유 인덱스: 중복된 값이 없는 컬럼에 달리는 인덱스
-- 비고유 인덱스: 중복된 값이 있는 컬럼의 인덱스

CREATE TABLE phone (
	 phone_code INT PRIMARY KEY,
	 phone_name VARCHAR(100),
	 phone_price DECIMAL(10,2)
);

INSERT
	INTO phone
VALUES
 (1, 'galaxyS24', 1200000),
 (2, 'iphone16pro', 1430000),
 (3, 'galaxyforld7', 1730000); 
 
SELECT * FROM phone;
SHOW INDEX FROM phone;

-- pk 컬럼은 고유 인덱스가 있으므로 pk컬럼을 활용한(where절에) 조회를 하자.
-- 검색속도 향상을 위해
SELECT * FROM phone WHERE phone_code = 1;
EXPLAIN SELECT * FROM phone WHERE phone_code = 1; -- EXPLAIN : idx 탔는지 확인 가능(extra)

-- 다른 컬럼으로 조회 성능 향상을 위해서는 인덱스는 수동으로 달자.
CREATE INDEX idx_name ON phone(phone_name);
SHOW INDEX FROM phone;

-- 인덱스가 달린 컬럼을 조건으로 조회
SELECT * FROM phone WHERE phone_name = 'iphone16pro';
EXPLAIN SELECT * FROM phone WHERE phone_name = 'iphone16pro';

-- 인덱스는 필요한 곳에 달아야 한다.
-- 1) 조건으로 활용할 컬럼(where절, having절, join 시 on에 사용하는 컬럼)
-- 2) '=' 같다는 조건으로 쓰일 컬럼
-- 3) 데이터가 자주 수정되지 않는 컬럼에 달아야 한다. (pk컬럼)
-- 4) 전체 데이터의 10~15% 정도의 범위에 해당하는 조건이 가장 효율이 좋다.(비고유 인덱스에 해당)
-- 5) 카디널리티(중복되지 않는 데이터일수록) 가 높은 컬럼일 수록 좋다.
--     (카디널리티 : 구분되는 행의 갯수)

-- 인덱스 단점
-- 1) 별도의 저장공간 필요
-- 2) 주기적으로 인덱스를 다시 달아줘야 한다. (주기가 정해지진 않았지만 한달에 한번은 권장).
-- (ex : 스프링  스케쥴러 활용 )

OPTIMIZE TABLE phone; -- 인덱스 최적화(다시 인덱스 달기)


-- 인덱스 삭제
DROP INDEX idx_name ON phone;
SHOW INDEX FROM phone;