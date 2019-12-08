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


/*
 * 实现 emp表的查询和添加
 */
public class JdbcDemo1 {
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
		//1注册驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//2获取连接
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "root");
			//3创建命令
			pstat=connection.prepareStatement("select * from emp;");
			//4执行命令，处理结果
			rs=pstat.executeQuery();
			while(rs.next()){
				int empno=rs.getInt("empno");
				String ename=rs.getString("ename");
				String job=rs.getString("job");
				int mgr=rs.getInt("mgr");
				Date hiredate=rs.getDate("hiredate");
				double sal=rs.getDouble("sal");
				double comm=rs.getDouble("comm");
				int deptno=rs.getInt("deptno");
				
				Employee emp=new Employee(empno, ename, job, mgr, hiredate, sal, comm, deptno);
				employees.add(emp);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(pstat!=null){
				try {
					pstat.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(connection!=null){
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		return employees;
		
	}
	
	/**
	 * 添加
	 */
	public static void add(){
		Connection conn=null;
		PreparedStatement pstat=null;
		//1注册驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//2获取连接
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "root");
			//3创建命令
			pstat=conn.prepareStatement("insert into emp(empno,ename,job,mgr,hiredate,sal,comm,deptno) values(?,?,?,?,?,?,?,?)");
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
			
			pstat.setInt(1, empno);
			pstat.setString(2, ename);
			pstat.setString(3, job);
			pstat.setInt(4, mgr);
			SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
			Date d=df.parse(hiredate);
			pstat.setDate(5,new java.sql.Date(d.getTime()));
			
			pstat.setDouble(6,sal);
			pstat.setDouble(7, comm);
			pstat.setInt(8, deptno);
			//4执行命令
			int result=pstat.executeUpdate();
			if(result>0){
				System.out.println("添加成功");
			}else{
				System.out.println("添加失败");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(pstat!=null){
				try {
					pstat.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 删除
	 */
	public static void delete(){
		Connection conn=null;
		PreparedStatement pstat=null;
		//1注册驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//2获取连接
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "root");
			//3创建命令
			pstat=conn.prepareStatement("delete from emp where empno=?");
			Scanner input=new Scanner(System.in);
			System.out.println("请输入要删除的员工编号");
			int empno=input.nextInt();
			pstat.setInt(1, empno);
			//4执行命令
			int result=pstat.executeUpdate();
			if(result>0){
				System.out.println("删除成功");
			}else{
				System.out.println("删除失败");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(pstat!=null){
				try {
					pstat.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
