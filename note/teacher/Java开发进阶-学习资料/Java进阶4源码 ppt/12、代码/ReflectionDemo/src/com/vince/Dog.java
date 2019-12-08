package com.vince;

/**
 * Created by vince on 2017/6/12.
 */
public class Dog {
  public int type;
  private String name;
  private int age;
  private String color;
  public Dog() {}
  public Dog(String name, int age, String color) {
    this.name = name;
    this.age = age;
    this.color = color;
  }
  private void set(){ System.out.println("set"); }
  protected void get(){ System.out.println("get"); }
  public String getName() { return name; }
  public void setName(String name) { this.name = name; }
  public int getAge() { return age; }
  public void setAge(int age) { this.age = age; }
  public String getColor() { return color; }
  public void setColor(String color) { this.color = color; }
  @Override
  public String toString() {
    return "Dog{" + "name='" + name + '\'' + ", age=" + age + ", color='" + color + '\'' + '}';
  }
}
