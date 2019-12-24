package com.vince;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.junit.Test;

import java.lang.reflect.*;

/**
 * Created by vince on 2017/6/9.
 */
public class ReflectionDemo {
  // 获取Class对象的三种形式
  @Test
  public void test1(){
    // 方式一 通过对象实例的getClass()方法
    Dog dog = new Dog("wangwang", 4, "白色");
    Class<Dog> aClass = dog.getClass();
    // 方式二 通过类.class
    Class<Dog> dogClass = Dog.class;
    // 方式三 通过Class.forName方法
    try {
      Class<Dog> aClass1 = Class.forName("com.vince.Dog");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }
  // 通过反射来实例化对象
  public void test2(){
    Class<Dog> dogClass = Dog.class;
    try {
      // 通过Class对象实例化类对象，调用了默认无参的构造方法
      Dog dog = (Dog) dogClass.newInstance();
    } catch (InstantiationException|IllegalAccessException e) {
      e.printStackTrace();
    }
  }
  // 获取所有构造方法
  @Test
  public void test3(){
    Class<Dog> dogClass = Dog.class;
    Constructor<?>[] constructors = dogClass.getConstructors(); // 获取所有构造方法
    for (int i = 0; i < constructors.length; i++) {
      System.out.println(constructors[i].getName()); // 获取构造方法的名字
      System.out.println(constructors[i].getParameterCount()); // 获取构造方法的参数
    }
    try {
      // 获取一个指定的构造方法
      Constructor<Dog> constructor = dogClass.getConstructor(String.class, int.class, String.class);
      // 调用带参数的构造器来实例化对象
      Dog dog = constructor.newInstance("小白", 5, "白色");
    } catch (NoSuchMethodException|IllegalAccessException|InstantiationException|InvocationTargetException e) {
      e.printStackTrace();
    }
  }
  // 获取所有的属性
  @Test
  public void test4(){
    Dog dog = new Dog("wangwang", 4, "白色");
    Class<Dog> dogClass = Dog.class;
    // 获取非私有属性
    Field[] fields = dogClass.getFields();
    System.out.println(fields.length);
    // 获取所有属性（包括私有属性）
    Field[] declaredFields = dogClass.getDeclaredFields();
    // System.out.println(declaredFields.length);
    for (int i = 0; i < declaredFields.length; i++) {
      if (declaredFields[i].getName().equals("name")) {
        System.out.println(declaredFields[i].get(dog)); // 在 dog 实例上获取该属性值
        System.out.println(declaredFields[i].set(dog, "旺财")); // 在 dog 实例上设置该属性值
      }
      int modifiers = declaredFields[i].getModifiers(); // 获取修饰符
      System.out.println(Modifier.toString(modifiers) + " " + declaredFields[i].getType() + " " + declaredFields[i].getName());
    }
  }
  // 获取包名，方法
  @Test
  public void test5(){
    Dog dog = new Dog("wangwang", 4, "白色");
    Class<Dog> dogClass = Dog.class;
    // 获取类的包名
    Package aPackage = dogClass.getPackage();
    // System.out.println(aPackage.getName());
    // 获取公共的方法，包括继承的公有方法
    Method[] methods = dogClass.getMethods();
    for (int i = 0; i < methods.length; i++) {
      System.out.println(methods[i]);
      if (methods[i].getName().equals("toString")){
        try {
          String s = (String)methods[i].invoke(dog); // 在 dog 对象上调用方法
          System.out.println(s);
        } catch (IllegalAccessException|InvocationTargetException e) {
          e.printStackTrace();
        }
      }
    }
    System.out.println("---------------");
    // 访问私有方法，获取到本类中定义的所有方法（不包括父类）
    Method[] declaredMethods = dogClass.getDeclaredMethods();
    for (int i = 0; i < declaredMethods.length; i++) {
      System.out.println(declaredMethods[i]);
      if (declaredMethods[i].getName().equals("set")){
        // 设置 私有方法可以被访问（去除访问修饰符的检查）
        declaredMethods[i].setAccessible(true);
        try {
          declaredMethods[i].invoke(dog); // 在 dog 对象上调用方法
        } catch (IllegalAccessException|InvocationTargetException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
