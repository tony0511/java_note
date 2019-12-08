package com.qf.dao;

import java.util.List;
import com.qf.domain.Employee;

// 接口
public interface EmployeeDao {
	 // 1查询所有
	 List<Employee> findAll();
	 // 根据编号查询员工
	 Employee findByNo(int empno);
	 // 2 更新
	 void update(Employee e);
	 // 3 删除
	 void delete(int empno);
	 // 4 添加
	 void add(Employee e);
}
