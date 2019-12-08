package com.qianfeng.dao;

import java.util.List;

import com.qianfeng.entity.Employee;

public interface EmployeeDao {

	public List<Employee> findAll();
	
	public void add(Employee emp);
	
	public Employee findById(Integer id);
	
	public void update(Employee emp);
	
	public void deleteById(Integer id);
	
	public Employee findByName(String name);
}
