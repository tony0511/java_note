package com.ldf.mybatis.pojo;

import java.io.Serializable;
import java.util.ArrayList;

public class Blog implements Serializable {
  
  private static final long serialVersionUID = 1L;
  
  Integer id;
  String name;
  Integer deptNo;
  Emp emp;
  ArrayList<Article> articleList;
  
  public Blog() {
    super();
  }
  
  public Blog(String name, Integer deptNo, Emp emp) {
    super();
    this.name = name;
    this.deptNo = deptNo;
    this.emp = emp;
  }
  
  public Blog(String name, Integer deptNo) {
    super();
    this.name = name;
    this.deptNo = deptNo;
    System.out.println("构造方法调用=====");
  }

  public Blog(Integer id, String name, Integer deptNo) {
    super();
    this.id = id;
    this.name = name;
    this.deptNo = deptNo;
  }

  public Blog(Integer id, String name, Integer deptNo, Emp emp) {
    super();
    this.id = id;
    this.name = name;
    this.deptNo = deptNo;
    this.emp = emp;
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

  public Emp getEmp() {
    return emp;
  }

  public void setEmp(Emp emp) {
    this.emp = emp;
  }

  @Override
  public String toString() {
    return "Blog [id=" + id + ", name=" + name + ", deptNo=" + deptNo + ", emp=" + emp + "\n, articleList=" + articleList
        + "]\n";
  }
  
}
