package com.qf.day05;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.qf.domain.Employee;
import com.qf.utils.DruidUtils;

/**
 * 使用DbUtils工具包
 * @author wgy
 *
 */
public class Demo1 {
	public static void main(String[] args) {
		
		//1创建QueryRunner
		QueryRunner queryRunner=new QueryRunner(DruidUtils.getDataSource());
		
		try {
			System.out.println("-----------------ArrayHandler----------------");
			//2查询一条数据 把数据变成一个数组
			Object[] objects=queryRunner.query("select * from emp where empno=1234",new ArrayHandler());
		
			for (Object o : objects) {
				System.out.println(o);
			}
			System.out.println("--------------------ArrayListHandler--------------------");
			//3查询多个条数据
			List<Object[]> list=queryRunner.query("select * from emp", new ArrayListHandler());
			for (Object[] objects2 : list) {
				System.out.println(Arrays.toString(objects2));
			}
			//4查询员工的所有名字，把所有名字放入数组
			System.out.println("-------------------ColumnListHandler-------------------");
			List<String> nameslist=queryRunner.query("select * from emp;", new ColumnListHandler<String>(2));
			for (String string : nameslist) {
				System.out.println(string);
			}
			//5查询一条数据，把输入放入map集合，用字段名作为key，数据作为value
			System.out.println("-------------------MapHandler-------------------");
			Map<String, Object> map=queryRunner.query("select * from emp where empno=1234", new MapHandler());
			for(Map.Entry<String, Object>  entry: map.entrySet()){
				System.out.println(entry.getKey()+"....."+entry.getValue());
			}
			
			//6 查询数据个数
			System.out.println("------------------ScalarHandler----------------------");
			
			Long integer=queryRunner.query("select count(*) from emp", new ScalarHandler<Long>());
			System.out.println(integer);
			
			//7查询一条记录，把数据封装成Employee对象 重点
			System.out.println("-----------------------BeanHandler-----------------------");
			Employee employee=queryRunner.query("select * from emp where empno=1234", new BeanHandler<Employee>(Employee.class));
			System.out.println(employee.toString());
			
			//8查询全部数据，把数据封装成对象并且放入集合中
			System.out.println("-----------------------BeanListHandler-----------------------");
			List<Employee> employees=queryRunner.query("select * from emp", new BeanListHandler<Employee>(Employee.class));
			for (Employee employee2 : employees) {
				System.out.println(employee2.toString());
			}
			
			int result=queryRunner.update("delete from emp where empno=?",1234);
	
			if(result>0){
				System.out.println("删除成功");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
