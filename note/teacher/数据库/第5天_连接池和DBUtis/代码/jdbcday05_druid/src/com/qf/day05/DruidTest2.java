package com.qf.day05;

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
			InputStream is = DruidTest2.class.getClassLoader().getResourceAsStream("database.properties");
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
