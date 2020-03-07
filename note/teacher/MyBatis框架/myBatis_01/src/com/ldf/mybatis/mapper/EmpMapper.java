package com.ldf.mybatis.mapper;

import com.ldf.mybatis.pojo.Emp;

public interface EmpMapper {
  
    // ***** CRUD *****
  
    Emp selectEmpById(Integer id);
    
    Emp selectEmpByIdVehicle(Integer id);
    
}
