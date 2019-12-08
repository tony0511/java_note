package com.qianfeng.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
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
		QueryRunner qr = JDBCUtils.getQueryRunner();
		String sql = "insert into t_employee(name,age,sex,phone) values(?,?,?,?)";
		Object[] params = new Object[]{emp.getName(),emp.getAge(),emp.getSex(),emp.getPhone()};
		try {
			qr.update(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Employee findById(Integer id) {
		// TODO Auto-generated method stub
		QueryRunner qr = JDBCUtils.getQueryRunner();
		String sql = "select * from t_employee where id=?";
		Employee emp = null;
		try {
			emp = qr.query(sql, new BeanHandler<>(Employee.class), id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return emp;
	}
	
	@Override
	public void update(Employee emp) {
		// TODO Auto-generated method stub
		QueryRunner qr = JDBCUtils.getQueryRunner();
		String sql = "update t_employee set name=?,age=?,sex=?,phone=? where id=?";
		Object[] params = new Object[]{
			emp.getName(),
			emp.getAge(),
			emp.getSex(),
			emp.getPhone(),
			emp.getId()
		};
		try {
			qr.update(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteById(Integer id) {
		QueryRunner qr = JDBCUtils.getQueryRunner();
		String sql = "delete from t_employee where id=?";
		try {
			qr.update(sql, id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
