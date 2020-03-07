package com.ldf.mybatis.utils;


import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
  
  private static SqlSessionFactory sqlSessionFactory = null;
  
  static {
    try {
      InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
      sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
  // 做成单例
  private MyBatisUtil() {}
  
  public static SqlSession getSqlSession() {
    System.out.println("====");
    return sqlSessionFactory.openSession();
  }
  
}



