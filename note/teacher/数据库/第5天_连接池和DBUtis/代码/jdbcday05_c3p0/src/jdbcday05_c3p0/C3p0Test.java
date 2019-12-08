package jdbcday05_c3p0;

import java.sql.Connection;
import java.sql.SQLException;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3p0Test {
	public static void main(String[] args) {
		// 1 创建连接池
		// 默认 bin 找 c3p0-config.xml  c3p0-config.properties
		ComboPooledDataSource pool = new ComboPooledDataSource("myc3p0");
		// 2 使用
		for (int i = 0; i < 30; i++) {
			try {
				Connection conn = pool.getConnection();
				System.out.println(conn.getClass().getName());
				conn.close(); // 释放到连接池中
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
