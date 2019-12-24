package com.vince;

/**
 * Created by vince on 2017/6/16.
 * 定义一个枚举类型
 */
public enum Color implements Info{
  RED(10) {
    @Override
    public String getColor2() {
      return "red";
    }
  },
  GREEN(20) {
    @Override
    public String getColor2() {
      return "green";
    }
  },
  BLUE {
    @Override
    public String getColor2() {
      return "blue";
    }
  };
  private int color;
  private Color(){
    System.out.println("无参构造器");
  }
  private Color(int color){
    this.color = color;
    System.out.println("有参构造器");
  }
  @Override
  public int getColor() {
    return color;
  }
  public abstract String getColor2();
}
