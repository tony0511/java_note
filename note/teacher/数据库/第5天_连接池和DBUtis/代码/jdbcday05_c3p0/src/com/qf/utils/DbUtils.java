package com.qf.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 数据库工具类
 * @author wgy
 * 1 注册驱动（一次）
 * 2 获取连接
 * 3 释放资源
 * 4 执行命令
 *
 */
public class DbUtils {
	//创建连接池
	private static ComboPooledDataSource dataSource;
	
	static{
		dataSource=new ComboPooledDataSource("myc3p0");
	}
	/**
	 * 获取连接
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection(){
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 关闭
	 * @param rs
	 * @param stat
	 * @param conn
	 */
	public static void closeAll(ResultSet rs,Statement stat,Connection conn){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(stat!=null){
			try {
				stat.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn!=null){
			
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	/**
	 * 执行命令 添加  删除  修改
	 * insert into emp (....) values( ?,?,?)
	 * delete from emp where empno=?
	 * update ....
	 */
	public static int executeUpdate(String sql, Object... params){
		//1获取连接
		Connection conn=null;
		//2创建命令对象
		PreparedStatement pstat=null;
		try {
			conn=getConnection();
			pstat=conn.prepareStatement(sql);
			for(int i=0;i<params.length;i++){
				pstat.setObject(i+1, params[i]);   //pstat.setInt(1,empno)
			}
			//3执行
			return pstat.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			closeAll(null, pstat, conn);
		}
		return 0;
		
	}
}
