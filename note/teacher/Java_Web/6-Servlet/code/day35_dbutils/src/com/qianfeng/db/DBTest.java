package com.qianfeng.db;

import java.sql.SQLException;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class DBTest {
	public static void main(String[] args) {
		QueryRunner queryRunner = JDBCUtils.getQueryRunner();
		try {
			// 增删改使用 update 方法
			String sql1 = "insert into t_employee(name, sex, age, phone) values(?, ?, ?, ?)";
			// update 方式一
			queryRunner.update(sql1, "zhangsan", "男", 20, "12345");
			// update 方式二
			Object[] params = new Object[]{"lisi", "女", 12, "232323"};
			queryRunner.update(sql1, params);
			// 查询使用 query 方法
			// 使用 BeanListHandler 查询一组数据放入列表
			String sql2 = "select * from t_employee";
			String sql3 = "select * from t_employee where id=?";
			List<Employee> list = queryRunner.query(sql2, new BeanListHandler<>(Employee.class));
			for (Employee employee : list) {
				System.out.println(employee.getName());
			}
			// 使用 BeanHandler 查询一个对象
			Employee employee = queryRunner.query(sql3, new BeanHandler<>(Employee.class), 1);
			System.out.println(employee.getName());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
