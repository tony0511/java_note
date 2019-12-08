package com.qf.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.qf.dao.EmployeeDao;
import com.qf.domain.Employee;
import com.qf.utils.DbUtils;

public class EmployeeDaoImpl implements EmployeeDao {
	@Override
	public List<Employee> findAll() {
		ArrayList<Employee> employees = new ArrayList<Employee>();
		// 1 获取连接
		Connection conn = null;
		PreparedStatement pstat = null;
		ResultSet rs = null;
		try {
			conn = DbUtils.getConnection();
			pstat = conn.prepareStatement("select * from emp;");
			rs = pstat.executeQuery();
			while(rs.next()){
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int mgr = rs.getInt("mgr");
				Date date = rs.getDate("hiredate");
				double sal = rs.getDouble("sal");
				double comm = rs.getDouble("comm");
				int deptno = rs.getInt("deptno");
				Employee employee = new Employee(empno, ename, job, mgr, date, sal, comm, deptno);
				employees.add(employee);
			}
			return employees;
		} catch (Exception e) {
			throw new RuntimeException("查询emp失败");
		} finally {
			DbUtils.closeAll(rs, pstat, conn);
		}
	}
	@Override
	public void update(Employee e) {
		Object[] params = {e.getEname(),e.getJob(),e.getMgr(),e.getHiredate(),e.getSal(),e.getComm(),e.getDeptno(),e.getEmpno()};
		DbUtils.executeUpdate("update emp set ename=?,job=?,mgr=?,hiredate=?,sal=?,comm=?,deptno=? where empno=?", params);
	}
	@Override
	public void delete(int empno) {
		DbUtils.executeUpdate("delete from emp where empno=?", empno);
	}
	@Override
	public void add(Employee e) {
		Object[] params = {e.getEmpno(),e.getEname(),e.getJob(),e.getMgr(),e.getHiredate(),e.getSal(),e.getComm(),e.getDeptno()};
		DbUtils.executeUpdate("insert into emp values(?,?,?,?,?,?,?,?)", params);
	}
	@Override
	public Employee findByNo(int empno) {
		// 1 获取连接
		Connection conn = null;
		PreparedStatement pstat = null;
		ResultSet rs = null;
		try {
			conn = DbUtils.getConnection();
			pstat = conn.prepareStatement("select * from emp where empno=?;");
			pstat.setInt(1, empno);
			rs = pstat.executeQuery();
			Employee employee = null;
			if(rs.next()){
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int mgr = rs.getInt("mgr");
				Date date = rs.getDate("hiredate");
				double sal = rs.getDouble("sal");
				double comm = rs.getDouble("comm");
				int deptno = rs.getInt("deptno");
				employee = new Employee(empno, ename, job, mgr, date, sal, comm, deptno);
			}
			return employee;
		} catch (Exception e) {
			throw new RuntimeException("查询emp失败");
		} finally {
			DbUtils.closeAll(rs, pstat, conn);
		}
	}
}
