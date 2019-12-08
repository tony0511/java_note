package com.qf.day05;

import java.sql.Connection;
import java.sql.SQLException;
import com.qf.utils.MyPool;

public class TestPool {
	public static void main(String[] args) {
		MyPool myPool = new MyPool();
		for (int i = 0; i < 5; i++) {
			try {
				Connection conn = myPool.getConnection();
				System.out.println(conn.getClass().getName());
				System.out.println("使用:" + conn.hashCode() + "..." + conn.getClass().getName());
				myPool.release(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
