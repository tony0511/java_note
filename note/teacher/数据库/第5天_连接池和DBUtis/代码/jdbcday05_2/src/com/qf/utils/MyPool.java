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

// 自定义连接池
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
	public Connection getConnection(String username, String password) throws SQLException { return null; }
}
