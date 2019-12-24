package com.vince;

import org.junit.Test;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.EnumSet;
/**
 * Created by vince on 2017/6/16.
 */
public class EnumDemo {
  public static final int RED = 0x1;
  public static final int GREEN = 0x2;
  public static final int BLUE = 0x3;
  public int color;
  @Test
  public void test1() {
    color = RED;
    color = 4;
  }
  public Color colorEnum;
  @Test
  public void test2(){
    // colorEnum = Color.RED;
    // colorEnum = Color.BLUE;
    colorEnum = Color.GREEN;
    System.out.println(colorEnum);
    System.out.println(colorEnum.name());
    System.out.println(colorEnum.ordinal());
    System.out.println(colorEnum.toString());
    Color[] values = Color.values();
    System.out.println(Arrays.toString(values));
  }
  @Test
  public void test3() {
    EnumSet<Color> set = EnumSet.allOf(Color.class);
    for (Color c: set) {
      System.out.println(c);
    }
    EnumMap<Color,String> map = new EnumMap<>(Color.class);
    map.put(Color.RED, "red");
    map.put(Color.GREEN, "green");
    map.put(Color.BLUE, "blue");
  }
  @Test
  public void test4() {
    System.out.println(Color.RED.getColor());
    System.out.println(Color.RED.getColor2());
  }
  // 使用枚举实现单例设计模式
  @Test
  public void test5() {
    Singleton.SINGLETON.method();
  }
}
