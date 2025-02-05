
USE mysql;
CREATE USER 'practice'@'%' IDENTIFIED BY 'practice';

SHOW DATABASES;

SELECT * FROM USER;

CREATE DATABASE employeedb;

SHOW DATABASES;

GRANT ALL PRIVILEGES ON employeedb.* TO 'practice'@'%';

SHOW GRANTS FOR 'practice'@'%';

