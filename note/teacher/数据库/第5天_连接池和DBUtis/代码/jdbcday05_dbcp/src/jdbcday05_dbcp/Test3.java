package jdbcday05_dbcp;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.DelegatingConnection;

public class Test3 {
	public static void main(String[] args) {
		// 1 创建连接池
		BasicDataSource pool = new BasicDataSource();
		// 2 设置参数 4个参数
		pool.setDriverClassName("com.mysql.jdbc.Driver");
		pool.setUrl("jdbc:mysql://localhost:3306/school");
		pool.setUsername("root");
		pool.setPassword("root");
		// 设置初始大小
		pool.setInitialSize(5);
		// 设置最大大小
		pool.setMaxTotal(20);
		// 设置最大空闲
		pool.setMaxIdle(10);
		// 设置最小空闲
		pool.setMinIdle(5);
		// 超时时间
		pool.setMaxWaitMillis(10000);
		HashSet<Integer> integers = new HashSet<Integer>();
		for (int i = 0; i < 30; i++) {
			new Thread(){
				public void run() {
					try {
						Connection conn = pool.getConnection();
						DelegatingConnection delegate = (DelegatingConnection) conn;
						Connection realConn = delegate.getInnermostDelegateInternal();
						// System.out.println(conn.getClass().getName());
						System.out.println(realConn.hashCode());
						integers.add(realConn.hashCode());
						conn.close(); // 释放到连接池中
					} catch (SQLException e) {
						e.printStackTrace();
					}
				};
			}.start();
		}
		System.out.println(integers.size());
	}
}
