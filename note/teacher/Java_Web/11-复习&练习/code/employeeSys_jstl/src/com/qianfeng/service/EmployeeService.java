package com.qianfeng.service;

import java.util.List;

import com.qianfeng.entity.Employee;
import com.qianfeng.vo.PageBean;

// 业务层定义的方法名根据功能指定
public interface EmployeeService {

	public List<Employee> findAllEmployee();
	
	public void addEmp(Employee emp);
	
	public void updateEmp(Employee emp);
	
	public void deleteEmpById(Integer id);
	
	public Employee findEmpById(Integer id);
	
	public PageBean<Employee> findEmpByPage(int page);
	
}
