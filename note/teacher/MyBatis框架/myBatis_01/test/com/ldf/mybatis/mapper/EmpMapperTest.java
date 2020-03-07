package com.ldf.mybatis.mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.ldf.mybatis.pojo.Emp;
import com.ldf.mybatis.utils.MyBatisUtil;

public class EmpMapperTest {
  
  @Test
  public void testSelectEmpByIdVehicle() {
    SqlSession session = MyBatisUtil.getSqlSession();
    
    EmpMapper empMapper = session.getMapper(EmpMapper.class);
    Emp emp1 = empMapper.selectEmpByIdVehicle(10);
    Emp emp2 = empMapper.selectEmpByIdVehicle(13);
    
    session.close();
    
    System.out.println(emp1);
    System.out.println(emp2);
    
  }
  
}
