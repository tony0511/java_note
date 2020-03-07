package com.ldf.mybatis.pojo;

import java.io.Serializable;

public class Car extends Emp implements Serializable {
  
  private static final long serialVersionUID = 1L;
  
  Integer doorCount;
  
  public Car() {}

  public Integer getDoorCount() {
    return doorCount;
  }

  public void setDoorCount(Integer doorCount) {
    this.doorCount = doorCount;
  }

  @Override
  public String toString() {
    return "Car [doorCount=" + doorCount + "]";
  }
  
}
