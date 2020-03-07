package com.ldf.mybatis.pojo;

import java.io.Serializable;

public class Emp implements Serializable {
  
  private static final long serialVersionUID = 1L;
  
  Integer id;
  String name;
  Integer deptNo;
  String ext;
  
  public Emp() {
    super();
  }
  
  public Emp(String name, Integer deptNo, String ext) {
    super();
    this.name = name;
    this.deptNo = deptNo;
    this.ext = ext;
  }

  public Emp(Integer id, String name, Integer deptNo, String ext) {
    super();
    this.id = id;
    this.name = name;
    this.deptNo = deptNo;
    this.ext = ext;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getDeptNo() {
    return deptNo;
  }

  public void setDeptno(Integer deptNo) {
    this.deptNo = deptNo;
  }
  
  public String getExt() {
    return ext;
  }

  public void setExt(String ext) {
    this.ext = ext;
  }

  @Override
  public String toString() {
    return "Emp [id=" + id + ", name=" + name + ", deptNo=" + deptNo + ", ext=" + ext + "]";
  }
  
}
