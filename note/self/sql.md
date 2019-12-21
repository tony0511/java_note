



[TOC]

#### 1 数据库简介

##### 1.1 简介

数据库（DataBase，DB）：指长期保存在计算机的存储设备上，按照一定规则组织起来，可以被各种用户或应用共享的数据集合。

数据库管理系统（DataBase Management System，DBMS）：指一种操作和管理数据库的大型软件，用于建立、使用和维护数据库，对数据库进行统一管理和控制，以保证数据库的安全性和完整性。用户通过数据库管理系统访问数据库中的数据。MySQL  SQL Server Oracle 

数据库软件应该为**数据库管理系统**，数据库是通过数据库管理系统创建和操作的。

数据库：存储、维护和管理数据的集合。

##### 1.2 常见数据库管理系统

- Oracle：Oracle 数据库被认为是业界目前比较成功的关系型数据库管理系统。Oracle 数据库可以运行在UNIX、Windows 等主流操作系统平台，完全支持所有的工业标准，并获得最高级别的 ISO 标准安全性认证。
- MySQL：MySQL 是一个关系型数据库管理系统，由瑞典 MySQL AB 公司开发，目前属于 Oracle 旗下产品。MySQL 是最流行的关系型数据库管理系统之一，在 WEB 应用方面，MySQL 是最好的 RDBMS (Relational Database Management System，关系数据库管理系统) 应用软件（分 **收费版(如企业版)** 和 **免费版（如社区版）**）。
- DB2：DB2 是 IBM 公司的产品，DB2 数据库系统采用多进程多线索体系结构，其功能足以满足大中公司的需要，并可灵活地服务于中小型电子商务解决方案。
- Microsoft SQL Server：SQL Server 是 Microsoft 公司推出的关系型数据库管理系统。具有使用方便可伸缩性好与相关软件集成程度高等优点（中国银行在用）。

##### 1.3 MySQL安装和卸载

- Windows 相关命令 msprint 打开画图板，control 打开控制面板，services-msc 打开服务

- Windows 版本注意需要增加 path 环境变量来支持 mysql 命令，

  **C:\Program Files\MySQL\MySQL Server 8.0\bin\\**

- 安装和配置步骤：

![](https://upload-images.jianshu.io/upload_images/5097954-d04e842fa063c013.jpg)

![](https://upload-images.jianshu.io/upload_images/5097954-c147dcfd626d5f23.jpg)

![](https://upload-images.jianshu.io/upload_images/5097954-99a9e9b666f42c42.jpg)

![](https://upload-images.jianshu.io/upload_images/5097954-118ce597631fc05c.jpg)

![](https://upload-images.jianshu.io/upload_images/5097954-36ac86408a66a5c1.jpg)

![](https://upload-images.jianshu.io/upload_images/5097954-0e9bc67d5bc267e0.jpg)

![](https://upload-images.jianshu.io/upload_images/5097954-22c93c4a8ea98bee.jpg)

![](https://upload-images.jianshu.io/upload_images/5097954-6b2735ff91c67ef2.jpg)

![](https://upload-images.jianshu.io/upload_images/5097954-d60f3eca25ddc1cd.jpg)

![](https://upload-images.jianshu.io/upload_images/5097954-ce13250823154735.jpg)

![](https://upload-images.jianshu.io/upload_images/5097954-dac1cacbb7a5efc5.jpg)

![](https://upload-images.jianshu.io/upload_images/5097954-6915cbffb96c6573.jpg)

![](https://upload-images.jianshu.io/upload_images/5097954-b299780ab2eda6b6.jpg)

![](https://upload-images.jianshu.io/upload_images/5097954-c8dc735c7f32378c.jpg)

![](https://upload-images.jianshu.io/upload_images/5097954-e329e505b54b416d.jpg)

![](https://upload-images.jianshu.io/upload_images/5097954-0c506e5341406b24.jpg)

![](https://upload-images.jianshu.io/upload_images/5097954-bbd1a4375b83ea01.jpg)

![](https://upload-images.jianshu.io/upload_images/5097954-4039bc210020fc7c.jpg)

![](https://upload-images.jianshu.io/upload_images/5097954-b4a937a999d27480.jpg)

![](https://upload-images.jianshu.io/upload_images/5097954-3723cc4994a5456a.jpg)

![](https://upload-images.jianshu.io/upload_images/5097954-71cda61a1c384000.jpg)

- 验证是否安装成功，打开cmd输入，如上图所示。

  ```sql
  c:\>mysql -u root -p
  ```

  然后输入密码，正确进入表示安装成功。

- 卸载MySQL

  1.停止服务，使用``c:\>net stop mysql``命令停止服务，``c:\>net start mysql`` 命令启动服务。

  2.在控制面板-->"程序和功能"中，找到“mysql程序”，点击卸载。

  3.删除安装目录,一般默认在C:\Program Files\MySQL。

  4.删除数据库文件存放目录，一般默认在C:\ProgramData\MySQL。

##### 1.4 MySQL5.7.x 版本安装

> 同意协议

![](https://upload-images.jianshu.io/upload_images/5097954-d79700f7000e37b9.png)

> 开发模式

![](https://upload-images.jianshu.io/upload_images/5097954-f6c6c5be3aaf95cf.png)



> 请注意安装需要的依赖环境,如果想安装的功能缺少对应环境是无法安装的,需先安装环境后才可以安装

![](https://upload-images.jianshu.io/upload_images/5097954-d5ce6807924b85b0.png)



> 下一步的时候会提示缺少环境,此处的提示是说你期望安装的产品中缺少依赖,不一定提示的是数据库服务器安装的依赖,可能是其他功能组件的依赖缺少

![](https://upload-images.jianshu.io/upload_images/5097954-b35c663ed4d2f3cc.png)



> 此处发现没有 mysql server, 说明它对应的依赖缺少,可以先执行安装这些可以安装的,之后安装完依赖后再重新安装其他模块,我们此处的操作是先安装依赖,然后后退再次安装

![](https://upload-images.jianshu.io/upload_images/5097954-423a6b7d121855c4.png)



> 下载安装前面提示的 mysql server 需要的 vc2013后,vc2013 如果在64位系统上面建议32和64的程序都安装,然后在上图的地方后退,重新 next 就可以看到可以安装 mysql server 了

![](https://upload-images.jianshu.io/upload_images/5097954-c4cdf62d0476379a.png)



![](https://upload-images.jianshu.io/upload_images/5097954-923179c65a4b19bf.png)

> 进行第一步配置,除了需要设置密码外,后面的步骤基本上都是下一步下一步

![](https://upload-images.jianshu.io/upload_images/5097954-de16ce12de974351.png)



![](https://upload-images.jianshu.io/upload_images/5097954-f747fbbb6eb476f8.png)

> 设置 root 密码

![](https://upload-images.jianshu.io/upload_images/5097954-662fbac3358211fd.png)



![](https://upload-images.jianshu.io/upload_images/5097954-aae6ffcc19e54961.png)



![](https://upload-images.jianshu.io/upload_images/5097954-b724dfcf4b6c8715.png)



![](https://upload-images.jianshu.io/upload_images/5097954-a93f58a33d79cfd3.png)



> finish 后回到当前页面继续配置

![](https://upload-images.jianshu.io/upload_images/5097954-3aaec13bc9210a4e.png)

> 此处先 check, 后下一步

![](https://upload-images.jianshu.io/upload_images/5097954-49ac52a2bc1e0958.png)

> 执行完此步骤 下一步 finish 配置完成

![](https://upload-images.jianshu.io/upload_images/5097954-0af446565ac9ebba.png)



#### 2 SQL语言

##### 2.1 概述

​	 SQL：Structure Query Language（结构化查询语言），SQL被美国国家标准局（ANSI）确定为关系型数据库语言的美国标准，后来被国际化标准组织（ISO）采纳为关系数据库语言的国际标准。

​	各数据库厂商都支持ISO的SQL标准，**普通话**

​	各数据库厂商在标准的基础上做了自己的扩展，**方言**

​         SQL 是一种标准化的语言，它允许你在数据库上执行操作，如创建项目，查询内容，更新内容，并删除条目等操作。

​         Create, Read, Update, and Delete 通常称为 **CRUD** 操作。

##### 2.2 SQL语句分类          

- **DDL**（Data Definition Language）：数据 **定义** 语言，用来定义 **数据库对象**：库、表、列等。
- **DML**（Data Manipulation Language）：数据 **操作** 语言，用来定义数据库记录（操作 **数据**）。
- **DCL**（Data Control Language）：数据 **控制** 语言，用来定义 **访问权限** 和 **安全级别**。
- **DQL**（Data Query Language）：数据 **查询** 语言，用来查询记录（**数据**）。

​        **注：sql语句以 ; 结尾，有一些命令不用 ;**

- MySQL **注释**：（1）# 开头 （2）\-\- 空格开头



##### 2.3 DDL操作数据库

1. 创建 数据库

   ```sql
   SQL> CREATE DATABASE mydb1;
   SQL> CREATE DATABASE mydb2 character SET GBK;
   SQL> CREATE DATABASE mydb3 character SET GBK COLLATE gbk_chinese_ci;
   ```

2. 查看 数据库

   查看当前数据库服务器中的所有数据库

   ```sql
   SQL> SHOW DATABASES;
   ```

   查看前面创建的 mydb2 数据库的定义信息

   ```sql
   SQL> Show CREATE DATABASE mydb2;
   ```

3. 修改 数据库

   查看服务器中的数据库，并把mydb2的字符集修改为utf8;

   ```sql
   SQL> ALTER DATABASE mydb2 character SET utf8;
   ```

4. 删除 数据库

   ```sql
   SQL> DROP DATABASE mydb3;
   ```

5. 其他语句

   查看当前使用的数据库

   ```sql
   SQL> Select database(); -- 没有选择数据 null
   ```

   切换 数据库

   ```sql
   SQL> USE mydb2;
   ```

##### 2.4 DDL操作表

1. 创建 表。

   反勾号对于关键字可用\`\`引起来。如 \`name \`

   语法： 

   ```sql
   CREATE TABLE 表名(
      字段1 字段类型(长度) 约束,
      字段2 字段类型(长度) 约束,
      ...
   字段n 字段类型(长度) 约束
   );
   ```

   示例：

   ```sql
   SQL> CREATE TABLE Employees
   (
      id INT NOT NULL,
      age INT NOT NULL,
      first VARCHAR(255),
      last VARCHAR(255)
   );
   ```

   常用数据类型：

   - **int**：整型
   - **double**：浮点型，例如 double(5,2) 表示最多 5 位，其中必须有 2 位小数，即最大值为 999.99
   - **decimal**：**严格** 的浮点型，例如 double(5,2) 表示最多 5 位，其中必须有 2 位小数，即最大值为 999.99
   - **char**：固定长度字符串类型，char(10)  'aaa       '  占 10 位
   - **varchar**：可变长度字符串类型，varchar(10)  'aaa'  占 3 位
   - **text**：大文本字符串类型，有字符编码，存储比较大的文本数据。
   - **blob**：大字节类型数据，可以存储图片、音频、视频
   - **date**：日期类型，格式为：yyyy-MM-dd
   - **time**：时间类型，格式为：hh:mm:ss
   - **timestamp**：时间戳类型 yyyy-MM-dd hh:mm:ss  会自动赋值
   - **datetime**：日期时间类型 yyyy-MM-dd hh:mm:ss

    常用约束：

   - 主键约束：**primary key** (保证数据唯一性)
   - 唯一约束：**unique [key]**
   - 非空约束：**not null**
   - 默认约束：**default** 
   - 外键约束：**foreign key**
   - 自动增长：**auto_increment**

2. 删除 表

   ```sql
   SQL> DROP TABLE table_name;
   -- 如果存在 table_name 表就删除 table_name 表
   SQL> DROP TABLE IF EXISTS table_name;
   ```

3. 查看 表

   当前数据库中的所有表

   ```sql
   SQL> SHOW TABLES;
   ```

   查看前面创建的 user 表的定义信息

   ```sql
   SQL> Show CREATE TABLE user;
   ```

   查看表的字段信息

   ```sql
   SQL> DESC employee;
   ```

   在上面员工表的基本上增加一个 image 列。

   ```sql
   SQL> ALTER TABLE employee ADD image blob;
   ```

4. 修改 表

   修改 job 列，使其长度为 60。

   ```sql
   SQL> ALTER TABLE employee MODIFY job varchar(60);
   ```

   删除 image 列，一次只能删一列。

   ```sql
   SQL> ALTER TABLE employee DROP image;
   ```

   修改表名改为 user。

   ```sql
   SQL> RENAME TABLE employee TO user;
   ```

   修改表的字符集为 gbk

   ```sql
   SQL> ALTER TABLE user CHARACTER SET gbk;
   ```

   修改列名 name 为 username

   ```sql
   SQL> ALTER TABLE user CHANGE name username varchar(100);
   ```

##### 2.5 DML操作（重要）

DML是对表中的 **数据** 进行增、删、改的操作，不要与DDL混淆了。

主要包括：INSERT 、UPDATE、 DELETE

**小知识：**

> 在mysql中，字符串类型和日期类型都要用单引号括起来。
>
> 空值：null

**1. 插入操作：INSERT**

语法： 

```sql
INSERT INTO 表名（列名1，列名2 ...）VALUES(列值1，列值2…);
```

**注：**

- 列名与列值的类型、个数、顺序要一一对应。
- 参数不要超出列定义的长度。
- 如果插入空值，请使用 null。
- 插入的日期和字符一样，都使用单引号括起来。

练习 ：

```sql
create table emp(
  id int primary key,
  name varchar(100) not null,
  gender varchar(10) not null,
  birthday date,
  salary float(10,2),
  entry_date date,
  resume text
);
```

一次添加一条数据

```sql
INSERT INTO emp(id,name,gender,birthday,salary,entry_date,resume)
VALUES(1,'zhangsan','female','1990-5-10',10000,'2015-5-5-','goodgirl');

INSERT INTO emp(id,name,gender,birthday,salary,entry_date,resume)
VALUES(2,'lisi','male','1995-5-10',10000,'2015-5-5','good boy');
```

一次添加多条数据

```sql
INSERT INTO emp(id,name,gender,birthday,salary,entry_date,resume)
VALUES (4,'你好','male','1995-5-10',10000,'2015-5-5','good boy'),
				(5,'你好','male','1995-5-10',10000,'2015-5-5','good boy'),
				(6,'你好','male','1995-5-10',10000,'2015-5-5','good boy');
```

**小知识**：

查看数据库编码的具体信息(也可用于查看一些数据库的其他变量信息)

```sql
SQL> show variables like ‘character%’;
```

临时更改客户端和服务器结果集的编码 

```sql
Set character_set_client = gbk;
Set character_set_results = gbk;
-- 或者
SET NAMES ‘gbk’; // client  connection results
```

**2. 修改操作：UPDATE**

语法：

```sql
UPDATE 表名 SET 列名1=列值1, 列名2=列值2 ... WHERE 列名=值
```

练习：

将 **所有** 员工薪水修改为5000元。

```sql
UPDATE emp SET salary=5000 
```

将姓名为’zhangsan’的员工薪水修改为3000元。

```sql
UPDATE emp SET salary=3000 WHERE name=’ zhangsan’;
```

将姓名为’lisi'’的员工薪水修改为4000元,性别改为‘female’。

```sql
UPDATE emp SET salary=4000,gender='female' WHERE name='lisi';
```

将wangwu的薪水在原有基础上增加1000元。

```sql   
UPDATE emp SET salary=salary+1000 WHERE name='wangwu';     
```

**3. 删除操作：DELETE**

语法 ： 

```sql
DELETE FROM 表名 [WHERE 列名=值]
```

练习 ：

删除表中名称为’zhangsan’的记录。

```sql
DELETE FROM emp WHERE name=‘zhangsan’;
```

删除表中 **所有** 记录。

```sql
DELETE FROM emp;
```

使用truncate删除表中记录。(**先把表删除，然后再创建空表**)

```sql
TRUNCATE TABLE emp;
```

**DELETE 与 TRUNCATE 的区别：**

- DELETE 删除表中的数据，表结构还在，删除后的数据 **使用日志** 可以找回。
- TRUNCATE 删除是把表直接 DROP 掉，然后再创建一个同样的新表。
- TRUNCATE 删除的数据不能找回，执行速度比 DELETE 快。

#### 3 DQL数据查询(重点)

数据库执行DQL语句不会对数据进行改变，而是让数据库发送结果集给客户端。

查询返回的结果集是一张虚拟表。

**查询关键字：SELECT** 

语法：

```sql
SELECT     selection_list /*要查询的列名称*/
	FROM     table_list /*要查询的表名称*/
	WHERE    condition /*行条件*/
	GROUP BY grouping_columns /*对结果分组*/
	HAVING   condition /*分组后的行条件*/
	ORDER BY sorting_columns /*对结果排序*/
	LIMIT    offset_start, row_count /*结果限定*/
```

**示例操作：**

1. 创建学生表并添加数据

```sql
-- 创建表 stu
CREATE TABLE stu (
	sid	CHAR(6),
	sname		VARCHAR(50),
	age		INT,
	gender	VARCHAR(50)
);
-- 添加数据
INSERT INTO stu VALUES('S_1001', 'liuYi', 35, 'male');
INSERT INTO stu VALUES('S_1002', 'chenEr', 15, 'female');
INSERT INTO stu VALUES('S_1003', 'zhangSan', 95, 'male');
INSERT INTO stu VALUES('S_1004', 'liSi', 65, 'female');
INSERT INTO stu VALUES('S_1005', 'wangWu', 55, 'male');
INSERT INTO stu VALUES('S_1006', 'zhaoLiu', 75, 'female');
INSERT INTO stu VALUES('S_1007', 'sunQi', 25, 'male');
INSERT INTO stu VALUES('S_1008', 'zhouBa', 45, 'female');
INSERT INTO stu VALUES('S_1009', 'wuJiu', 85, 'male');
INSERT INTO stu VALUES('S_1010', 'zhengShi', 5, 'female');
INSERT INTO stu VALUES('S_1011', 'xxx', NULL, NULL);
```

2. 创建雇员表并添加数据

```sql
-- 创建雇员表
CREATE TABLE emp(
	empno		INT,
	ename		VARCHAR(50),
	job		VARCHAR(50),
	mgr		INT,
	hiredate	DATE,
	sal		DECIMAL(7,2),
	comm		decimal(7,2),
	deptno		INT
);
-- 添加数据
INSERT INTO emp values(7369,'SMITH','CLERK',7902,'1980-12-17',800,NULL,20);
INSERT INTO emp values(7499,'ALLEN','SALESMAN',7698,'1981-02-20',1600,300,30);
INSERT INTO emp values(7521,'WARD','SALESMAN',7698,'1981-02-22',1250,500,30);
INSERT INTO emp values(7566,'JONES','MANAGER',7839,'1981-04-02',2975,NULL,20);
INSERT INTO emp values(7654,'MARTIN','SALESMAN',7698,'1981-09-28',1250,1400,30);
INSERT INTO emp values(7698,'BLAKE','MANAGER',7839,'1981-05-01',2850,NULL,30);
INSERT INTO emp values(7782,'CLARK','MANAGER',7839,'1981-06-09',2450,NULL,10);
INSERT INTO emp values(7788,'SCOTT','ANALYST',7566,'1987-04-19',3000,NULL,20);
INSERT INTO emp values(7839,'KING','PRESIDENT',NULL,'1981-11-17',5000,NULL,10);
INSERT INTO emp values(7844,'TURNER','SALESMAN',7698,'1981-09-08',1500,0,30);
INSERT INTO emp values(7876,'ADAMS','CLERK',7788,'1987-05-23',1100,NULL,20);
INSERT INTO emp values(7900,'JAMES','CLERK',7698,'1981-12-03',950,NULL,30);
INSERT INTO emp values(7902,'FORD','ANALYST',7566,'1981-12-03',3000,NULL,20);
INSERT INTO emp values(7934,'MILLER','CLERK',7782,'1982-01-23',1300,NULL,10);
```

3. 创建部门表并添加数据

```sql
-- 创建部门表
CREATE TABLE dept(
	deptno		INT,
	dname		varchar(14),
	loc		varchar(13)
);
-- 添加数据
INSERT INTO dept values(10, '财务部', 'beijing');
INSERT INTO dept values(20, 'java开发部', 'tianjin');
INSERT INTO dept values(30, '测试部', 'shanghai');
INSERT INTO dept values(40, '销售部', 'shenzheng');
```

##### 3.1 简单查询

查询所有列 \* 表示所有列

```sql
SELECT * FROM stu;
```

查询指定列

```sql
SELECT sid, sname, age FROM stu;
```

##### 3.2 条件查询

条件查询就是在查询时给出WHERE子句，在WHERE子句中可以使用如下运算符及关键字：

**比较运算符**

=：等于 或 赋值

!=、<>：不等于

<：小于

<=：小于等于

\>：大于

\>=：大于等于

BETWEEN … AND

**谓词**

IN(set) 

NOT IN(set)

> in 表示是否在某个范围内，作用上等效于多个条件使用 or 连接。

ANY **（需要个嵌套查询一起使用）**

> 表示范围内的任意一个。

ALL **（需要个嵌套查询一起使用）**

>  表示范围内的所有。

EXISTS  **（需要个嵌套查询一起使用）**

> 表示子查询是否返回结果，只要有结果就为 true，否则为 false，而不管返回的结果具体是啥内容。
>
> **注：使用 exists 时，对外表的数据逐条查询，遍历每条数据时，都会查看 exists 后跟着的语句是否能够返回记录，只要能返回，条件就为真，当前查询的外表的这条记录就会返回，反之，当前查询的外表记录被丢弃。**

**注：一般这些谓词可以使用别的方式替代，比如 > ALL(...) 可以用 > max(…) 替代。**

IS NULL 

**关系运算符**

AND，OR，NOT

**算术运算符:**

\+  \-  *  /  %

```sql
SELECT 3+2;
SELECT 3-2;
SELECT 3*2;
SELECT 3/2;
SELECT 3%2;
```

1. 查询性别为女，并且年龄小于 50 的记录

   注：比较的值不区分大小写，即 female 与 Female 的查询结果是一样的，可以使用 binary 关键字来区分大小写。

```sql
SELECT * FROM stu WHERE gender='Female' AND age<50;
-- 区分大小写
SELECT * FROM stu WHERE binary gender='Female' AND age<50;
```

2. 查询学号为 S_1001，或者姓名为 liSi 的记录

```sql
SELECT * FROM stu WHERE sid ='S_1001' OR sname='liSi';
```

3. 查询学号为 S_1001，S_1002，S_1003 的记录

```sql
-- IN 查询效率一般比较差
SELECT * FROM stu WHERE sid IN ('S_1001','S_1002','S_1003');
-- 等同于
SELECT * FROM stu WHERE sid='S_1001' or sid='S_1002' or sid='S_1003';
```

4. 查询学号不是S_1001，S_1002，S_1003的记录

```sql
SELECT * FROM tab_student 
WHERE sid NOT IN ('S1001','S1002','S_1003');
```

5. 查询年龄为 null 的记录

```sql
SELECT * FROM stu WHERE age IS NULL;
```

6. 查询年龄在 20 到 40 之间的学生记录

```sql
SELECT * FROM stu WHERE age>=20 AND age<=40;
-- 或者
SELECT * FROM stu WHERE age BETWEEN 20 AND 40;
```

7. 查询性别非男的学生记录

```sql
SELECT * FROM stu WHERE gender!='male';
-- 或者
SELECT * FROM stu WHERE gender<>'male';
-- 或者
SELECT * FROM stu WHERE NOT gender='male';
```

8. 查询姓名不为 null 的学生记录

```sql
SELECT * FROM stu WHERE NOT sname IS NULL;
-- 或者
SELECT * FROM stu WHERE sname IS NOT NULL;
```

9. ANY、ALL 和  EXISTS 查询

```sql
SELECT * FROM emp WHERE deptno > ANY (SELECT deptno FROM emp2 WHERE deptno>3);
SELECT * FROM emp WHERE deptno > ALL (SELECT deptno FROM emp2 where deptno<6);
SELECT * FROM emp WHERE EXISTS (SELECT deptno FROM emp2 where deptno>9);
```

##### 3.3 模糊查询

当想查询姓名中包含a字母的学生时就需要使用模糊查询了。模糊查询需要使用关键字LIKE。

通配符: 

_ ：任意一个字符

%：任意0~n个字符

1. 查询姓名由3个字符构成的学生记录

```sql
SELECT * FROM stu WHERE sname LIKE '___';
```

模糊查询必须使用 LIKE 关键字。其中 “\_”匹配任意一个字母，5个“\_”表示5个任意字母。

2. 查询姓名由5个字符构成，并且第5个字符为“i”的学生记录

```sql
SELECT *  FROM stu WHERE sname LIKE '____i';
```

3. 查询姓名以“z”开头的学生记录

```sql
SELECT * FROM stu WHERE sname LIKE 'z%';
```

其中“%”匹配0~n个任何字符。

4. 查询姓名中第2个字符为“i”的学生记录

```sql
SELECT * FROM stu WHERE sname LIKE '_i%'; 
```

5. 查询姓名中包含“a”字符的学生记录

```sql
SELECT * FROM stu WHERE sname LIKE '%a%';
```

##### 3.4 字段控制查询

1. **去除重复记录**

去除重复记录（两行或两行以上记录中系列的上的数据都相同），例如 emp 表中 sal 字段就存在相同的记录。当只查询 emp 表的 sal 字段时，那么会出现重复记录，那么想去除重复记录，需要使用 **DISTINCT**：

```sql
-- 表示 sal 相同的会去重
SELECT DISTINCT sal FROM emp;
-- 表示 sal，com 都相同的会去重
SELECT DISTINCT sal, com FROM emp;
```

2. 查看雇员的月薪与佣金之和

因为 sal 和 comm 两列的类型都是数值类型，所以可以做加运算。如果 sal 或 comm 中有一个字段不是数值类型，那么会出错，字符串相加使用 **concat()**。

```sql
-- 数值之和用运算符 + 相加(注：数值 + null = null，数值 + 字符串 = 0) 
SELECT *,sal+comm FROM emp;
-- 字符串的使用 concat(ename, '____', job) 来拼接
select *,concat(ename,'______',job) from emp;
```

comm 列有很多记录的值为 NULL，因为任何东西与 NULL 相加结果还是 NULL，所以结算结果可能会出现NULL。下面使用了把 NULL 转换成数值 0 的函数 **IFNULL**：

```sql
-- 如果为 null 时则用 0 进行相加
SELECT *,sal+IFNULL(comm,0) FROMemp;
```

3. 使用 **AS** 给列名添加 **别名**

在上面查询中出现列名为 sal+IFNULL(comm,0)，这很不美观，现在我们给这一列给出一个别名，为 total：

```sql
SELECT *, sal+IFNULL(comm,0) AS total FROM emp;
-- 其中 AS 关键字可以省略
SELECT *,sal+IFNULL(comm,0) total FROM emp;
```

##### 3.5 排序 (ORDER BY)

1. 查询所有学生记录，按年龄升序排序

```sql
-- ASC：升序，DESC：降序
SELECT * FROM stu ORDER BY age ASC;
```

或者

```sql
SELECT * FROM stu ORDER BY age;
```

2. 查询所有学生记录，按年龄降序排序

```sql
SELECT * FROM stu ORDER BY age DESC;
```

3. 查询所有雇员，按月薪降序排序，如果月薪相同时，按编号升序排序

```sql
SELECT * FROM emp ORDER BY sal DESC,empno ASC; 
```

##### 3.6 聚合函数  

聚合函数是用来做纵向运算的函数：

**COUNT()**：统计指定列 **不为 NULL**  的记录行数；

**MAX()**：计算指定列的最大值，如果指定列是字符串类型，那么使用字符串排序运算；

**MIN()**：计算指定列的最小值，如果指定列是字符串类型，那么使用字符串排序运算；

**SUM()**：计算指定列的数值和，如果指定列类型不是数值类型，那么计算结果为0；

**AVG()**：计算指定列的平均值，如果指定列类型不是数值类型，那么计算结果为0；

1. **COUNT**

当需要纵向统计时可以使用 COUNT()。

查询 emp 表中记录数：

```sql
SELECT COUNT(*) AS cnt FROM emp;
```

查询 emp 表中有佣金的人数：

```sql
SELECT COUNT(comm) cnt FROM emp;
```

注意，因为 count() 函数中给出的是 comm 列，那么只统计 comm 列非 NULL 的行数。

查询 emp 表中月薪大于 2500 的人数：

```sql
SELECT COUNT(*) FROM emp WHERE sal > 2500;
```

统计月薪与佣金之和大于 2500 元的人数：

```sql
SELECT COUNT(*) AS cnt FROM emp WHERE sal+IFNULL(comm,0) > 2500;
```

查询有佣金的人数，以及有领导的人数：

```sql
SELECT COUNT(comm), COUNT(mgr) FROM emp;
```

2. **SUM 和 AVG**

当需要纵向求和时使用 sum() 函数。

查询所有雇员月薪和：

```sql
SELECT SUM(sal) FROM emp;
```

查询所有雇员月薪和，以及所有雇员佣金和：

```sql
SELECT SUM(sal), SUM(comm) FROMemp;
```

查询所有雇员月薪+佣金和：

```sql
SELECT SUM(sal+IFNULL(comm,0))FROM emp;
```

统计所有员工平均工资：

```sql
SELECT AVG(sal) FROM emp;
```

3. **MAX 和 MIN**

查询最高工资和最低工资：

```sql
SELECT MAX(sal), MIN(sal) FROM emp;
```

##### 3.7 分组查询

当需要分组查询时需要使用 GROUP BY 子句，例如查询每个部门的工资和，这说明要使用部分来分组。

注：凡和聚合函数同时出现的列名，则一定要写在 group by 之后

###### 3.7.1 分组查询

查询每个部门的部门编号和每个部门的工资和：

```sql
SELECT deptno, SUM(sal) FROM emp GROUP BY deptno;
```

查询每个部门的部门编号以及每个部门的人数：

```sql
SELECT deptno,COUNT(*) FROM emp GROUP BY deptno;
```

查询每个部门的部门编号以及每个部门工资大于 1500 的人数：

```sql
SELECT deptno,COUNT(*) FROM emp WHERE sal>1500 GROUP BY deptno;
```

###### 3.7.2 HAVING子句

查询工资总和大于 9000 的部门编号以及工资和：

```sql
SELECT deptno, SUM(sal) FROM emp GROUP BY deptno HAVING SUM(sal) > 9000;
```

**注：having 与 where 的区别:**

- having 是在分组后对数据进行过滤，where 是在分组前对数据进行过滤             
- having 后面可以使用分组函数(统计函数)，而 where 后面不可以使用分组函数。
- where 是对分组前记录的条件，如果某行记录没有满足 where 子句的条件，那么这行记录不会参加分组，而having 是对分组后数据的约束。

##### 3.8 LIMIT 限制

###### 3.8.1 分页查询

LIMIT 用来限定查询结果的起始行，以及总行数。

1. 起始行从 1 行开始，查询 5 行记录

```sql
SELECT * FROM emp LIMIT 0, 5;
```

注意，起始行从 0 开始，即第一行开始

2. 起始行从 4 行开始，查询 10 行记录

```sql
SELECT * FROM emp LIMIT 3, 10;
```

**注：limit 一般用于分页查询**

###### 3.8.2 查询语句书写与执行顺序

- 查询语句 **书写** 顺序：**select – from - where - group by - having - order by - limit**
- 查询语句 **执行** 顺序：**from - where - group by - having - select - order by - limit**

##### 3.9 客户端工具的使用

比如：**SQLyog** 和 **Navicat** 

1. Navicat 安装
   - Windows 版本
   - Mac 版本
2. Navicat 链接报 2059 - Authentication plugin 'caching_sha2_password' cannot be loaded: … 错误时，可以通过使用 mysql 自带命令行登录并修改加密方式。

```sql
-- 登录
mysql -u root -p
-- 输入密码
password:******
-- 切换到 mysql 数据库
use mysql;
-- 查看当前的加密方式(在 user 表中)
select user,host,plugin,authentication_string from user;
-- 修改加密规则和更新密码
alter user 'root'@'localhost' identified with mysql_native_password by '123456';
-- 再次查看加密方式可以看到加密方式更新了，然后再使用 Navicat 连接即可
```

3. Navicat 快捷键
   - **Ctrl + N**：打开一个新的查询窗口
   - **Ctrl + W**：关闭一个查询窗口
   - **Ctrl + Shift + R**：只运行选中的 sql 语句
   - **Ctrl + R**：运行查询窗口的 sql 语句
   - **Ctrl + /**：注释sql语句
   - **Ctrl + Shift + /**：解除注释
   - **Ctrl + L**：删除一行
   - **Ctrl + D**：表的数据显示页面切换到表的结构设计页面，但是在查询页面写 sql 时是复制当前行
   - **F6**：打开一个 mysql 命令行窗口
   - **Ctrl + Q**：打开查询窗口

#### 4 数据的完整性

**作用**：保证用户输入的数据保存到数据库中是正确的，确保数据的完整性 = 在创建表时给表中添加约束

完整性的分类：

- 实体完整性:
- 域完整性:
- 引用完整性:  学生表(学号 ,姓名)   成绩表( 学号,科目,成绩)

##### 4.1 实体完整性

实体：即表中的一行(一条记录)代表一个实体（entity）

实体完整性的作用：标识每一行数据不重复。

约束类型：

- **主键约束（primary key）** 
- **唯一约束(unique)**  
- **自动增长列(auto_increment)**

###### 4.1.1 主键约束（primary key）

​	注：每个表中要有一个主键。

​	特点：1. 数据唯一，且不能为 null。

​				2. 主键相当于：**非空 + 唯一**。

示例：

- 第一种添加方式：

```sql
-- 方式一
CREATE TABLE student(
  id int primary key,
  name varchar(50)
);
-- 方式二 这种方式可以创建联合主键
CREATE TABLE student (
  classid int,
  stuid int,
  name varchar(50),
  primary key(classid，stuid)
);
-- 方式三 这种方式可以创建联合主键
CREATE TABLE student(
  id int,
  name varchar(50)
);
ALTER TABLE student ADD PRIMARY KEY (id);
```

###### 4.1.2 唯一约束(unique)      

特点：1. 数据不能重复，可以为 null。

​		   2. 字段设置为 unique，会自动建立唯一性索引。

```sql
-- 方式一
CREATE TABLE student(
  Id int primary key,
  Name varchar(50) unique
);
-- 方式二
CREATE TABLE student2 (
  classid int(11) NOT NULL,
  stuid int(11) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (classid,stuid),
  UNIQUE KEY `name` (`name`)
);
-- 方式三
CREATE TABLE `student3` (
  `classid` int(11) NOT NULL,
  `stuid` int(11) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`classid`,`stuid`)
);
ALTER TABLE student3 ADD UNIQUE (`name`);
```

###### 4.1.3 自动增长列(AUTO_INCREMENT)  

 sqlserver数据库 (identity)  oracle数据库( sequence)

给主键添加自动增长的数值，列只能是整数类型

**注：自增属性不单独设置，需要配合主键或唯一索引使用**

```sql
-- 默认开始值是 1，每条新记录递增 1
CREATE TABLE student(
  Id int primary key AUTO_INCREMENT,
  Name varchar(50)
);
-- 默认开始值是 100，每条新记录递增 1
CREATE TABLE student(
  Id int primary key AUTO_INCREMENT,
  Name varchar(50)
) AUTO_INCREMENT=100;
-- 设起始值为 100
ALTER TABLE student AUTO_INCREMENT=100;
INSERT INTO student(name) values('tom'),('lily');
```

###### 4.1.4 索引

- 索引是一种快速查询表中内容的机制，使用索引可以提高查询效率，相当于字典的目录可以将查询过程中经常使用的条件设为索引。
- 创建索引是一个优化问题，同样也是一个策略问题。

**4.1.4.1 索引使用场景**

- 表经常进行 SELECT 操作。
- 表数据量很大，记录内容分布范围很广。
- 列名经常在 WHERE 子句或连接条件中出现。

**4.1.4.2 mysql 中索引的类型**

- **普通索引**

  这是最基本的索引类型，而且它没有唯一性之类的限制。普通索引可以通过以下几种方式创建：

  - 创建索引，例如 CREATE INDEX <索引的名字> ON tablename (列的列表)。
  - 修改表，例如 ALTER TABLE tablename ADD INDEX [索引的名字] (列的列表)。
  - 创建表的时候指定索引，例如 CREATE TABLE tablename ( [...], INDEX [索引的名字] (列的列表) )。

- **唯一索引**

  唯一索引和普通索引基本相同，但有一个区别：索引列的所有值都只能出现一次，即必须唯一。唯一索引可以用以下几种方式创建：

  - 创建索引，例如 CREATE UNIQUE INDEX <索引的名字> ON tablename (列的列表)。
  - 修改表，例如 ALTER TABLE tablename ADD UNIQUE [索引的名字] (列的列表)。
  - 创建表的时候指定索引，例如 CREATE TABLE tablename ( [...], UNIQUE [索引的名字] (列的列表) )。

- **主键索引**

  **主键索引 是一种 唯一索引**，也可称为聚集索引，但它必须指定为 “PRIMARY KEY”。主键一般在创建表的时候指定，例如“CREATE TABLE tablename ( [...], PRIMARY KEY (列的列表) ); ”。但是，我们也可以通过修改表的方式加入主键，例如“ALTER TABLE tablename ADD PRIMARY KEY (列的列表); ”

- **全文索引 (很少用)**

  全文索引(全文检索)能够利用分词技术等多种算法，按照一定的算法规则智能地筛选出我们想要的搜索结果。MySQL 从 3.23.23 版开始支持全文索引和全文检索。在 MySQL 中，全文索引的索引类型为 FULLTEXT。全文索引可以在 VARCHAR 或者 TEXT 类型的列上创建。它可以通过 CREATE TABLE 命令创建，也可以通过 ALTER TABLE 或 CREATE INDEX 命令创建。对于大规模的数据集，通过 ALTER TABLE（或者 CREATE INDEX）命令创建全文索引要比把记录插入带有全文索引的空表。

  *注：MySQL 自带的全文索引只能用于数据库引擎为 MyISAM 的数据表，如果是其他数据引擎，则全文索引不会生效。*

**4.1.4.3 索引的缺点**

- 索引要占用磁盘空间。通常情况下，这个问题不是很突出，但是，如果你创建每一种可能列组合的索引，索引文件体积的增长速度将远远超过数据文件。如果你有一个很大的表，索引文件的大小可能达到操作系统允许的最大文件限制。

- 对于需要写入数据的操作，比如 DELETE、UPDATE 以及 INSERT 操作，索引会降低它们的速度，这是因为 MySQL 不仅要把改动数据写入数据文件，而且它还要把这些改动写入索引文件。

##### 4.2 域完整性

域完整性的作用：限制此单元格的数据正确，不对照此列的其它单元格比较

域代表当前单元格

域完整性约束：

- 数据类型
- 非空约束（not null）
- 默认值约束(default)  
- check约束（**mysql 不支持**）check(sex='男'or  sex='女')

###### 4.2.1 数据类型

**数值类型**

| 类型               | 大小                                     | 范围（有符号）                                               | 范围（无符号）                                               | 用途           |
| ------------------ | ---------------------------------------- | ------------------------------------------------------------ | ------------------------------------------------------------ | -------------- |
| TINYINT            | 1 字节                                   | (-128，127)                                                  | (0，255)                                                     | 小整数值       |
| SMALLINT           | 2 字节                                   | (-32 768，32 767)                                            | (0，65 535)                                                  | 大整数值       |
| MEDIUMINT          | 3 字节                                   | (-8 388 608，8 388 607)                                      | (0，16 777 215)                                              | 大整数值       |
| **INT 或 INTEGER** | 4 字节                                   | (-2 147 483 648，2 147 483 647)                              | (0，4 294 967 295)                                           | 大整数值       |
| BIGINT             | 8 字节                                   | (-9 233 372 036 854 775 808，9 223 372 036 854 775 807)      | (0，18 446 744 073 709 551 615)                              | 极大整数值     |
| FLOAT              | 4 字节                                   | (-3.402 823 466 E+38，-1.175 494 351 E-38)，0，(1.175 494 351 E-38，3.402 823 466 351 E+38) | 0，(1.175 494 351 E-38，3.402 823 466 E+38)                  | 单精度浮点数值 |
| DOUBLE             | 8 字节                                   | (-1.797 693 134 862 315 7 E+308，-2.225 073 858 507 201 4 E-308)，0，(2.225 073 858 507 201 4 E-308，1.797 693 134 862 315 7 E+308) | 0，(2.225 073 858 507 201 4 E-308，1.797 693 134 862 315 7 E+308) | 双精度浮点数值 |
| **DOUBLE(M,D)**    | 8个字节，M表示长度，D表示小数位数        | 同上，受M和D的约束   DUBLE(5,2) -999.99-999.99               | 同上，受M和D的约束                                           | 双精度浮点数值 |
| **DECIMAL(M,D)**   | 对DECIMAL(M,D) ，如果M>D，为M+2否则为D+2 | 依赖于M和D的值，M最大值为65                                  | 依赖于M和D的值，M最大值为65                                  | 小数值         |

**日期类型**

表示时间值的日期和时间类型为 DATETIME、DATE、TIMESTAMP、TIME 和 YEAR。

每个时间类型有一个有效值范围和一个"零"值，当指定不合法的MySQL不能表示的值时使用"零"值。

TIMESTAMP类型有专有的自动更新特性

| 类型         | 大小(字节) | 范围                                                         | 格式                | 用途                     |
| ------------ | ---------- | ------------------------------------------------------------ | ------------------- | ------------------------ |
| **DATE**     | 3          | 1000-01-01/9999-12-31                                        | YYYY-MM-DD          | 日期值                   |
| TIME         | 3          | '-838:59:59'/'838:59:59'                                     | HH:MM:SS            | 时间值或持续时间         |
| YEAR         | 1          | 1901/2155                                                    | YYYY                | 年份值                   |
| **DATETIME** | 8          | 1000-01-01 00:00:00/9999-12-31 23:59:59                      | YYYY-MM-DD HH:MM:SS | 混合日期和时间值         |
| TIMESTAMP    | 4          | 1970-01-01 00:00:00/2038 结束时间是第 **2147483647** 秒，北京时间 **2038-1-19 11:14:07**，格林尼治时间 2038年1月19日 凌晨 03:14:07 **(可以不赋值，默认会使用当前时间)** | YYYYMMDD HHMMSS     | 混合日期和时间值，时间戳 |

**字符串类型**

字符串类型指 CHAR、VARCHAR、BINARY、VARBINARY、BLOB、TEXT、ENUM 和 SET

**注：varchar + char 的字节数不能超过 65535，其中包含每个 varchar 要占用 1 个字节保存长度**

| 类型                            | 大小                | 用途                              |
| ------------------------------- | ------------------- | --------------------------------- |
| **CHAR**                        | 0-255字符           | 定长字符串  char(10) 10个字符     |
| **VARCHAR**                     | 0-65535 字节        | 变长字符串  varchar(10)  10个字符 |
| TINYBLOB                        | 0-255字节           | 不超过 255 个字符的二进制字符串   |
| TINYTEXT                        | 0-255字节           | 短文本字符串                      |
| **BLOB**（binary large object） | 0-65 535字节        | 二进制形式的长文本数据            |
| **TEXT**                        | 0-65 535字节        | 长文本数据                        |
| MEDIUMBLOB                      | 0-16 777 215字节    | 二进制形式的中等长度文本数据      |
| MEDIUMTEXT                      | 0-16 777 215字节    | 中等长度文本数据                  |
| LONGBLOB                        | 0-4 294 967 295字节 | 二进制形式的极大文本数据          |
| LONGTEXT                        | 0-4 294 967 295字节 | 极大文本数据                      |

- CHAR 和 VARCHAR 类型类似，但它们保存和检索的方式不同。它们的最大长度和是否尾部空格被保留等方面也不同。在存储或检索过程中不进行大小写转换。

- BINARY 和 VARBINARY 类似于 CHAR 和 VARCHAR，不同的是它们包含二进制字符串而不要非二进制字符串。也就是说，它们包含字节字符串而不是字符字符串。这说明它们没有字符集，并且排序和比较基于列值字节的数值值。

- **Oracle：varchar 和 varchar2 的区别**
  - varchar2 把所有字符都占两字节处理(一般情况下)，varchar 只对汉字和全角等字符占两字节，数字，英文字符等都是一个字节。
  - varchar2 把空串等同于 null 处理，而 varchar 仍按照空串处理。
  - varchar2 字符要用几个字节存储，要看数据库使用的字符集。

- BLOB 是一个二进制大对象，可以容纳可变数量的数据。有 4 种 BLOB 类型：TINYBLOB、BLOB、MEDIUMBLOB 和 LONGBLOB。它们只是可容纳值的最大长度不同。

- 有 4 种 TEXT 类型：TINYTEXT、TEXT、MEDIUMTEXT 和 LONGTEXT。这些对应 4 种 BLOB 类型，有相同的最大长度和存储需求。

###### 4.2.2 非空约束

**not null**

```sql
CREATE TABLE student(
  Id int pirmary key,
  Name varchar(50) not null,
  Sex varchar(10)
);
INSERT INTO student values(1,’tom’,null);
```

###### 4.2.3 默认值约束 

**default**

```sql
CREATE TABLE student(
  Id int pirmary key,
  Name varchar(50) not null,
  Sex varchar(10) default '男'
);
insert intostudent1 values(1,'tom','女');
insert intostudent1 values(2,'jerry',default);
```

##### 4.3 引用完整性

**注：外键列的数据类型一定要与主键的类型一致**

```
外键约束：FOREIGN KEY
```

示例：

```sql
-- 学生表
CREATE TABLE student(
sid int pirmary key,
name varchar(50) not null,
sex varchar(10) default '男'
);
```

```sql
-- 成绩表，方式一
create table score(
  id int,
  score int,
  sid int , 
  CONSTRAINT fk_score_sid foreign key(sid) references student(id)
);
-- 方式二
create table score(
  id int,
  score int,
  sid int references student(id)
);
-- 方式三
ALTER TABLE score1 ADD CONSTRAINT fk_stu_score FOREIGN KEY(sid) REFERENCES student(id);
```

#### 5 多表查询

多表约束：外键约束。

##### 5.1 多表的关系

###### 5.1.1 一对多关系

客户和订单，分类和商品，部门和员工.

一对多建表原则：在多的一方创建一个字段，字段作为外键指向一的一方的主键.

###### 5.1.2 多对多关系

学生和课程:

多对多关系建表原则：需要创建第三张表,中间表中至少两个字段，这两个字段分别作为外键指向各自一方的主键.

###### 5.1.3 一对一关系

在实际的开发中应用不多.因为一对一可以创建成一张表.

两种建表原则：

唯一外键对应：假设一对一是一个一对多的关系，在多的一方创建一个外键指向一的一方的主键，将外键设置为unique 和非空.

主键对应：让一对一的双方的主键进行建立关系.

##### 5.2 多表查询

多表查询有如下几种：

1. **合并结果集**：UNION 、 UNION ALL

2. **连接查询**

   2.1**内连接**：[INNER] JOIN  ON 

   2.2**外连接**：OUTER JOIN ON

   - **左外连接**：LEFT [OUTER] JOIN
   - **右外连接**：RIGHT [OUTER] JOIN
   - **全外连接**：**（MySQL不支持）**FULL JOIN

3. **子查询**

###### 5.2.1 合并结果集

作用：合并结果集就是把两个 select 语句的查询结果合并到一起！

合并结果集有两种方式：

**UNION**：去除重复记录

```sql
SELECT * FROM t1 UNION SELECT * FROM t2；
```

**UNION ALL**：不去除重复记录

```sql
SELECT * FROM t1 UNION ALL SELECT * FROM t2。
```

![030](https://upload-images.jianshu.io/upload_images/5097954-bc2ee861cfabf1a8.jpg)

![031](https://upload-images.jianshu.io/upload_images/5097954-a93b1866d720e70b.jpg)



**注：被合并的两个结果：列数、列类型必须相同**

###### 5.2.2 连接查询(关联查询)

连接查询就是求出多个表的乘积，例如 t1 连接 t2，那么查询出的结果就是 t1 * t2

**注：下面的连接语句也是 内连接，但它不是 SQL 标准中的查询方式，可以理解为方言！**

**注：一般来说关联查询效率优于嵌套查询。**

![032](https://upload-images.jianshu.io/upload_images/5097954-aaa89842bfc7f0cf.jpg)

连接查询会产生笛卡尔积，假设集合A={a,b}，集合B={0,1,2}，则两个集合的笛卡尔积为{(a,0),(a,1),(a,2),(b,0),(b,1),(b,2)}，可以扩展到多个集合的情况。

那么多表查询产生这样的结果并不是我们想要的，那么怎么去除重复的，不想要的记录呢，当然是通过条件过滤。通常要查询的多个表之间都存在关联关系，那么就通过关联关系去除笛卡尔积。

示例 1：现有两张表

emp 表

```sql
CREATE TABLE emp(
	empno		INT,
	ename		VARCHAR(50),
	job		VARCHAR(50),
	mgr		INT,
	hiredate	DATE,
	sal		DECIMAL(7,2),
	comm		decimal(7,2),
	deptno		INT
);
-- 添加数据SQL语句省略
```

dept 表

```sql
CREATE TABLE dept(
	deptno		INT,
	dname		varchar(14),
	loc		varchar(13)
);
-- 添加数据SQL语句省略
```

执行如下SQL语句

```sql
select * from emp,dept;
```

![033](https://upload-images.jianshu.io/upload_images/5097954-d51959102184e4c1.jpg)

**使用主外键关系做为条件来去除无用信息**

```sql
SELECT * FROM emp,dept WHERE emp.deptno=dept.deptno;
```

![034](https://upload-images.jianshu.io/upload_images/5097954-a07fc86c86bd8e3c.jpg)

上面查询结果会把两张表的所有列都查询出来，也许你不需要那么多列，这时就可以指定要查询的列了。

```sql
SELECT emp.ename,emp.sal,emp.comm,dept.dname FROM emp,dept WHERE emp.deptno=dept.deptno;
```

![035](https://upload-images.jianshu.io/upload_images/5097954-e1e2654b312df05a.jpg)

**一：内连接**

SQL 标准的内连接为：

```sql
SELECT * FROM emp e INNER JOIN dept d ON e.deptno=d.deptno;
-- INNER 关键字可以省略
SELECT * FROM emp e JOIN dept d ON e.deptno=d.deptno;
-- ON 可以用 WHERE 关键字代替
SELECT * FROM emp e JOIN dept d WHERE e.deptno=d.deptno;
```

内连接的特点：查询结果必须满足条件。

**二：外连接**

包括左外连接和右外连接，外连接的特点：查询出的结果存在不满足条件的可能。

**a.左外连接**

```sql
SELECT * FROM emp e LEFT OUTER JOIN dept d ON e.deptno=d.deptno;
-- OUTER 关键字可以省略
SELECT * FROM emp e LEFT JOIN dept d ON e.deptno=d.deptno;
```

左连接是先查询出左表（即以左表为主），然后查询右表，右表中满足条件的显示出来，不满足条件的显示NULL。

我们还是用上面的例子来说明。其中 emp 表中“张三”这条记录中，部门编号为 50，而 dept 表中不存在部门编号为 50 的记录，所以“张三”这条记录，不能满足 e.deptno=d.deptno 这条件。但在左连接中，因为 emp 表是左表，所以左表中的记录都会查询出来，即“张三”这条记录也会查出，但相应的右表部分显示 NULL。

![036](https://upload-images.jianshu.io/upload_images/5097954-eca26f475534cd24.jpg)

**b.右外连接**

右连接就是先把右表中所有记录都查询出来，然后左表满足条件的显示，不满足显示 NULL。例如在 dept 表中的40 部门并不存在员工，但在右连接中，如果 dept 表为右表，那么还是会查出 40 部门，但相应的员工信息为NULL。

```sql
SELECT * FROM emp e RIGHT OUTER JOIN dept d ON e.deptno=d.deptno;
-- OUTER 关键字可以省略
SELECT * FROM emp e RIGHT JOIN dept d ON e.deptno=d.deptno;
```

![037](https://upload-images.jianshu.io/upload_images/5097954-798be329cc615e23.jpg)

**连接查询心得**：

连接不限与两张表，连接查询也可以是三张、四张，甚至N张表的连接查询。通常连接查询不可能需要整个笛卡尔积，而只是需要其中一部分，那么这时就需要使用条件来去除不需要的记录。这个条件大多数情况下都是使用主外键关系去除。

两张表的连接查询一定有一个主外键关系，三张表的连接查询就一定有两个主外键关系，所以在大家不是很熟悉连接查询时，首先要学会去除无用笛卡尔积，那么就是用主外键关系作为条件来处理。如果两张表的查询，那么至少有一个主外键条件，三张表连接至少有两个主外键条件。

**三：全连接**

注：**mysql 不支持全连接** 

```sql
SELECT * FROM emp e FULL JOIN dept d ON e.deptno=d.deptno;
```

###### 5.2.3 子查询、嵌套查询

**子查询**

- 子查询是指一个 SELECT 语句中包含另一个完整的 SELECT 语句。如果一条语句中存在两个或两个以上的 SELECT，那么里面的查询叫做 **子查询**，外层的查询叫 **父查询**，一般情况都是先执行子查询，再执行父查询。

**嵌套查询**

-  **嵌套查询属于子查询**，即将一个查询块嵌套在另一个查询块的 WHERE 子句或 HAVING 短语的条件中的查询。

子查询出现的位置：

- 放在 where 后面，作为被查询的条件的一部分，此时也叫嵌套查询；
- 放在 from 后面，作为表；

当子查询出现在 where 后作为条件时，还可以使用如下关键字：

- any
- all

子查询结果集的形式：

- 单行单列（用于条件）
- 单行多列（用于条件）
- 多行单列（用于条件）
- 多行多列（用于表）

示例：

**1.   工资高于 JONES 的员工。**

分析：

查询条件：工资 > JONES 工资，其中 JONES 工资需要一条子查询。

第一步：查询 JONES 的工资

```sql
SELECT sal FROM emp WHERE ename='JONES';
```

第二步：查询高于JONES工资的员工

```sql
SELECT * FROM emp WHERE sal > (第一步结果);
```

结果：

```sql
SELECT * FROM emp WHERE sal > (SELECT sal FROM emp WHERE ename='JONES');
```

**2. 查询与 SCOTT 同一个部门的员工。**

子查询作为条件

子查询形式为单行单列

分析：

查询条件：部门 = SCOTT 的部门编号，其中 SCOTT 的部门编号需要一条子查询。

第一步：查询SCOTT的部门编号

```sql
SELECT deptno FROM emp WHERE ename='SCOTT';
```

第二步：查询部门编号等于 SCOTT 的部门编号的员工

```sql
SELECT * FROM emp WHERE deptno = (SELECT deptno FROM emp WHERE ename='SCOTT');
```

**3. 工资高于 30 号部门所有人的员工信息**

分析：

```sql
-- 方式一
SELECT * FROMemp WHERE sal > (SELECT MAX(sal)FROM emp WHERE deptno = 30);
```

查询条件：工资高于 30 部门所有人工资，其中 30 部门所有人工资是子查询。高于所有需要使用 all 关键字。

第一步：查询 30 部门所有人工资

```sql
SELECT sal FROM emp WHERE deptno=30;
```

第二步：查询高于30部门所有人工资的员工信息

```sql
SELECT * FROM emp WHERE sal > ALL (第一步)
```

结果：

```sql
-- 方式二
SELECT * FROM emp WHERE sal > ALL (SELECT sal FROM emp WHERE deptno = 30)
```

查询出订单的价格大于300的所有用户信息

```sql
SELECT * FROM USER WHERE userId IN (SELECT DISTINCT userId FROM orders WHERE totalprice>300)
```

子查询作为条件

子查询形式为多行单列（当子查询结果集形式为多行单列时可以使用 ALL 或 ANY 关键字）

form 后面子查询

```sql
SELECT ename,job,hiredate FROM (SELECT ename,job,hiredate FROM emp WHERE hiredate > '1987-1-1') AS temp;
```

###### 5.2.4 导出导入数据库

1. 使用命令方式

导出数据库表

```sql
mysqldump -u root -p 密码 数据库名 表名 > school.sql
```

导入数据库表

```sql
mysql -u root -p
mysql> use 数据库
-- 然后使用 source 命令，后面参数为脚本文件(如这里用到的.sql)
mysql> source d:/dbname.sql
```

2. 使用 Navicat 工具完成导出导入

###### 5.2.5 创建用户和授权

```sql
-- 方式一
CREATE USER zhangsan IDENTIFIED BY '123'; -- 创建用户
  -- 切换密码校验方式
alter user 'zhangsan'@'%' identified with mysql_native_password by 'lalalala';
GRANT ALL ON stu.* TO zhangsan; -- 授权
REVOKE ALL ON school.* FROM zhangsan; -- 取消授权
DROP USER zhangsan; -- 删除用户

--方式二
CREATE USER zhangsan@localhost IDENTIFIED BY '123'; -- 创建用户
  -- 切换密码校验方式
alter user 'zhangsan'@'localhost' identified with mysql_native_password by 'lalalala';
GRANT ALL ON stu.* TO zhangsan@localhost; -- 授权
REVOKE ALL ON school.* FROM zhangsan@localhost; -- 取消授权
DROP USER zhangsan@localhost; -- 删除用户
```

##### 5.3 视图

- 通过视图，将某个表或多个表的字段提取出来，形成一个虚表，视图建立在已有表的基础上, 视图赖以建立的这些表称为基表。
- 向视图提供数据内容的语句为 SELECT 语句,可以将视图理解为存储起来的 SELECT 语句。
- 视图没有存储真正的数据，真正的数据还是存储在基表中，程序员虽然操作的是视图，但最终视图还会转成操作基表，一个基表可以有 0 个或多个视图。

- 如果不想让用户看到所有数据（字段，记录），只想让用户看到某些的数据时，此时可以使用视图;当需要减化 SQL 查询语句的编写时，**可以使用视图，但不提高查询效率**。

##### 练习

#### 6 视图



某网上商城数据库如下图所示

![038](https://upload-images.jianshu.io/upload_images/5097954-da5a2ccd7d0ccd6f.jpg)

```sql
-- 一对多的实现
-- 创建分类表
create table category(
  cid varchar(32) PRIMARY KEY ,
  cname varchar(100) -- 分类名称
);
-- 商品表
CREATE TABLE `products` (
  `pid` varchar(32) PRIMARY KEY  ,
  `name` VARCHAR(40) ,
  `price` DOUBLE(7,2) 
);
-- 添加外键字段
alter table products add column category_id varchar(32);
-- 添加约束
alter table products add constraint product_fk foreign key (category_id) references category (cid);
-- 多对多的实现
-- 订单表
create table `orders`(
  `oid` varchar(32) PRIMARY KEY ,
  `totalprice` double(12,2) -- 总计
);
-- 订单项表
create table orderitem(
  oid varchar(32), -- 订单id
  pid varchar(32) -- 商品id
);
-- 联合主键（可省略）
alter table `orderitem` add primary key (oid,pid);
-- 订单表和订单项表的主外键关系
alter table `orderitem` add constraint orderitem_orders_fk foreign key (oid) references orders(oid);
-- 商品表和订单项表的主外键关系
alter table `orderitem` add constraint orderitem_product_fk foreign key (pid) references products(pid);
-- 创建用户表
create table user(
	 userId int primary key auto_increment,
   username varchar(20) not null,
   password varchar(18) not null,
   address varchar(100),
   phone varchar(11),
)
-- 给 orders 表添加 userId
ALTER TABLE orders ADD userId INT;
ALTER TABLE orders ADD CONSTRAINT FOREIGN KEY(userId) REFERENCES USER(userId);
-- 初始化数据
-- 给商品表初始化数据
insert into products(pid,name,price,category_id) values('p001','联想',5000,'c001');
insert into products(pid,name,price,category_id) values('p002','海尔',3000,'c001');
insert into products(pid,name,price,category_id) values('p003','雷神',5000,'c001');
insert into products(pid,name,price,category_id) values('p004','JACK JONES',800,'c002');
insert into products(pid,name,price,category_id) values('p005','真维斯',200,'c002');
insert into products(pid,name,price,category_id) values('p006','花花公子',440,'c002');
insert into products(pid,name,price,category_id) values('p007','劲霸',2000,'c002');
insert into products(pid,name,price,category_id) values('p008','香奈儿',800,'c003');
insert into products(pid,name,price,category_id) values('p009','相宜本草',200,'c003');
insert into products(pid,name,price,category_id) values('p010','梅明子',200,null);
-- 给分类表初始化数据
insert into category values('c001','电器');
insert into category values('c002','服饰');
insert into category values('c003','化妆品');
insert into category values('c004','书籍');
-- 添加订单
insert into orders values('o6100',18000.50,1);
insert into orders values('o6101',7200.35,1);
insert into orders values('o6102',600.00,2);
insert into orders values('o6103',1300.26,4);
-- 用户表添加数据
INSERT INTO USER(username,PASSWORD,address,phone) VALUES('张三','123','北京昌平沙河','13812345678');
INSERT INTO USER(username,PASSWORD,address,phone) VALUES('王五','5678','北京海淀','13812345141');
INSERT INTO USER(username,PASSWORD,address,phone) VALUES('赵六','123','北京朝阳','13812340987');
INSERT INTO USER(username,PASSWORD,address,phone) VALUES('田七','123','北京大兴','13812345687');
```

#### 7 关于 JDBC 的简介

##### 7.1 简介

- JDBC（Java DataBase Connectivity，java 数据库连接）是一种用于执行 SQL 语句的 Java API，可以为多种关系数据库提供统一访问，它由一组用Java语言编写的类和接口组成。JDBC 提供了一种基准，据此可以构建更高级的工具和接口，使数据库开发人员能够编写数据库应用程序。

- Java 具有坚固、安全、易于使用、易于理解和可从网络上自动下载等特性，是编写数据库应用程序的杰出语言。所需要的只是 Java 应用程序与各种不同数据库之间进行对话的方法。

- JDBC 可以在各种平台上使用 Java，如 Windows，Mac OS 和各种版本的 UNIX。

- JDBC 库包括通常与数据库使用相关的下面提到的每个任务的 API。

  - 连接数据库。

  - 创建 SQL 或 MySQL 语句。

  - 在数据库中执行 SQL 或 MySQL 查询。

  - 查看和修改生成的记录。

##### 7.2 JDBC 体系结构

JDBC API 支持用于数据库访问的两层和三层处理模型，但通常，JDBC体系结构由两层组成：

- **JDBC API：**这提供了应用程序到JDBC管理器连接。
- **JDBC 驱动程序 API：**这支持JDBC管理器到驱动程序连接。

JDBC API使用驱动程序管理器和特定于数据库的驱动程序来提供与异构数据库的透明连接。

![屏幕快照 2017-09-05 下午3.51.56](https://upload-images.jianshu.io/upload_images/5097954-5b9fa8ce953aa79d.jpg)

##### 7.3 JDBC 核心组件

​    **DriverManager：** 此类管理数据库驱动程序列表。使用通信子协议将来自 java 应用程序的连接请求与适当的数据库驱动程序匹配。

​    **Driver：**此接口处理与数据库服务器的通信，我们很少会直接与 Driver 对象进行交互。而是使用DriverManager 对象来管理这种类型的对象。

​    **Connection**：该接口具有用于联系数据库的所有方法。连接对象表示通信上下文，即，与数据库的所有通信仅通过连接对象。

​    **Statement**：使用从此接口创建的对象将 SQL 语句提交到数据库。除了执行存储过程之外，一些派生接口还接受参数。

​    **ResultSet：**在使用 Statement 对象执行 SQL 查询后，这些对象保存从数据库检索的数据。它作为一个迭代器，允许我们移动其数据。

​    **SQLException：**此类处理数据库应用程序中发生的任何错误

#### 8 JDBC 使用

##### 8.1 使用步骤

###### 8.1.1 步骤概述(6个)

- **导入JDBC驱动包：**需要下载包含数据库编程所需的 JDBC 的 jar 包。

  [下载地址](https://dev.mysql.com/downloads/)

- **注册JDBC驱动程序：**要求您初始化驱动程序，以便您可以打开与数据库的通信通道。

- **打开连接：**需要使用 DriverManager.getConnection() 方法创建一个 Connection 对象，该对象表示与数据库的物理连接。

- **执行查询：**需要使用类型为 Statement 的对象来构建和提交 SQL 语句到数据库。

- **从结果集中提取数据：**需要使用相应的 ResultSet.getXXX() 方法从结果集中检索数据。

- **释放资源：**需要明确地关闭所有数据库资源，而不依赖于JVM的垃圾收集。

###### 8.1.2 步骤使用

1. **导入 jar 包**

   在项目下创建 lib 目录，把 mysql 的 jdbc 包放入此目录总，并添加到 build path 中。

2. **注册驱动**

   方式一（推荐写法）：**Class.forName()**

   注册驱动程序最常见的方法是使用 Java 的 **Class.forName()**方法，将驱动程序的类文件动态加载到内存中，并将其自动注册

   方式二：使用静态 **DriverManager.registerDriver()** 方法。

3. **获取连接**

   3.1 数据库URL配置

   加载驱动程序后，可以使用 **DriverManager.getConnection()** 方法建立连接。为了方便参考，让我列出三个重载的 DriverManager.getConnection() 方法

   - getConnection(String url)
   - getConnection(String url，Properties prop)
   - getConnection(String url，String user，String password)

| RDBMS   | JDBC驱动程序名称                                             | 网址格式                                                 |
| ------- | ------------------------------------------------------------ | -------------------------------------------------------- |
| MySQL的 | com.mysql.jdbc.Driver (5.x版本)  com.mysql.cj.jdbc.Driver (8.x版本) | **jdbc:mysql://**hostname:3306/databaseName              |
| ORACLE  | oracle.jdbc.driver.OracleDriver                              | **jdbc:oracle:thin:@** hostname:port Number:databaseName |
| DB2     | COM.ibm.db2.jdbc.net.DB2Driver                               | **jdbc:db2:**hostname:port Number/databaseName           |
| SYBASE  | com.sybase.jdbc.SybDriver                                    | **jdbc:sybase:Tds:** hostname:port Number/databaseName   |

​	3.2 创建数据库连接对象

4. **执行查询**

   一旦获得了连接，我们可以与数据库进行交互。JDBC Statement 和 PreparedStatement 接口定义了使您能够发送 SQL 命令并从数据库接收数据的方法和属性。

   | 接口                                   | 使用                                                         |
   | -------------------------------------- | ------------------------------------------------------------ |
   | Statement                              | 用于对数据库进行通用访问。在运行时使用静态 SQL 语句时很有用。Statement接口不能接受参数。 |
   | PreparedStatement       (**推荐使用**) | 当您计划多次使用 SQL 语句时使用。PreparedStatement 接口在运行时接受输入参数。 |

   **4.1 Statement 对象**

   创建 Statement 对象后，您可以使用它来执行一个 SQL 语句，其中有三个执行方法之一。

   - **boolean execute(String SQL)**：如果可以检索到 ResultSet 对象，则返回一个布尔值 true， 否则返回false，使用此方法执行 SQL DDL 语句或需要使用真正的动态 SQL 时。
   - **int executeUpdate(String SQL)**：返回受 SQL 语句执行影响的行数。使用此方法执行预期会影响多个行的SQL 语句，例如 INSERT，UPDATE 或 DELETE 语句 或 DDL 语句。
   - **ResultSet executeQuery(String SQL)**：返回一个 ResultSet 对象。当您希望获得结果集时，请使用此方法，就像使用 SELECT 语句一样。

   **注：1. 需要显示的关闭 Statement 对象**

   ​		**2. 容易造成 SQL 注入**

   **4.2 PreparedStatement 对象**

   该 PreparedStatement 的接口扩展了 Statement 接口，它为您提供了一个通用的 Statement 对象有两个优点附加功能。

   - **安全** ( ? 表示占位符，执行时 ? 会替换为实际数据 )
   - **执行效率高** (会预编译)
   - 使用 **setXXX()** 方法将值绑定到所述参数，其中 **XXX** 代表要绑定到输入参数的值的 Java 数据类型，如果忘记提供值，将收到一个 SQLException。每个参数标记由其顺序位置引用，第一个标记表示位置 1，第二个位置是 2。
   - **需要显示的关闭 Statement 对象**

5. **处理结果**

   ##### 5.1 ResultSet 结果集

   SELECT 语句是从数据库中选择行并在结果集中查看行的标准方法。该 java.sql.ResultSet 中的接口表示结果集数据库查询。

   ResultSet 对象维护指向结果集中当前行的指针。术语“结果集”是指包含在 ResultSet 对象中的行和列数据。

   如果没有指定任何 ResultSet 类型，您将自动获得一个 TYPE_FORWARD_ONLY。

   | 类型                              | 描述                                                         |
   | --------------------------------- | ------------------------------------------------------------ |
   | ResultSet.TYPE_FORWARD_ONLY       | 光标只能在结果集中向前移动。                                 |
   | ResultSet.TYPE_SCROLL_INSENSITIVE | 光标可以向前和向后滚动，结果集对创建结果集后发生的数据库的其他更改不敏感。 |
   | ResultSet.TYPE_SCROLL_SENSITIVE。 | 光标可以向前和向后滚动，结果集对创建结果集之后发生的其他数据库所做的更改敏感。 |

6. **释放资源**

为确保资源释放，您可以在代码中提供一个 finally 块，并在 finally 块里执行资源释放的代码。

```java
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class JDBCDemo {
  public static void main(String[] args) {
    Connection connection = null; // 连接对象
    Statement stat = null; // sql 语句对象
    // PreparedStatement ps = null; // sql 语句对象
    ResultSet rs = null; // 结果集
    try {
      // === 2 注册驱动 ===
      // 方式一，推荐
      // Class.forName("com.mysql.jdbc.Driver"); // mysql 5.x 版本
      Class.forName("com.mysql.cj.jdbc.Driver"); // mysql 8.x 版本
      // 方式二，不推荐，原因 1、驱动程序会注册两次，2、java 程序依赖 mysql 驱动包
      // Driver myDriver = new com.mysql.cj.jdbc.Driver();
      // DriverManager.registerDriver( myDriver );
      // === 3 获取连接 ===
      String URL = "jdbc:mysql://localhost:3306/student"; // 简写 jdbc:mysql:///student
      // 通过 ip 访问，需要设置 mysql 库里的 user 表中该用户的 host 为 % 来支持远端访问
      String URL = "jdbc:mysql://192.168.1.100:3306/student";
      String USER = "root";
      String PWD = "lalalala";
      connection = DriverManager.getConnection(URL, USER, PWD);
      // === 4 创建 sql 语句对象 ===
      // 使用 Statement 对象
      stat = connection.createStatement();
      // 使用 PreparedStatement 对象(推荐)
      // ? 表示占位符，执行时 ? 会替换为实际数据，并且会预编译
      // 优点：1、安全，2、效率高
			// ps = connection.PreparedStatement("select * from user where username=? and password=?");
			// 给 ps 设置参数
			// ps.setString(1, "zhangsan");
			// ps.setString(2, "123456");
      // 执行命令查询
      // rs = stat.executeQuery("select * from emp");
      rs = stat.executeQuery("select id, `name` from emp;");
      // === 5 处理结果 ====
      while(rs.next()){
    	  // 使用列索引获取值
        // int id = rs.getInt(1);
        // String nameString = rs.getString(2);
    	  // 使用列名获取值（推荐）
        int id = rs.getInt("id");
        String name = rs.getString("name");
        System.out.println(id + " --- " + name);
      }
      // 执行插入操作
      int result = stat.executeUpdate("insert into emp (`name`, deptno) values ('田七', 5)");
			if (result > 0) {
				System.out.println("添加成功");
			} else {
				System.out.println("添加失败");
			}
      // 执行更新操作
			result = stat.executeUpdate("update emp set `name`='马六六' where deptno = 6");
			if (result > 0) {
				System.out.println("更新成功");
			} else {
				System.out.println("更新失败");
			}
      // 执行删除操作
			result = stat.executeUpdate("delete from emp where deptno = 2");
			if (result > 0) {
				System.out.println("删除成功");
			} else {
				System.out.println("删除失败");
			}
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      // === 6 释放资源 ===
      // 关闭结果集
      if(rs != null){
        try {
          rs.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
      // 关闭语句对象
      if(stat != null){
        try {
          stat.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
      // 关闭连接
      if(connection != null){
        try {
          connection.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
```

###### 8.1.3 SQL注入

就是通过把SQL命令插入到Web表单提交或输入域名或页面请求的查询字符串，最终达到欺骗服务器执行恶意的SQL命令。具体来说，它是利用现有应用程序，将（恶意的）SQL命令注入到后台数据库引擎执行的能力，它可以通过在Web表单中输入（恶意）SQL语句得到一个存在安全漏洞的网站上的数据库，而不是按照设计者意图去执行SQL语句。比如先前的很多影视网站泄露VIP会员密码大多就是通过WEB表单递交查询字符暴出的，这类表单特别容易受到SQL注入式攻击。

```sql
-- "select * from user where name='" + name + "' and password='" + password + "';"
-- 如果 name = "dad' or 1=1; -- " 就变成
select * from user where name='dad' or 1=1; -- ' and password='123';
-- 这样就造成可以查得到数据造成误判为登录成功
```

###### 8.2.4 批处理 和 事务隔离级别

**1. 事务**

- **事务概述**

  数据库事务(Database Transaction) 是一组要么同时执行成功，要么同时执行失败的 SQL 语句，是数据库操作的一个执行单元。 事务处理可以确保除非事务性单元内的所有操作都成功完成，否则不会永久更新面向数据的资源。通过将一组相关操作组合为一个要么全部成功要么全部失败的单元，可以简化错误恢复并使应用程序更加可靠。一个逻辑工作单元要成为事务，必须满足所谓的 ACID（原子性、一致性、隔离性和持久性）属性。事务是数据库运行中的逻辑工作单位，由 DBMS 中的事务管理子系统负责事务的处理。

- **事务开始于**
  - 连接到数据库上，并执行一条 DML 语句 insert、update 或 delete
  - 前一个事务结束后，又输入了另一条 DML 语句

- **事务结束于**
  - 执行一条 DCL 语句，例如 grant 语句，会自动执行 commit。
  - 执行一条 DDL 语句，例如 create table 语句，会自动执行 commit 语句。
  - 执行一条 DML 语句，但是该语句却执行失败了，此时会为这个无效的 DML 语句执行 rollback 语句。
  - 显示地执行 commit 或 rollback 语句。
  - 断开与数据库的连接。

- **事务的四大特点 (ACID)**

  **Actomicity (原子性)**

  表示一个事务内的所有操作是一个整体，要么全部成功，要么全部失败

  **Consistency (一致性)**

  表示一个事务内有一个操作失败时，所有的更改过的数据都必须回滚到修改前状态

  **Isolation (隔离性)**

  事务查看数据时数据所处的状态，要么是另一并发事务修改它之前的状态，要么是另一事务修改它之后的状态，事务不会查看中间状态的数据。

  **Durability (持久性)**

  持久性事务完成之后，它对于系统的影响是永久性的。

**2. 事务隔离级别 (事务与事务之间操作关系)**

- SQL标准定义了4类隔离级别，包括了一些具体规则，用来限定事务内外的哪些改变是可见的，哪些是不可见的，低级别的隔离级一般支持更高的并发处理，并拥有更低的系统开销，高级别的效率太低，一般折中处理。
- 这四种隔离级别采取不同的锁类型来实现。

- 事务级别：**Serializable** > **Repeatable Read** > **Read Committed** > **Read Uncommitted**

**Read Uncommitted**（读取未提交内容)

在该隔离级别，所有事务都可以看到其他未提交事务的执行结果。本隔离级别很少用于实际应用，因为它的性能也不比其他级别好多少。读取未提交的数据，也被称之为 **脏读**（Dirty Read）。

**Read Committed**（读取提交内容，**Oracle 默认级别**）

这是大多数数据库系统的默认隔离级别（但不是MySQL默认的）。它满足了隔离的简单定义：一个事务只能看见已经提交事务所做的改变。这种隔离级别也支持所谓的不可重复读（Nonrepeatable Read），因为同一事务的其他实例在该实例处理其间可能会有新的 commit，所以同一 select 可能返回不同结果。

**Repeatable Read **（可重读，**mysql 默认级别**）

这是MySQL的默认事务隔离级别，它确保同一事务的多个实例在并发读取数据时，会看到同样的数据行。不过理论上，这会导致另一个棘手的问题：幻读（Phantom Read）。简单的说，幻读指当用户读取某一范围的数据行时，另一个事务又在该范围内插入了新行，当用户再读取该范围的数据行时，会发现有新的“幻影” 行。InnoDB和Falcon存储引擎通过多版本并发控制（MVCC，Multiversion Concurrency Control）机制解决了该问题。

**Serializable** （可串行化）

这是最高的隔离级别，它通过强制事务排序，使之不可能相互冲突，从而解决幻读问题。简言之，它是在每个读的数据行上加上共享锁。在这个级别，可能导致大量的超时现象和锁竞争。

**3. 保存点**

- 新的JDBC 3.0 Savepoint接口为您提供了额外的事务控制。
- 设置保存点时，可以在事务中定义逻辑回滚点，如果通过保存点发生错误，则可以使用回滚方法来撤消所有更改或仅保存在保存点之后所做的更改。
- **setSavepoint(String savepointName)：**定义新的保存点，它还返回一个 Savepoint 对象。
- **releaseSavepoint(Savepoint savepointName)：**删除保存点，它需要一个 Savepoint 对象作为参数，此对象通常是由 setSavepoint() 方法生成的保存点。

**4. Statement 批处理**

```java
// ====== 批处理、事务 和 保存点 ======
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class JDBCDemo {
  public static void main(String[] args) {
    Connection connection = null; // 连接对象
    Statement stat = null; // sql 语句对象
		Savepoint savepoint = null;//保存点
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      String URL = "jdbc:mysql://localhost:3306/student";
      String USER = "root";
      String PWD = "lalalala";
      connection = DriverManager.getConnection(URL, USER, PWD);
      // === 4 执行批处理(Statement) ===
      // 缺点：1、每次都要添加sql语句，2、不能避免 SQL 注入
      stat = connection.createStatement();
      // 4.1 设置事务不自动提交(默认为 true)
      connection.setAutoCommit(false);
      for(int i = 1; i <= 100; i++){
        stat.addBatch("insert into user (username, password, phone) values('王五" + i + "','123456','18944123132')"); // 放入到批处理
        if (i % 50 == 0) {
          int[] result = stat.executeBatch(); // 执行批处理
          if (i == 50) savepoint = connection.setSavepoint("save1"); // 添加保存点
          stat.clearBatch(); // 清空批处理
        }
        // connection.releaseSavepoint(savepoint); // 删除保存点
      }
      // 4.2 提交事务
      connection.commit();
    } catch (Exception e) {
      try {
        // connection.rollback(); // 回滚(撤消)到事务最开始状态
				connection.rollback(savepoint); // 回滚(撤消)到保存点位置
        connection.commit(); // 提交
      } catch (SQLException e1) { e1.printStackTrace(); }
      e.printStackTrace();
    } finally {
      if (stat != null) {
        try { stat.close(); }
        catch (SQLException e) { e.printStackTrace(); }
      }
      if (connection != null) {
        try { connection.close(); }
        catch (SQLException e) { e.printStackTrace(); }
      }
    }
  }
}
```

**5. PrepareStatement 批处理**

```java
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
public class JDBCDemo {
  public static void main(String[] args) {
    Connection connection = null; // 连接对象
    PreparedStatement pstat = null; // sql 语句对象
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      String URL = "jdbc:mysql://localhost:3306/student";
      String USER = "root";
      String PWD = "lalalala";
      connection = DriverManager.getConnection(URL, USER, PWD);
      // === 4 执行批处理(PreparedStatement) ===
      // 创建命令对象，? 为占位符，执行时会输入实际数据
      pstat = connection.PreparedStatement("insert into user(username,password,phone) values(?,?,?)");
      // 4.1 设置事务不自动提交(默认为 true)
      connection.setAutoCommit(false);
      for (int i = 1; i <= 100; i++) {
        pstat.setString(1, "王五" + i);
        pstat.setString(2, "6666");
        pstat.setString(3, "18988889999");
        pstat.addBatch(); // 放入到批处理
        if (i % 50 == 0) {
          int[] rs = pstat.executeBatch(); // 执行批处理
          pstat.clearBatch(); // 清空批处理
        }
      }
      // 4.2 提交事务
      connection.commit();
    } catch (Exception e) {
      try {
        connection.rollback(); // 回滚(撤消)到事务最开始状态
        connection.commit(); // 提交
      } catch (SQLException e1) { e1.printStackTrace(); }
      e.printStackTrace();
    } finally {
      if (pstat != null) {
        try { stat.close(); }
        catch (SQLException e) { e.printStackTrace(); }
      }
      if (connection != null) {
        try { connection.close(); }
        catch (SQLException e) { e.printStackTrace(); }
      }
    }
  }
}
```

###### JDBC 操作二进制数据

有以下方法可用于流式传输数据 -

- **setAsciiStream()：**此方法用于提供大的 ASCII 值（**文本**）。
- **setCharacterStream()：**此方法用于提供大型 UNICODE 值（**文本**）。
- **setBinaryStream()：**此方法用于提供较大的二进制值（**文本、blob**）。

**setXXXStream()** 方法除了参数占位符之外还需要额外的参数，文件大小。

```xml
<?xml version="1.0" encoding="UTF-8"?>
<Employee>
  <id>100</id>
  <first>Zara</first>
  <last>Ali</last>
  <Salary>10000</Salary>
  <Dob>18-08-1978</Dob>
</Employee>
```

```java
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.omg.PortableInterceptor.IORInterceptor;
public class JdbcBinaryDemo {
  public static void main(String[] args) {
    Connection connection = null;
    PreparedStatement pstat = null;
    PreparedStatement pstat2 = null;
    PreparedStatement pstat3 = null;
    ResultSet rs = null;
    try {
      // 1 注册驱动
      Class.forName("com.mysql.cj.jdbc.Driver");
      // 2 获取连接
      connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "root");
      // 3 创建命令对象
      String sql1 = "drop table if exists xmltable;";
      String sql2 = "create table xmltable (id int primary key,data text);";
      pstat = connection.prepareStatement(sql1);
      boolean b = pstat.execute(); // 删除表
      boolean b2 = pstat.execute(sql2); // 创建表
      System.out.println("创建表成功");
      // 4 添加数据
      pstat2 = connection.prepareStatement("insert into xmltable(id,data) values(?,?)");
      File file = new File("src/emp.xml");
      FileInputStream fis = new FileInputStream(file);
      pstat2.setInt(1, 10);
      // 当数据为 text 时可用 setAsciiStream / setBinaryStream / setCharacterStream
      // 当数据为 blob 时最好用 setBinaryStream
      pstat2.setAsciiStream(2, fis, file.length());
      // pstat2.setCharacterStream(2, new InputStreamReader(fis), file.length());
      // pstat2.setBinaryStream(2, fis, file.length());
      int r = pstat2.executeUpdate();
      if (r > 0) { System.out.println("添加成功"); }
      // 读取数据
      pstat3 = connection.prepareStatement("select * from xmltable where id=10;");
      rs = pstat3.executeQuery();
      if(rs.next()){
        int id = rs.getInt("id");
        System.out.println(id);
        InputStream is = rs.getAsciiStream("data");
        // 读取流
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        int len = 0;
        while ((len = is.read(buf)) != -1) {
          baos.write(buf, 0, len);
        }
        System.out.println(baos.toString());
        is.close();
      }
    } catch (Exception e) { e.printStackTrace(); }
    finally {
      if (rs != null) {
        try { rs.close(); }
        catch (SQLException e) { e.printStackTrace(); }
      }

      if (pstat != null) {
        try { pstat.close(); }
        catch (SQLException e) { e.printStackTrace(); }
      }
      if(pstat2 != null){
        try { pstat2.close(); }
        catch (SQLException e) { e.printStackTrace(); }
      }
      if(pstat3 != null){
        try { pstat3.close(); }
        catch (SQLException e) { e.printStackTrace(); }
      }
      if(connection != null){
        try { connection.close(); }
        catch (SQLException e) { e.printStackTrace(); }
      }
    }
  }
}
```

#### 9 连接池

##### 9.1 自定义连接池

###### 9.1.1 DAO 设计模式

- DAO(Database Access Object，数据库访问对象)，DAO 设计模式是为了降低耦合性，它可以实现业务逻辑与数据库访问相分离，数据库是比较稳定的，其中 DAO 组件依赖于数据库系统，提供数据库访问的接口。

- DAO 模式的组成部分

  1. DAO接口（主要 添加 修改 更新 删除方法）
  2. DAO实现类
  3. 实体类 （domain、beans、entity、pojo、model）
     - 作用：用在数据访问代码和业务逻辑代码之间通过实体类来传输数据
     - 实体类特征：
       - 属性一般使用 private 修饰
       - 提供 public 修饰的 getter/setter 方法
       - 实体类提供无参构造方法，根据业务提供有参构造
       - 实现 java.io.Serializable 接口，支持序列化机制

  4. 数据库连接和关闭工具类

- DAO 模式设计的包名 :
  - domain  存放实体类
  - utils  存放工具类
  - dao  存放接口
  - dao.impl  存放实现类

   见下例

###### 9.1.2 DbUtils 封装

具体见下例

###### 9.1.3 自定义连接池

**DAO 接口**

```java
package com.qf.dao;

import java.util.List;
import com.qf.domain.Employee;
public interface EmployeeDao {
	 // 1查询所有
	 List<Employee> findAll();
	 // 根据编号查询员工
	 Employee findByNo(int empno);
	 // 2 更新
	 void update(Employee e);
	 // 3 删除
	 void delete(int empno);
	 // 4 添加
	 void add(Employee e);
}
```

**DAO 实现类**

```java
package com.qf.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.qf.dao.EmployeeDao;
import com.qf.domain.Employee;
import com.qf.utils.DbUtils;
public class EmployeeDaoImpl implements EmployeeDao {
	@Override
	public List<Employee> findAll() {
		ArrayList<Employee> employees = new ArrayList<Employee>();
		// 1 获取连接
		Connection conn = null;
		PreparedStatement pstat = null;
		ResultSet rs = null;
		try {
			conn = DbUtils.getConnection();
			pstat = conn.prepareStatement("select * from emp;");
			rs = pstat.executeQuery();
			while(rs.next()){
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				Date date = rs.getDate("hiredate");
				double sal = rs.getDouble("sal");
				Employee employee = new Employee(empno, ename, date, sal);
				employees.add(employee);
			}
			return employees;
		} catch (Exception e) {
			throw new RuntimeException("查询emp失败");
		} finally {
			DbUtils.closeAll(rs, pstat, conn);
		}
	}
	@Override
	public void update(Employee e) {
		Object[] params = {e.getEname(),e.getJob(),e.getMgr(),e.getHiredate(),e.getSal(),e.getComm(),e.getDeptno(),e.getEmpno()};
		DbUtils.executeUpdate("update emp set ename=?,hiredate=?,sal=? where empno=?", params);
	}
	@Override
	public void delete(int empno) {
		DbUtils.executeUpdate("delete from emp where empno=?", empno);
	}
	@Override
	public void add(Employee e) {
		Object[] params = {e.getEmpno(),e.getEname(),e.getHiredate(),e.getSal()};
		DbUtils.executeUpdate("insert into emp values(?,?,?,?)", params);
	}
	@Override
	public Employee findByNo(int empno) {
		// 1 获取连接
		Connection conn = null;
		PreparedStatement pstat = null;
		ResultSet rs = null;
		try {
			conn = DbUtils.getConnection();
			pstat = conn.prepareStatement("select * from emp where empno=?;");
			pstat.setInt(1, empno);
			rs = pstat.executeQuery();
			Employee employee = null;
			if(rs.next()){
				String ename = rs.getString("ename");
				Date date = rs.getDate("hiredate");
				double sal = rs.getDouble("sal");
				employee = new Employee(empno, ename, job, mgr, date, sal, comm, deptno);
			}
			return employee;
		} catch (Exception e) {
			throw new RuntimeException("查询emp失败");
		} finally {
			DbUtils.closeAll(rs, pstat, conn);
		}
	}
}
```

**实体类**

```java
package com.qf.domain;

// 常用包名 domain、beans、entity、pojo、model
import java.io.Serializable;
import java.util.Date;
public class Employee implements Serializable {
	private static final long serialVersionUID = 373910607014836778L;
	private int empno;
	private String ename;
	private Date hiredate;
	private double sal;
	public Employee() {}
	public Employee(int empno, String ename, String job, int mgr, Date hiredate, double sal, double comm, int deptno) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.hiredate = hiredate;
		this.sal = sal;
	}
	public int getEmpno() { return empno; }
	public void setEmpno(int empno) { this.empno = empno; }
	public String getEname() { return ename; }
	public void setEname(String ename) { this.ename = ename; }
	public Date getHiredate() { return hiredate; }
	public void setHiredate(Date hiredate) { this.hiredate = hiredate; }
	public double getSal() { return sal; }
	public void setSal(double sal) { this.sal = sal; }
	@Override
	public String toString() {
		return "Employee [empno=" + empno + ", ename=" + ename + ", hiredate=" + hiredate + ", sal=" + sal + "]";
	}
}
```

**数据库配置项**

```properties
#驱动名称
driver=com.mysql.jdbc.Driver
#连接字符串
url=jdbc:mysql://localhost:3306/school
#用户名
user=root
#密码
password=root
```

**数据库连接和关闭工具类**

```java
package com.qf.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
public class DbUtils {
	// 驱动名称 com.mysql.jdbc.Driver
	private static String driver;
	private static String url;
	private static String username;
	private static String password;
	static{
		// 1 注册驱动
		try {
			Properties properties = new Properties();
			// 加载的文件是src下面的文件
			// FileInputStream fis = new FileInputStream("src\\database.properties");
			// 通过类加载器获取流(直接加载 bin 目录中的文件)
			InputStream is = DbUtils.class.getClassLoader().getResourceAsStream("database.properties");
			properties.load(is);
			is.close();
			driver = properties.getProperty("driver");
			url = properties.getProperty("url");
			username = properties.getProperty("user");
			password = properties.getProperty("password");
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// 2 获取连接
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	// 3 释放资源
	public static void closeAll(ResultSet rs,Statement stat,Connection conn){
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (stat != null) {
			try {
				stat.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * 4 执行命令 添加  删除  修改
	 * insert into emp (....) values( ?,?,?)
	 * delete from emp where empno=?
	 * update ....
	 */
	public static int executeUpdate(String sql, Object... params){
		// 1 获取连接
		Connection conn = null;
		// 2 创建命令对象
		PreparedStatement pstat = null;
		try {
			conn = getConnection();
			pstat = conn.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				pstat.setObject(i + 1, params[i]);
			}
			// 3 执行
			return pstat.executeUpdate();
		} catch (Exception e) {
		} finally {
			closeAll(null, pstat, conn);
		}
		return 0;
	}
}
```

**使用(DbUtils)**

```java
package com.qf.day05;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import com.qf.dao.EmployeeDao;
import com.qf.dao.impl.EmployeeDaoImpl;
import com.qf.domain.Employee;
public class Test {
	public static void main(String[] args) {
		System.out.println("请选择操作 : 1 查询  2添加 3更新 4删除");
		Scanner input = new Scanner(System.in);
		int choice = input.nextInt();
		EmployeeDao employeeDao = new EmployeeDaoImpl();
		switch (choice) {
			case 1:
				List<Employee> employees = employeeDao.findAll();
				for (Employee e : employees) {
					System.out.println(e.toString());
				}
			break;
			case 2:
				System.out.println("请输入员工编号");
				int empno = input.nextInt();
				System.out.println("请输入员工姓名");
				String ename = input.next();
				System.out.println("请输入员工工作");
				String job = input.next();
				System.out.println("请输入员工经理编号");
				int mgr = input.nextInt();
				System.out.println("请输入员工入职时间");
				String hiredate = input.next();
				System.out.println("请输入员工工资");
				double sal = input.nextDouble();
				System.out.println("请输入员工奖金");
				double comm = input.nextDouble();
				System.out.println("请输入员工部门");
				int deptno = input.nextInt();
				// 1 封装成一个Employee对象
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				try {
					Employee e = new Employee(empno, ename, job, mgr,sdf.parse(hiredate), sal, comm, deptno);
					employeeDao.add(e);
					System.out.println("添加成功");
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			break;
		case 3:
			System.out.println("请输入要更新的员工编号:");
			int eno = input.nextInt();
			Employee employee = employeeDao.findByNo(eno);
			if (employee != null) {
				System.out.println("请输入新的名字");
				String newname = input.next();
				employee.setEname(newname);
				// 修改数据库
				employeeDao.update(employee);
				System.out.println("修改成功");
			} else {
				System.out.println("没有要修改的员工");
			}
			break;
		case 4:
			System.out.println("请输入要删除的编号");
			int no = input.nextInt();
			employeeDao.delete(no);
			System.out.println("删除成功");
			break;
		default:
			break;
		}
	}
}
```

**自定义连接池**

```java
package com.qf.utils;

import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;
import javax.sql.DataSource;
public class MyPool implements DataSource {
	// 同步的集合
	private static List<Connection> connections = Collections.synchronizedList(new LinkedList<Connection>());
	static{
		try {
			Properties properties = new Properties();
			// 加载的文件是 src 下面的文件
			// FileInputStream fis = new FileInputStream("src\\database.properties");
			// 通过类加载器获取流(直接加载 bin 目录中的文件)
			InputStream is = MyPool.class.getClassLoader().getResourceAsStream("database.properties");
			properties.load(is);
			is.close();
			String driver = properties.getProperty("driver");
			String url = properties.getProperty("url");
			String username = properties.getProperty("user");
			String password = properties.getProperty("password");
			Class.forName(driver);
			// 获取连接
			for(int i = 0;i < 5; i++){
				Connection conn = DriverManager.getConnection(url, username, password);
				connections.add(conn);
				System.out.println(conn.hashCode());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public Connection getConnection() throws SQLException {
		if (connections.size() > 0) {
			Connection connection = connections.remove(0);
			return connection;
		}
		return null;
	}
	public void release(Connection conn){
		connections.add(conn);
	}
	@Override
	public PrintWriter getLogWriter() throws SQLException {
		return null;
	}
	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {}
	@Override
	public void setLoginTimeout(int seconds) throws SQLException {}
	@Override
	public int getLoginTimeout() throws SQLException { return 0; }
	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException { return null; }
	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException { return null; }
	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException { return false; }
	@Override
	public Connection getConnection(String username, String password) throws SQLException {
    return null;
  }
}
```

**使用(自定义连接池)**

```java
package com.qf.day05;

import java.sql.Connection;
import java.sql.SQLException;
import com.qf.utils.MyPool;
public class TestPool {
	public static void main(String[] args) {
		MyPool myPool = new MyPool();
		for (int i = 0; i < 5; i++) {
			try {
				Connection conn = myPool.getConnection();
				System.out.println(conn.getClass().getName());
				System.out.println("使用:" + conn.hashCode() + "..." + conn.getClass().getName());
				myPool.release(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
```

##### 9.2 DBCP 连接池

- DBCP（DataBase connection pool，数据库连接池），是 apache 上的一个 java 连接池项目，也是 tomcat 使用的连接池组件。单独使用 dbcp 需要2个包：commons-dbcp.jar，commons-pool.jar。由于建立数据库连接是一个非常耗时的行为，所以通过连接池预先同数据库建立一些连接，放在内存中，应用程序需要建立数据库连接时直接到连接池中申请一个就行，用完后再放回去。

- 导入相应 jar 包
  - mysql-connector-java-5.1.41-bin.jar（mysql 驱动包）
  - commons-dbcp.jar
  - commons-pool.jar
  - logging.jar 日志支持

**DBCP 配置项**

```properties
# ====== dbcp.properties ======
# 连接设置
driverClassName=com.mysql.jdbc.Driver
url=jdbc:mysql://localhost:3306/school
username=root
password=root
#<!-- 初始化连接 -->
initialSize=10
#最大连接数量
maxTotal=50
#<!-- 最大空闲连接 -->
maxIdle=20
#<!-- 最小空闲连接 -->
minIdle=5
#<!-- 超时等待时间以毫秒为单位 6000毫秒/1000等于60秒 -->
maxWaitMillis=5000
```

**DBCP 使用**

```java
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;
public class Test2 {
	public static void main(String[] args) {
		try {
			BasicDataSourceFactory factory = new BasicDataSourceFactory();
			Properties properties = new Properties();
			InputStream is = Test2.class.getClassLoader().getResourceAsStream("dbcp.properties");
			properties.load(is);
		  BasicDataSource pool=	factory.createDataSource(properties);
	    for (int i = 0; i < 100; i++) {
	      Connection connection = pool.getConnection();
		    System.out.println(connection);
		    // connection.close();
	    }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
```

##### 9.3 C3P0 连接池

- C3P0 是一个开源的 JDBC 连接池，它实现了数据源和 JNDI 绑定，支持 JDBC3 规范和 JDBC2 的标准扩展，目前使用它的开源项目有 Hibernate，Spring 等。

- C3P0 不需要手动设置，而 DBCP 需要手动设置配置文件。

  注：1. 因 C3P0 是在外部添加配置文件，工具直接进行应用，所以要求固定的命名和文件位置

  ​	2. C3P0 是单线程的，实际开发可能会选 Druid。

- 导入相应 jar 包

  - mysql-connector-java-5.1.41-bin.jar（mysql 驱动包）
  - c3p0-0.9.1.2.jar
  - mchange-commons-java-0.2.11.jar

**C3P0 配置文件**

```xml
<!-- ====== 指定的文件名：c3p0-config.xml ====== -->
<c3p0-config>
	<!-- 默认配置，如果没有指定则使用这个配置 -->
	<default-config>
		<!-- 基本配置 -->
		<property name="driverClass">com.mysql.jdbc.Driver</property>
		<property name="jdbcUrl">jdbc:mysql://localhost:3306/day2</property>
		<property name="user">root</property>
		<property name="password">111</property>
		<!--扩展配置-->
		<!-- 连接超过30秒报错-->
		<property name="checkoutTimeout">30000</property>
		<!--30秒检查空闲连接 -->
		<property name="idleConnectionTestPeriod">30</property>
		<property name="initialPoolSize">10</property>
		 <!-- 30秒不适用丢弃-->
		<property name="maxIdleTime">30</property>
		<property name="maxPoolSize">100</property>
		<property name="minPoolSize">10</property>
	</default-config> 
	<!-- 命名的配置 -->
	<named-config name="ldf">
		<property name="driverClass">com.mysql.jdbc.Driver</property>
		<property name="jdbcUrl">jdbc:mysql://localhost:3306/day2</property>
		<property name="user">root</property>
		<property name="password">111</property>
		<!-- 如果池中数据连接不够时一次增长多少个 -->
		<property name="acquireIncrement">5</property>
		<property name="initialPoolSize">20</property>
		<property name="minPoolSize">10</property>
    <property name="maxPoolSize">40</property>
	</named-config>
</c3p0-config> 
```

**C3P0 使用**

```java
import java.sql.Connection;
import java.sql.SQLException;
import com.mchange.v2.c3p0.ComboPooledDataSource;
public class C3p0Test {
	public static void main(String[] args) {
		// 1 创建连接池
		// 默认 bin 找 c3p0-config.xml  c3p0-config.properties
		ComboPooledDataSource pool = new ComboPooledDataSource(); // 使用默认配置
		ComboPooledDataSource pool = new ComboPooledDataSource("ldf"); // 使用 ldf 配置
		// 2 使用
		for (int i = 0; i < 30; i++) {
			try {
				Connection conn = pool.getConnection();
				System.out.println(conn.getClass().getName());
				conn.close(); // 释放到连接池中
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
```

##### 9.4 Druid 连接池

- Druid 是目前比较流行的高性能的，分布式列存储的 OLAP 框架(具体来说是 MOLAP )。它有如下几个特点：
  1. 亚秒级查询
     Druid 提供了快速的聚合能力以及亚秒级的 OLAP查询能力，多租户的设计，是面向用户分析应用的理想方式。
  2. 实时数据注入
     Druid支持流数据的注入，并提供了数据的事件驱动，保证在实时和离线环境下事件的实效性和统一性。
  3. 可扩展的PB级存储
     Druid集群可以很方便的扩容到 PB 的数据量，每秒百万级别的数据注入，即便在加大数据规模的情况下，也能保证时其效性。
  4. 多环境部署
     Druid既可以运行在商业的硬件上，也可以运行在云上，它可以从多种数据系统中注入数据，包括hadoop，spark，kafka，storm 和 samza 等。
  5. 丰富的社区
     Druid拥有丰富的社区，供大家学习。

- 导入相应 jar 包
  - mysql-connector-java-5.1.41-bin.jar（mysql 驱动包）
  - druid-1.1.5.jar

**Druid 配置文件**

```properties
# ====== database.properties ======
driverClassName=com.mysql.jdbc.Driver
url=jdbc:mysql://localhost:3306/school
username=root
password=root
initialSize=10
maxActive=30
minIdle=5
maxWait=10000
```

**Druid 使用**

```java
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import javax.sql.DataSource;
import org.omg.PortableServer.ID_ASSIGNMENT_POLICY_ID;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
// 使用 Druid 连接池
public class DruidTest2 {
	public static void main(String[] args) {
		// 1 创建连接池
		DruidDataSource dataSource = null;
		try {
			Properties properties = new Properties();
			InputStream is = DruidTest2.class.getClassLoader()
        .getResourceAsStream("database.properties");
			properties.load(is);
			is.close();
			// Druid 数据源工厂
			dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		// 4 使用
		for (int i = 0; i < 30; i++) {
			try {
				Connection con = dataSource.getConnection();
				System.out.println(con.getClass().getName());
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
```

##### 9.5 C3P0 与 Dbutils 一起使用

导入相应 jar 包

- mysql-connector-java-5.1.41-bin.jar（mysql 驱动包）
- c3p0-0.9.1.2.jar
- mchange-commons-java-0.2.11.jar
- commons-dbutils-1.6.jar

**c3p0-config.xml**

```xml
<?xml version="1.0" encoding="UTF-8"?>
<c3p0-config>
	<default-config>
		<property name="driverClass">com.mysql.jdbc.Driver</property>
		<property name="jdbcUrl">jdbc:mysql://localhost:3306/j1806</property>
		<property name="user">root</property>
		<property name="password">root</property>
		<property name="initialPoolSize">3</property>
		<property name="maxPoolSize">6</property>
		<property name="maxIdleTime">2000</property>
	</default-config>
</c3p0-config>
```

**JDBCUtils**

```java
import org.apache.commons.dbutils.QueryRunner;
import com.mchange.v2.c3p0.ComboPooledDataSource;
public class JDBCUtils {
	private static ComboPooledDataSource dataSource = null;
	static{
		dataSource = new ComboPooledDataSource();
	}
	// 获取 QueryRunner 对象
	public static QueryRunner getQueryRunner(){
		return new QueryRunner(dataSource);
	}
}
```

**DBTest**

```java
import java.sql.SQLException;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
public class DBTest {
	public static void main(String[] args) {
		QueryRunner queryRunner = JDBCUtils.getQueryRunner();
		try {
			// 增删改使用 update 方法
			String sql1 = "insert into t_employee(name, sex, age, phone) values(?, ?, ?, ?)";
			// update 方式一
			queryRunner.update(sql1, "zhangsan", "男", 20, "12345");
			// update 方式二
			Object[] params = new Object[]{"lisi", "女", 12, "232323"};
			queryRunner.update(sql1, params);
			// 查询使用 query 方法
			// 使用 BeanListHandler 查询一组数据放入列表
			String sql2 = "select * from t_employee";
			String sql3 = "select * from t_employee where id=?";
			List<Employee> list = queryRunner.query(sql2, new BeanListHandler<>(Employee.class));
			for (Employee employee : list) {
				System.out.println(employee.getName());
			}
			// 使用 BeanHandler 查询一个对象
			Employee employee = queryRunner.query(sql3, new BeanHandler<>(Employee.class), 1);
			System.out.println(employee.getName());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
```

**Employee**

```java
public class Employee {
	private Integer id;
	private String name;
	private String sex;
	private Integer age;
	private String phone;
	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public String getSex() { return sex; }
	public void setSex(String sex) { this.sex = sex; }
	public Integer getAge() { return age; }
	public void setAge(Integer age) { this.age = age; }
	public String getPhone() { return phone; }
	public void setPhone(String phone) { this.phone = phone; }
}
```

