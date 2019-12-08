package com.qf.day04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * 隔离级别的演示
 * 1 脏读 
 * 李四
 */
public class JdbcDemo6 {
	public static void main(String[] args) {
		Connection connection=null;
		Statement stat1=null;
		ResultSet rs=null;
		//1注册驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//2获取连接
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "root");
			//2.1开启事务
			connection.setAutoCommit(false);
			//2.2修改隔离级别(读未提交的)
			connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
			//3创建命令
			stat1=connection.createStatement();
			//4执行
			rs=stat1.executeQuery("select * from account where name='李四'");
			
			if(rs.next()){
				double money=rs.getDouble("money");
				System.out.println("余额是:"+money);
			}
			
			connection.commit();
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}finally {
			if(stat1!=null){
				try {
					stat1.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(connection!=null){
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
