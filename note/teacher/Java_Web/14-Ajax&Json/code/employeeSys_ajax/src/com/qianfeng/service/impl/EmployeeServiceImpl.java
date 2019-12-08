package com.qianfeng.service.impl;

import java.util.List;

import com.qianfeng.dao.EmployeeDao;
import com.qianfeng.dao.impl.EmployeeDaoImpl;
import com.qianfeng.entity.Employee;
import com.qianfeng.service.EmployeeService;
import com.qianfeng.vo.PageBean;

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
	@Override
	public PageBean<Employee> findEmpByPage(int page) {
		// TODO Auto-generated method stub
		
		PageBean<Employee> bean = new PageBean<>();
		// 计算分页时开始索引
		int index = (page - 1) * bean.getPageSize();
		List<Employee> empList = empDao.findByIndex(index, bean.getPageSize());
		
		bean.setEmpList(empList);
		
		bean.setCurrentPage(page);
		
		// 计算总页数
		int count = empDao.count();
		int totalPage = 0;
		if(count % bean.getPageSize() == 0){
			totalPage = count / bean.getPageSize();
		}else{
			totalPage = count / bean.getPageSize() + 1;
		}
		bean.setTotalPage(totalPage);
		
		return bean;
	}

}
