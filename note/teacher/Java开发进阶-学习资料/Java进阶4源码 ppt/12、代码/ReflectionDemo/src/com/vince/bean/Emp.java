package com.vince.bean;

/**
 * Created by vince on 2017/6/13.
 */
public class Emp {
  private String name;
  private int age;
  private int salary;
  public String getInfo(){
    return "name=" + name + ",sage=" + age + ",salray=" + salary;
  }
  public String getName() { return name; }
  public void setName(String name) { this.name = name; }
  public int getAge() { return age; }
  public void setAge(int age) { this.age = age; }
  public int getSalary() { return salary; }
  public void setSalary(int salary) { this.salary = salary; }
}
