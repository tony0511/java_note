package com.qianfeng.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.qianfeng.dao.EmployeeDao;
import com.qianfeng.entity.Employee;
import com.qianfeng.utils.JDBCUtils;

public class EmployeeDaoImpl implements EmployeeDao{

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		
		QueryRunner queryRunner = JDBCUtils.getQueryRunner();
		String sql = "select * from t_employee";
		List<Employee> list = null;
		try {
			list = queryRunner.query(sql, new BeanListHandler<>(Employee.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		return list;
		
	}

	@Override
	public void add(Employee emp) {
		// TODO Auto-generated method stub
		
	}

}
