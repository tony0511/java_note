package com.qf.day03;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcBatch1 {
  public static void main(String[] args) {
    Connection connection = null; // 连接对象
    Statement stat = null; // sql 语句对象
    try {
      // === 2 注册驱动 ===
      Class.forName("com.mysql.cj.jdbc.Driver");
      // === 3 获取连接 ===
      String URL = "jdbc:mysql://localhost:3306/student"; // 简写 jdbc:mysql:///student
      String USER = "root";
      String PWD = "lalalala";
      connection = DriverManager.getConnection(URL, USER, PWD);
      // === 4 执行批处理(Statement) ===
      // 缺点：1、每次都要添加sql语句，2、不能避免 SQL 注入
      stat = connection.createStatement();
      // 4.1 设置事务不自动提交(默认为 true)
      connection.setAutoCommit(false);
      for(int i = 1; i <= 100; i++){
        stat.addBatch("insert into user (username, password, phone) values('王五" + i + "','123456','18944123132')");
        if (i % 50 == 0) {
          int[] result = stat.executeBatch(); // 执行批处理
          stat.clearBatch(); // 清空批处理
        }
      }
      // 4.2 提交事务
      connection.commit();
    } catch (Exception e) {
      try {
        connection.rollback(); // 回滚(撤消)
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
