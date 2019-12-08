package com.qianfeng.service.impl;

import java.util.List;

import com.qianfeng.dao.EmployeeDao;
import com.qianfeng.dao.impl.EmployeeDaoImpl;
import com.qianfeng.entity.Employee;
import com.qianfeng.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeDao empDao = new EmployeeDaoImpl();
	@Override
	public List<Employee> findAllEmployee() {
		// TODO Auto-generated method stub
		
		List<Employee> list = empDao.findAll();
		return list;
	}
	@Override
	public void addEmp(Employee emp) {
		// TODO Auto-generated method stub
		
		if(emp == null){
			throw new RuntimeException("员工对象为空，不能添加");
		}
		// 判断是否存在相同名字的员工，如果有，不能添加
		Employee emp2 = empDao.findByName(emp.getName());
		if(emp2 != null){
			throw new RuntimeException("存在同名员工，不能添加");
		}
		
		empDao.add(emp);
		
		
	}
	@Override
	public void updateEmp(Employee emp) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteEmpById(Integer id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Employee findEmpById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
