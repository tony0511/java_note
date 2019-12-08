#唯一约束 （可以为空）
CREATE TABLE student3(
	stuNo INT PRIMARY KEY,
	stuName VARCHAR(20),
	address VARCHAR(50),
	identityCard VARCHAR(18) UNIQUE 
);

INSERT INTO student3 VALUES(1,'xxx','beijing','4514124123'),(2,'yyyy','shanghai','4514124124');
INSERT INTO student3 VALUES(3,'xxx','beijing',NULL),(4,'yyyy','shanghai',NULL);
SELECT * FROM student3;
DROP TABLE student3;

#自动增长
CREATE TABLE student4(
	id INT PRIMARY KEY AUTO_INCREMENT,
	NAME VARCHAR(10)
);

ALTER TABLE student4 AUTO_INCREMENT = 10;

INSERT INTO student4(NAME) VALUES('xxx'),('yyy'),('zzz');
SELECT * FROM student4;
DROP TABLE student4;

#创建表
CREATE TABLE student5(
	id INT PRIMARY KEY AUTO_INCREMENT,
	NAME VARCHAR(20),
	entrydate DATETIME
);
INSERT INTO student5(NAME,entrydate) VALUES('张三','2011-1-1');
SELECT * FROM student5;
DROP TABLE student5;

CREATE TABLE student6(
	NAME VARCHAR(21585),
	address VARCHAR(3),
	RESUME TEXT
);
DROP TABLE student6;
#非空约束
CREATE TABLE student7(
	id INT PRIMARY KEY,
	NAME VARCHAR(20) NOT NULL
)
INSERT INTO student7(id,NAME) VALUES(10,'wfefe');
#默认值约束
CREATE TABLE student8(
	id INT PRIMARY KEY,
	NAME VARCHAR(20) NOT NULL,
	sex CHAR(1) DEFAULT '男'
)

INSERT INTO student8(id,NAME) VALUES(20,'zhaoliu');
SELECT * FROM student8;

#外键约束

CREATE TABLE score(
	id INT PRIMARY KEY,
	score INT,
	sid INT,
	CONSTRAINT FOREIGN KEY(sid) REFERENCES student8(id)
)
CREATE TABLE score2(
	id INT PRIMARY KEY,
	score INT,
	sid INT REFERENCES student8(id)
)

INSERT INTO score(id,score,sid) VALUES(1,80,20);
INSERT INTO score(id,score,sid) VALUES(2,80,NULL);

