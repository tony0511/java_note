### DAO模式、连接池和DBUtils应用



#### 课程回顾

```
1、批处理
	 Statement
         addBatch(Sql);
         executeBath();
         clearBath();
     PreparedStatement 
         addBatch();
         executeBath();
         clearBath();
2、事务
	把一组操作当成整体，不能分割，全部执行成功，都不执行。
	原子性: 不能分割
	一致性：事务执行前和执行后数据保持一致
	隔离性: 事务与事务之间的隔离 
	持久性：事务提交，数据就永久保存，不能再更改。
	
3、jdbc操作事务
     0  导入驱动包
	1 注册驱动
	2 获取连接
    	//开启事务   connection.setAutoCommit(false);
	3 创建命令
	4 执行命令处理结果
		//提交     connection.commit();
		//异常     connection.rollback();
			      connection.commit();
	5 释放资源
4 保存点  SavePoint  	
```

#### 今日内容

```
1、数据库工具类封装
2、DAO模式
3、使用DBCP连接池
4、使用C3P0连接池
5、使用Druid连接池
6、DbUtils的使用
```

#### 教学目标

```
1、掌握工具类的封装
2、掌握DAO设计模式
3、了解DBCP连接池
4、掌握C3P0连接池的使用
5、掌握Druid连接池的使用
6、掌握DbUtils的使用
```

#### 第十五章 工具类封装、DAO模式和自定义连接池

##### 1.1 工具类封装

案例实现，实现emp表的查询、添加、删除、修改

**1.1.1 封装DbUtils**

由于多个地方都需要使用数据库连接和释放，所以把功能封装到工具类中DbUtils

```java
public class DbUtils {
	private static String driver;
	private static String url;
	private static String user;
	private static String password;

	static{
	
		try {			
			driver="com.mysql.jdbc.Driver";
          	 url="jdbc:mysql://localhost:3306/school";
          	 user="root";
          	 password="root";
			//加载驱动
			Class.forName(driver);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	/**
	 * 获取连接
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url,user,password);
	}
	
	/**
	 * 释放资源
	 * @param rs
	 * @param stat
	 * @param conn
	 */
	public static void release(ResultSet rs,Statement stat,Connection conn){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(stat!=null){
			try {
				stat.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * 根据参数执行sql语句  Insert Delete Update
	 * @param sql
	 * @param params
	 * @return
	 */
	public static int executeUpdate(String sql, Object...params){
		Connection conn=null;
		PreparedStatement pstat=null;
		try {
			//1创建连接
			conn=getConnection();
			//2创建命令对象
			pstat=conn.prepareStatement(sql);
			//3设置参数
			for (int i = 0; i < params.length; i++) {
				pstat.setObject(i+1, params[i]);
			}
			//4执行
			int result=pstat.executeUpdate();
			return result;
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally {
			release(null, pstat, conn);
		}
	}
	
}
```

**1.1.2优化DbUtils工具类：把数据库连接信息封装到Properties文件中**

```java
			Properties properties=new Properties();
			InputStream is=DbUtils.class.getClassLoader().getResourceAsStream("database.properties");
			properties.load(is);
			//初始化参数
			driver=properties.getProperty("driver");
			url=properties.getProperty("url");
			user=properties.getProperty("user");
			password=properties.getProperty("password");
```

##### 1.2 DAO设计模式

DAO(Database Access Object 数据库访问对象)

为了降低耦合性，提出了DAO封装数据库操作的设计模式。

它可以实现业务逻辑与数据库访问相分离。相对来说，数据库是比较稳定的，其中DAO组件依赖于数据库系统，提供数据库访问的接口。

隔离了不同的数据库实现。

DAO模式的组成部分

​	1 DAO接口（主要 添加 修改 更新 删除方法）

​	2 DAO实现类

​	3 实体类  （domain、beans、entity、pojo、model）

​		--作用：用在数据访问代码和业务逻辑代码之间通过实体类来传输数据

​		--实体类特征：

​			◦属性一般使用private修饰

​			◦提供public修饰的getter/setter方法

​			◦实体类提供无参构造方法，根据业务提供有参构造

​			◦实现java.io.Serializable接口，支持序列化机制

​	4 数据库连接和关闭工具类

设计的包名 :

   domain 存放实体类

   utils  存放工具类

   dao  存放接口

   dao.impl  存放实现类

使用DAO设计模式重构上一个案例

Employee类

```java
/**
 * 员工类
 * 实体类
 * @author wgy
 *
 */
public class Employee implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 373910607014836778L;
	private int empno;
	private String ename;
	private String job;
	private int mgr;
	private Date hiredate;
	private double sal;
	private double comm;
	private int deptno;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(int empno, String ename, String job, int mgr, Date hiredate, double sal, double comm, int deptno) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.mgr = mgr;
		this.hiredate = hiredate;
		this.sal = sal;
		this.comm = comm;
		this.deptno = deptno;
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getMgr() {
		return mgr;
	}

	public void setMgr(int mgr) {
		this.mgr = mgr;
	}

	public Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	public double getSal() {
		return sal;
	}

	public void setSal(double sal) {
		this.sal = sal;
	}

	public double getComm() {
		return comm;
	}

	public void setComm(double comm) {
		this.comm = comm;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	@Override
	public String toString() {
		return "Employee [empno=" + empno + ", ename=" + ename + ", job=" + job + ", mgr=" + mgr + ", hiredate="
				+ hiredate + ", sal=" + sal + ", comm=" + comm + ", deptno=" + deptno + "]";
	}
	
}
```

接口：

```java
public interface EmployeeDao {
	
	 //1查询
	 List<Employee> findAll();
	 //2更新
	 void update(Employee e);
	 //3删除
	 void delete(int empno);
	 //4添加
	 void add(Employee e);
	 
	
}
```

实现类

```java
public class EmployeeDaoImpl implements EmployeeDao{

	@Override
	public List<Employee> findAll() {
		
		ArrayList<Employee> employees=new ArrayList<Employee>();
		//1获取连接
		Connection conn=null;
		PreparedStatement pstat=null;
		ResultSet rs=null;
		try {
			conn=DbUtils.getConnection();
			pstat=conn.prepareStatement("select * from emp;");
			rs=pstat.executeQuery();
			while(rs.next()){
				int empno=rs.getInt("empno");
				String ename=rs.getString("ename");
				String job=rs.getString("job");
				int mgr=rs.getInt("mgr");
				Date date=rs.getDate("hiredate");
				double sal=rs.getDouble("sal");
				double comm=rs.getDouble("comm");
				int deptno=rs.getInt("deptno");
				
				Employee employee=new Employee(empno, ename, job, mgr, date, sal, comm, deptno);
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
		Object[] params={e.getEname(),e.getJob(),e.getMgr(),e.getHiredate(),e.getSal(),e.getComm(),e.getDeptno(),e.getEmpno()};
		DbUtils.executeUpdate("update emp set ename=?,job=?,mgr=?,hiredate=?,sal=?,comm=?,deptno=? where empno=?", params);
	}

	@Override
	public void delete(int empno) {
		DbUtils.executeUpdate("delete from emp where empno=?", empno);
	}

	@Override
	public void add(Employee e) {
		Object[] params={e.getEmpno(),e.getEname(),e.getJob(),e.getMgr(),e.getHiredate(),e.getSal(),e.getComm(),e.getDeptno()};
		DbUtils.executeUpdate("insert into emp values(?,?,?,?,?,?,?,?)", params);
	}

}
```



##### 1.3 自定义实现连接池

为什么要使用连接池：

​	用户每次请求都需要向数据库获得链接，而数据库创建连接通常需要消耗相对较大的资源，创建时间也较长。假设网站一天10万访问量，数据库服务器就需要创建10万次连接，极大的浪费数据库的资源，并且极易造成数据库服务器内存溢出、拓机。

Java为连接池实现提供了一个规范(接口),规范的写法,我们需要实现DataSource接口!

```java
/**
 * 连接池
 * @author wgy
 *
 */
public class MyDbPool implements DataSource{
	

	//创建集合 并且线程安全
	public static List<Connection>  connctions=Collections.synchronizedList(new LinkedList<Connection>()) ;
	
	static{
		try {
			InputStream is=MyDbPool.class.getClassLoader().getResourceAsStream("database.properties");
			Properties properties=new Properties();
			properties.load(is);

			String driver=properties.getProperty("driver");
			String url=properties.getProperty("url");
			String user=properties.getProperty("user");
			String password=properties.getProperty("password");
			//1加载驱动
			Class.forName(driver);
			
			for(int i=0;i<5;i++){
				Connection connection=DriverManager.getConnection(url, user, password);
				connctions.add(connection);
				System.out.println(i+"....."+connection.hashCode());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Override
	public Connection getConnection() throws SQLException {
		// TODO Auto-generated method stub
		Connection connection=connctions.remove(0);
		System.out.println("获取一个连接.."+connection.hashCode());
		System.out.println("池中还剩"+connctions.size());
		return connection;
	}
	
	

	@Override
	public Connection getConnection(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 把连接再放入池中
	 * @param conn
	 */
	public void release(Connection conn){
		connctions.add(conn);
		System.out.println("放入了一个连接"+conn.hashCode());
		System.out.println("池中还剩"+connctions.size());
	}
	

	@Override
	public PrintWriter getLogWriter() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLoginTimeout(int seconds) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}
}
```



#### 第十六章 DBCP连接池

>  DBCP(DataBase connection pool),[数据库连接池]。是 apache 上的一个 java 连接池项目，也是 tomcat 使用的连接池组件。单独使用dbcp需要2个包：commons-dbcp.jar,commons-pool.jar由于建立数据库连接是一个非常耗时的行为，所以通过连接池预先同数据库建立一些连接，放在内存中，应用程序需要建立数据库连接时直接到连接池中申请一个就行，用完后再放回去。

#####16.1 DBCP连接池的使用

###### 16.1.1 创建项目

创建JavaWeb项目

###### 16.1.2 导入相应jar包

​	mysql驱动包

​	commons-dbcp.jar

​        commons-pool.jar

​        logging.jar 日志支持

###### 16.1.3 硬编码使用DBCP

> 所谓的硬编码方式就是在代码中添加配置

```java
@Test
public void testHard() throws SQLException{
		//TODO 硬编码 使用DBCP连接池子
		BasicDataSource source = new BasicDataSource();
		//设置连接的信息  
		source.setDriverClassName("com.mysql.jdbc.Driver");
		source.setUrl("jdbc:mysql://localhost:3306/day2");
		source.setUsername("root");
		source.setPassword("111");
		
		Connection connection = source.getConnection();
		
		String sql = "select * from student";
		
		Statement createStatement = connection.createStatement();
		
		ResultSet executeQuery = createStatement.executeQuery(sql);
		
		while (executeQuery.next()) {
			 
			System.out.println(executeQuery.getString(2));
		}
		connection.close(); //回收
	}
```

###### 16.1.4 软编码使用DBCP

> 所谓的软编码,就是在项目中添加配置文件,这样就不需要每次代码中添加配合!

1. 项目中添加配置

​       文件名称: dbcp.properties

​       文件位置: src下

```
#连接设置
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

1. 代码实现

```java
	@Test
	public void testSoft() throws Exception{
		//TODO DBCP软编码连接池子使用
		BasicDataSourceFactory factory = new BasicDataSourceFactory();
		Properties properties = new  Properties();
		//配置文件添加到properties对象中  javase
		properties.load(new FileInputStream("src/info.properties"));
		//生成连接池子  需要配置文件
		DataSource source = factory.createDataSource(properties);
        Connection connection = source.getConnection();
		String sql = "select * from student";
		Statement createStatement = connection.createStatement();
		ResultSet executeQuery = createStatement.executeQuery(sql);
		while (executeQuery.next()) {
			System.out.println(executeQuery.getString(2));
		}
		connection.close(); //回收
	}
```



#### 第十七章 C3P0连接池

>    C3P0是一个开源的JDBC连接池，它实现了数据源和JNDI绑定，支持JDBC3规范和JDBC2的标准扩展。目前使用它的开源项目有Hibernate，Spring等。

	c3p0与dbcp区别
		 1.
			dbcp没有自动回收空闲连接的功能
			c3p0有自动回收空闲连接功能
		 2. 
		 	dbcp需要手动设置配置文件
		    c3p0不需要手动设置

##### 17.1 使用步骤

###### 17.1.1 创建项目

###### 17.1.2 导入jar包

​    c3p0-0.9.1.2.jar

​    mysql驱动包

###### 17.1.3.添加配置文件

> c3p0是在外部添加配置文件,工具直接进行应用,因为直接引用,所以要求固定的命名和文件位置

文件位置: src 

文件命名:c3p0-config.xml/c3p0-config.properties

```xml
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
	<named-config name="zhaowf">
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

注意: c3p0的配置文件内部可以包含命名配置文件和默认配置文件!默认是选择默认配置!如果需要切换命名配置可以在创建c3p0连接池的时候填入命名即可!

###### 17.1.4 c3p0进行数据库操作

```java
public class TestC3p0 {
  
	public static void main(String[] args) throws Exception {
      	//创建ComboPooledDataSource对象使用默认配置
		ComboPooledDataSource  dataSource = new ComboPooledDataSource();
		//1.创建C3P0连接池子
		Connection connection = dataSource.getConnection();
		
		Statement createStatement = connection.createStatement();
		
		String sql = "select * from student;";
		
		ResultSet resultSet = createStatement.executeQuery(sql);
		
		while (resultSet.next()) {
			
			System.out.println(resultSet.getString(1));
		}
		resultSet.close();
      	createStatement.close();
      	connection.close();
      
    }	
}
```



#### 第十八章 Druid连接池

```
Druid 是目前比较流行的高性能的，分布式列存储的OLAP框架(具体来说是MOLAP)。它有如下几个特点：
一. 亚秒级查询
     druid提供了快速的聚合能力以及亚秒级的OLAP查询能力，多租户的设计，是面向用户分析应用的理想方式。
二.实时数据注入
     druid支持流数据的注入，并提供了数据的事件驱动，保证在实时和离线环境下事件的实效性和统一性
三.可扩展的PB级存储
     druid集群可以很方便的扩容到PB的数据量，每秒百万级别的数据注入。即便在加大数据规模的情况下，也能保证时其效性
四.多环境部署
     druid既可以运行在商业的硬件上，也可以运行在云上。它可以从多种数据系统中注入数据，包括hadoop，spark，kafka，storm和samza等
五.丰富的社区
     druid拥有丰富的社区，供大家学习
```

##### 18.1 使用步骤

###### 18.1.1 导入jar包

###### 18.1.2 编写工具类

```java
 /**
 * 阿里的数据库连接池
 * 性能最好的
 * Druid
 * */
public class DruidUtils {
	//声明连接池对象
	private static DruidDataSource ds;
	static{
		///实例化数据库连接池对象
		ds=new DruidDataSource();
		//实例化配置对象
		Properties properties=new Properties();
		try {
			//加载配置文件内容
              properties.load(DruidUtils.class.getResourceAsStream("database.properties"));
              dataSource = (DruidDataSource)DruidDataSourceFactory.createDataSource(properties);	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//获取连接对象
	public static Connection getConnection() {
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}	
}
```

###### 18.1.3 测试

```java
public class Druid_Test{
    @Test
    public void test1(){
  		findAll();
  		find("小千千","47983");
	}
	public List<Master> findAll() {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstat=null;
		ResultSet rs=null;
		List<Master> masters=new ArrayList<Master>();
		try{
			conn=DruidUtils.getConnection();
			pstat=conn.prepareStatement("select * from master");
			rs=pstat.executeQuery();
			while(rs.next()){
				int id=rs.getInt("id");
				String name=rs.getString("name");
				String password=rs.getString("password");
				int money=rs.getInt("money");
				masters.add(new Master(id, name, password, money));
			}
			return masters;
		}catch(Exception e){
			throw new RuntimeException(e);
		}finally {
			DbUtils.release(rs, pstat, conn);
		}
	}
	public Master find(String name, String password) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstat=null;
		ResultSet rs=null;
		Master master=null;
		try{
			conn=DbUtils.getConnection();
			pstat=conn.prepareStatement("select * from master where name=? and password=?");
			pstat.setString(1, name);
			pstat.setString(2, password);
			rs=pstat.executeQuery();
			if(rs.next()){
				int id=rs.getInt("id");
				int money=rs.getInt("money");
				master=new Master(id, name, password, money);
			}
			return master;
		}catch(Exception e){
			throw new RuntimeException(e);
		}finally {
			DbUtils.release(rs, pstat, conn);
		}	
	}
```



#### 第十九章  DBUtils使用

> Commons DbUtils是[Apache](https://baike.baidu.com/item/Apache/8512995)组织提供的一个对[JDBC](https://baike.baidu.com/item/JDBC)进行简单封装的开源工具类库，使用它能够简化[JDBC](https://baike.baidu.com/item/JDBC)应用程序的开发，同时也不会影响程序的性能。

##### 19.1 DBUtils简介

DBUtils是java编程中的数据库操作实用工具，小巧简单实用，

1.对于数据表的读操作，可以把结果转换成List，Array，Set等java集合，便于程序员操作。

2.对于数据表的写操作，也变得很简单（只需写sql语句）。

**DBUtils包括主要类**

DbUtils类：启动类

ResultSetHandler接口：转换类型接口

​	--ArrayHandler类：实现类，把记录转化成数组

​	--BeanHandler类：实现类,把记录转成对象。

​	--BeanListHandler类：实现类，把记录转化成List，使记录为JavaBean类型的对象

QueryRunner类：执行SQL语句的类



##### 19.2 DBUtils工具类封装

###### 19.2.1 项目准备

* 创建项目
* 导入jar包 工具类 配置文件

​      commons-dbutils-1.6.jar

​      druid连接池

​     database.properties配置文件

​      druid工具类

###### 19.2.2 实现代码

```java
public class ResultHanlder {

	@Test
	public void testArrayHander() throws SQLException {

		// ArrayHandler:适合取1条记录。把该条记录的每列值封装到一个数组中Object[]
		QueryRunner runner = new QueryRunner(C3P0Util.getDataSource());

		Object[] query = runner.query("select * from school where empno = ?", new ArrayHandler(), 1234);

		for (Object object : query) {

			System.out.println(object);
		}

	}

	@Test
	public void testArrayListHander() throws SQLException {

		// ArrayHandler:适合取1条记录。把该条记录的每列值封装到一个数组中Object[]
		QueryRunner runner = new QueryRunner(C3P0Util.getDataSource());

		List<Object[]> query = runner.query("select * from emp ", new ArrayListHandler());

		for (Object[] objects : query) {
			for (Object object : objects) {

				System.out.println(object);
			}
		}

	}

	@Test
	public void testColumnListHander() throws SQLException {

		// ColumnListHandler:取某一列的数据。封装到List中。
		QueryRunner runner = new QueryRunner(C3P0Util.getDataSource());

		List<Object> query = runner.query("select * from emp ", new ColumnListHandler<Object>(2));

		for (Object objects : query) {

			System.out.println(objects);
		}

	}


	@Test
	public void testMapHandler() throws SQLException {

		// MapHandler:适合取1条记录。把当前记录的列名和列值放到一个Map中
		QueryRunner runner = new QueryRunner(C3P0Util.getDataSource());

		Map<String, Object> query = runner.query("select * from emp where empno=1234 ", new MapHandler());

		for (Entry<String, Object> entry : query.entrySet()) {
			System.out.println("key:" + entry.getKey() + "  values:" + entry.getValue());
		}

	}


	@Test
	public void testScalarHandler() throws SQLException {

		// ScalarHandler:适合取单行单列数据
		QueryRunner runner = new QueryRunner(C3P0Util.getDataSource());

		Object query = runner.query("select count(*) from emp ", new ScalarHandler());
		System.out.println(query);
	}

	@Test
	public void testBeanHandler() throws SQLException {
		// BeanHandler:适合取单行单列数据
		QueryRunner runner = new QueryRunner(C3P0Util.getDataSource());
		Employee query = runner.query("select * from emp where empno=1234 ", new BeanHandler<Employee>(Employee.class));
		System.out.println(query.toString());
	}
  
  @Test
	public void testBeanListHandler() throws SQLException {
		// BeanHandler:适合取多行多列数据
		QueryRunner runner = new QueryRunner(C3P0Util.getDataSource());
		List<Employee> query2 = runner.query("select * from emp", new BeanListHandler<Employee>(Employee.class));
		for (Employee employee : query2) {
			System.out.println(employee);
		}
	}
}
```

#### 总结



#### 作业题

```
1、使用数据库连接池和DbUtils改造之前的案例
```

####   面试题

```
1、描述数据库连接池的优缺点
```

