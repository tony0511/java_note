package com.qianfeng.dao;

import java.util.List;

import com.qianfeng.entity.Employee;

public interface EmployeeDao {

	public List<Employee> findAll();
	
	public void add(Employee emp);
	
	
}
