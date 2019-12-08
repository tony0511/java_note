package com.qianfeng.utils;

import org.apache.commons.dbutils.QueryRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtils {

	private static ComboPooledDataSource dataSource = null;
	
	static{
		dataSource = new ComboPooledDataSource();
	}
	
	// 获取QueryRunner对象
	public static QueryRunner getQueryRunner(){
		return new QueryRunner(dataSource);
	}
	
}
