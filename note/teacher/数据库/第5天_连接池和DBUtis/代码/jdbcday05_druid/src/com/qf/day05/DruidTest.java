package com.qf.day05;

import java.sql.Connection;
import java.sql.SQLException;
import com.alibaba.druid.pool.DruidDataSource;

// 使用druid连接池
public class DruidTest {
	public static void main(String[] args) {
		// 1 创建连接池
		DruidDataSource dataSource = new DruidDataSource();
		// 2 调用方法设置
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/school");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		// 3 其他设置
		// 3.1 初始大小
		dataSource.setInitialSize(10);
		dataSource.setMaxActive(30);
		dataSource.setMinIdle(5);
		dataSource.setMaxWait(10000);
		// 4 使用
		for(int i = 0; i < 30; i++){
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
