CREATE TABLE teacher1(
	id INT PRIMARY KEY AUTO_INCREMENT,
	NAME VARCHAR(20),
	age INT
)
CREATE TABLE teacher2(
	id INT PRIMARY KEY AUTO_INCREMENT,
	NAME VARCHAR(20),
	address VARCHAR(100)
)

INSERT INTO teacher1(NAME,age) VALUES('xxx',30),('yyy',32),('zzz',33);

INSERT INTO teacher2(NAME,address) VALUES('xxx','beijing'),('yyy','shanghai'),('zzz','dongguan');
SELECT * FROM teacher1;
SELECT * FROM teacher2;

SELECT id ,NAME FROM teacher1 UNION ALL SELECT id,NAME FROM teacher2;