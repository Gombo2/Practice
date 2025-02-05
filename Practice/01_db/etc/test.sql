-- products 테이블 생성
-- 열 생성 (fruit_code int 정수형 타입 , furit_name VARCAHR : 가변길이 문자열 데이터 타입 (100), 
-- furit_price DECIMAL 고정 소수헝 타입 10자리 중 소수점 2자리까지 표기.)

CREATE TABLE products (
		 fruit_code INT PRIMARY KEY -- 기본키 생성.
		, fruit_name VARCHAR(100)
		, fruit_price DECIMAL(10,2)
 );
 
 -- ---------------------------------------
 -- 각 COULUME (fruit_code, furit_name, furit_price 에 생성된 순서에 맞게 데이터 입력.)
 
INSERT
	 	 INTO products (
		 fruit_code
		, fruit_name
		, fruit_price
 )
 VALUES (1, 'Apple', 2000),
 		  (2, 'Orange', 2500),
 		  (3, 'Banana', 1700);
 		  
-- --------------------------------------------
 		  
 EXPLAIN SELECT * FROM products -- 몰겠어요...
 	WHERE fruit_name = 'Orange';		  
 
 
 SELECT -- Coulmn 값 출력.
 		 fruit_code
 		, fruit_name
 		, fruit_price
 FROM products;