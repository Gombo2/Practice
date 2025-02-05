SHOW DATABASES;
SELECT * FROM user;

CREATE USER 'swcamp'@'%' IDENTIFIED BY 'swcamp';  -- 일반 개발자 계정 생성. 

SELECT * FROM user; -- swcamp % 권한 생성 확인.

SHOW GRANTS FOR 'swcamp'@'%'; -- swcamp 계정에 할당된 권한 확인.
CREATE DATABASE menudb;


GRANT ALL PRIVILEGES ON menudb.* TO 'swcamp'@'%';

SHOW GRANTS FOR 'swcamp'@'%';

