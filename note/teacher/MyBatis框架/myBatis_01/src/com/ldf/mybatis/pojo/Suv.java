package com.ldf.mybatis.pojo;

import java.io.Serializable;

public class Suv extends Emp implements Serializable {
  
  private static final long serialVersionUID = 1L;
  
  Integer allWheelDrive;
  
  public Suv() {}

  public Integer getAllWheelDrive() {
    return allWheelDrive;
  }

  public void setAllWheelDrive(Integer allWheelDrive) {
    this.allWheelDrive = allWheelDrive;
  }

  @Override
  public String toString() {
    return "Suv [allWheelDrive=" + allWheelDrive + "]";
  }
  
}
