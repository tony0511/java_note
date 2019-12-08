package com.qf.day03;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class JdbcBatch2 {
  public static void main(String[] args) {
    Connection connection = null; // 连接对象
    PreparedStatement pstat = null; // sql 语句对象
    try {
      // === 2 注册驱动 ===
      Class.forName("com.mysql.cj.jdbc.Driver");
      // === 3 获取连接 ===
      String URL = "jdbc:mysql://localhost:3306/student"; // 简写 jdbc:mysql:///student
      String USER = "root";
      String PWD = "lalalala";
      connection = DriverManager.getConnection(URL, USER, PWD);
      // === 4 执行批处理(PreparedStatement) ===
      // 创建命令对象，? 为占位符，执行时会输入实际数据
      pstat = connection.PreparedStatement("insert into user(username,password,phone) values(?,?,?)");
      // 4.1 设置事务不自动提交(默认为 true，注：一般需要执行事务时才设置)
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
        connection.rollback(); // 回滚(撤消)
        connection.commit(); // 提交(可加可不加，最好是加上)
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
