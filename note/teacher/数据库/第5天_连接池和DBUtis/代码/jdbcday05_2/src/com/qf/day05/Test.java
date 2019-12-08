package com.qf.day05;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import com.qf.dao.EmployeeDao;
import com.qf.dao.impl.EmployeeDaoImpl;
import com.qf.domain.Employee;

public class Test {
	public static void main(String[] args) {
		System.out.println("请选择操作 : 1 查询  2添加 3更新 4删除");
		Scanner input = new Scanner(System.in);
		int choice = input.nextInt();
		EmployeeDao employeeDao = new EmployeeDaoImpl();
		switch (choice) {
			case 1:
				List<Employee> employees = employeeDao.findAll();
				for (Employee e : employees) {
					System.out.println(e.toString());
				}
			break;
			case 2:
				System.out.println("请输入员工编号");
				int empno = input.nextInt();
				System.out.println("请输入员工姓名");
				String ename = input.next();
				System.out.println("请输入员工工作");
				String job = input.next();
				System.out.println("请输入员工经理编号");
				int mgr = input.nextInt();
				System.out.println("请输入员工入职时间");
				String hiredate = input.next();
				System.out.println("请输入员工工资");
				double sal = input.nextDouble();
				System.out.println("请输入员工奖金");
				double comm = input.nextDouble();
				System.out.println("请输入员工部门");
				int deptno = input.nextInt();
				// 1 封装成一个Employee对象
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				try {
					Employee e = new Employee(empno, ename, job, mgr,sdf.parse(hiredate), sal, comm, deptno);
					employeeDao.add(e);
					System.out.println("添加成功");
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			break;
		case 3:
			System.out.println("请输入要更新的员工编号:");
			int eno = input.nextInt();
			Employee employee = employeeDao.findByNo(eno);
			if (employee != null) {
				System.out.println("请输入新的名字");
				String newname = input.next();
				employee.setEname(newname);
				// 修改数据库
				employeeDao.update(employee);
				System.out.println("修改成功");
			} else {
				System.out.println("没有要修改的员工");
			}
			break;
		case 4:
			System.out.println("请输入要删除的编号");
			int no = input.nextInt();
			employeeDao.delete(no);
			System.out.println("删除成功");
			break;
		default:
			break;
		}
	}
}
