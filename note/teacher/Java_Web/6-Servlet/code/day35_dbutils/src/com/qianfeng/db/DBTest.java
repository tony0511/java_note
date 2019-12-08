package com.qianfeng.db;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class DBTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		QueryRunner queryRunner = JDBCUtils.getQueryRunner();
		//String sql = "insert into t_employee(name,sex,age,phone) values(?,?,?,?)";
//		String sql = "select * from t_employee";
		String sql = "select * from t_employee where id=?";
		
		
		try {
			// 增删改使用update方法
			//queryRunner.update(sql, "zhangsan", "男", 20, "12345");
			
//			Object[] params = new Object[]{"lisi", "女", 12, "232323"};
//			queryRunner.update(sql, params);
			
			// 查询的数据，放入列表，BeanListHandler
//			List<Employee> list = queryRunner.query(sql, new BeanListHandler<>(Employee.class));
//			for (Employee employee : list) {
//				System.out.println(employee.getName());
//				
//			}
			
			// 查询一个对象
			Employee employee = queryRunner.query(sql, new BeanHandler<>(Employee.class), 1);
			System.out.println(employee.getName());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
