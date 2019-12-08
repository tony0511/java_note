package com.qf.day05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.qf.day05.utils.DbUtils;


/*
 * 实现 emp表的查询和添加
 */
public class JdbcDemo3 {
	public static void main(String[] args) {
		System.out.println("-------欢迎进入xxx系统--------");
		System.out.println("请选择 1 查询   2 添加  3 更新  4 删除");
		Scanner input = new Scanner(System.in);
		int choice = input.nextInt();
		switch (choice) {
		case 1:
				//查询
				ArrayList<Employee> employees=select();
				for (Employee e : employees) {
					System.out.println(e.toString());
				}
			break;
		case 2:
				//添加
				add();
			break;
		case 3:

			break;
		case 4:

			break;

		default:
			System.out.println("输入有误");
			break;
		}
	}
	
	/**
	 * 查询员工
	 */
	public static ArrayList<Employee> select(){	
		ArrayList<Employee> employees=new ArrayList<Employee>();
		Connection connection=null;
		PreparedStatement pstat=null;
		ResultSet rs=null;
		try {
			 connection = DbUtils.getConnection();
			 pstat = connection.prepareStatement("select * from emp;");
			 rs = pstat.executeQuery();
			while (rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int mgr = rs.getInt("mgr");
				Date hiredate = rs.getDate("hiredate");
				double sal = rs.getDouble("sal");
				double comm = rs.getDouble("comm");
				int deptno = rs.getInt("deptno");

				Employee emp = new Employee(empno, ename, job, mgr, hiredate, sal, comm, deptno);
				employees.add(emp);
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbUtils.closeAll(rs, pstat, connection);
		}
		return employees;
		
	}
	
	/**
	 * 添加
	 */
	public static void add(){
			Scanner input=new Scanner(System.in);
			System.out.println("请输入员工编号");
			int empno=input.nextInt();
			System.out.println("请输入员工姓名");
			String ename=input.next();
			System.out.println("请输入员工工作");
			String job=input.next();
			System.out.println("请输入员工经理编号");
			int mgr=input.nextInt();
			System.out.println("请输入员工入职时间");
			String hiredate=input.next();
			System.out.println("请输入员工工资");
			double sal=input.nextDouble();
			System.out.println("请输入员工奖金");
			double comm=input.nextDouble();
			System.out.println("请输入员工部门");
			int deptno=input.nextInt();
			//执行数据库操作
			Object[] params={empno,ename,job,mgr,hiredate,sal,comm,deptno};
			DbUtils.executeUpdate("insert into emp(empno,ename,job,mgr,hiredate,sal,comm,deptno) values(?,?,?,?,?,?,?,?)", params);
	}
	
	/**
	 * 删除
	 */
	public static void delete(){ //delete from emp where empno=?
		
			Scanner input=new Scanner(System.in);
			System.out.println("请输入要删除的员工编号");
			int empno=input.nextInt();
			DbUtils.executeUpdate("delete from emp where empno=?", empno);
		
		
	}
}
