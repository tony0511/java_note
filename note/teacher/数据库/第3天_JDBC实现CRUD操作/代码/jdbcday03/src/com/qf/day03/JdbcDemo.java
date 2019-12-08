package com.qf.day03;

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
    PreparedStatement pstat = null; // sql 语句对象
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
			// pstat = connection.PreparedStatement("select * from user where username=? and password=?");
			// 给pstat设置参数
			// pstat.setString(1, "zhangsan");
			// pstat.setString(2, "123456");
      // 执行命令查询
      // rs = stat.executeQuery("select * from emp");
      rs = stat.executeQuery("select id, `name` from emp;");
      // rs = pstat.executeQuery();
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
