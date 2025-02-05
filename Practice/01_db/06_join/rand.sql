DROP TABLE t1;
DROP TABLE t2;

CREATE TABLE t1 (
id int(10) NOT NULL AUTO_INCREMENT ,
c1 int(10) NOT NULL DEFAULT '0',
c2 int(10) NOT NULL DEFAULT '0',
PRIMARY KEY (id),
KEY idx_c1 (c1)
) ENGINE=InnoDB;
ㄴ
CREATE TABLE t2 (
id int(10) NOT NULL AUTO_INCREMENT ,
c1 int(10) NOT NULL DEFAULT '0',
c2 int(10) NOT NULL DEFAULT '0',
PRIMARY KEY (id),
KEY idx_c1 (c1)
) ENGINE=InnoDB;

insert into t1 select null,round(rand()*100),round(rand()*1000) -- rand를 통해 임의의 값을 열로 생상.
from information_schema.columns a1, information_schema.columns b1  
LIMIT 100;

insert INTO t2 select null,round(rand()*100),round(rand()*1000)
from information_schema.columns a1, information_schema.columns b1  
LIMIT 100;

SELECT * FROM t1;
SELECT * FROM t2;