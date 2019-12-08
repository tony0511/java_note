package com.qf.day04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/*
 * 事务四个特性
 * 1 原子性 A
 * 2 一致性 C
 * 3 隔离性 I   事务与事务之间
 * 4 持久性 D
 */
public class JdbcDemo4 {
	public static void main(String[] args) {
		Connection connection=null;
		PreparedStatement pstat1=null;
		PreparedStatement pstat2=null;
		
		//1注册驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//2获取连接
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "root");
			//3创建命令
			//3.1开启事务 ，设置事务自动提交为false
			connection.setAutoCommit(false);
			pstat1=connection.prepareStatement("update account set money=money-1000 where name='张莎强'");
			pstat1.executeUpdate();
			//int c=10/0;
			pstat2=connection.prepareStatement("update account set money=money+1000 where name='小苍'");
			pstat2.executeUpdate();
			
			System.out.println("转账成功...");
			//3.2提交事务
			connection.commit();
			
		} catch (Exception e) {
			System.out.println("出现异常");
			try {
				connection.rollback();//出现问题，要回滚(撤销事务做过的修改)
				connection.commit();//可加也不不加
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally {
			if(pstat1!=null){
				try {
					pstat1.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(pstat2!=null){
				try {
					pstat2.close();
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
