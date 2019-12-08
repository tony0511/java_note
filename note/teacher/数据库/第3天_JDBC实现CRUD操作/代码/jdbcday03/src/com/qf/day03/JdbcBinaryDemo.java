package com.qf.day04;

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
