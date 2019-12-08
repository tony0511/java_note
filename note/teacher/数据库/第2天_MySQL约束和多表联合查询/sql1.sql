# 主键约束(默认不能为null)
#第一种写法
CREATE TABLE student(
	stuNo INT PRIMARY KEY,
	stuName VARCHAR(20),
	address VARCHAR(50)
);
#第二种写法  `反勾号,可以写联合主键
CREATE TABLE student(
	stuNo INT ,
	stuName VARCHAR(20),
	address VARCHAR(50),
	PRIMARY KEY(stuNo)
);
#第三种写法，先创建表，然后再添加主键
CREATE TABLE student2(
	stuNo INT,
	stuName VARCHAR(20),
	address VARCHAR(50)
);
#添加主键
ALTER TABLE student2 ADD PRIMARY KEY(stuNo);


#添加数据
INSERT INTO student(stuNo,stuName,address)
VALUES(111,'zhangsan','北京'),
      (222,'lisi','上海');
      
#查询
SELECT * FROM student;   
DROP TABLE student;   

SHOW CREATE TABLE student;