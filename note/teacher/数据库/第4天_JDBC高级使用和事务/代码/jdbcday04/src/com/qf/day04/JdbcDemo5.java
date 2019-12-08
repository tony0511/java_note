package com.qf.day04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

/*
 * 隔离级别的演示
 * 1 脏读 
 * 张三
 */
public class JdbcDemo5 {
	public static void main(String[] args) {
		Connection connection=null;
		Statement stat1=null;
		Savepoint savepoint=null;//保存点
		//1注册驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//2获取连接
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "root");
			//2.1开启事务
			connection.setAutoCommit(false);
			savepoint=connection.setSavepoint("save1");
			//3创建命令
			stat1=connection.createStatement();
			//4执行
			stat1.executeUpdate("update account set money=money-1000 where name='张三'");
		
			int a=10/0;
			stat1.executeUpdate("update account set money=money+1000 where name='李四'");
	
			connection.commit();
		} catch (Exception e) {
			try {
				//connection.rollback(); //回滚到事务最开始状态
				connection.rollback(savepoint);
				connection.commit();
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
