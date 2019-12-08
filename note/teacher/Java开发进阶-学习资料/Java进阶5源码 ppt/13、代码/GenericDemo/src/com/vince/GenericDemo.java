package com.vince;

import org.junit.Test;

import java.util.*;

/**
 * Created by vince on 2017/6/15.
 */
public class GenericDemo {
  @Test
  public void test5(){
    Map<Integer, String> map = new HashMap<>();
    map.put(1,"vince");
    map.put(2,"tom");
    Set<Map.Entry<Integer, String>> entrySet = map.entrySet();
    for (Map.Entry entry: entrySet) {
      System.out.println(entry.getKey() + "-" + entry.getValue());
    }
  }
  @Test
  public void test4(){
    String[] arrays = { "vince", "jack", "Tom", "lily" };
    String[] strs = func(arrays, 0, 1);
    System.out.println(Arrays.toString(strs));
  }
  @Test
  public void test3(){
    Node<Number> n1 = new Node<>(10);
    Node<Integer> n2 = new Node<>(20);
   // getData(n1);
   // getData(n2); // 报错
   // n1 = n2; // 不支持
   // getData2(n2);
    getUpperNumberData(n1);
    getUpperNumberData(n2);
  }
  public static void getData(Node<Number> node){
    System.out.println(node.getData());
  }
  // 使用通配符定义泛型类型，此时只能输出，不能修改
  public static void getData2(Node<?> node){
    // node.setData(20);
    System.out.println(node.getData());
  }
  public static void getUpperNumberData(Node<? extends Number> data){
    // 只能是Number类及其子类
    System.out.println("data :" + data.getData());
  }
  // 泛型方法
  public static <T> T[] func(T[] array, int i, int t){
    T temp = array[i];
    array[i] = array[t];
    array[t] = temp;
    return array;
  }
  @Test
  public void test2(){
    Node<String> stringNode = new Node<>("vince");
    Node<Integer> intNode = new Node<>(10);
    System.out.println(stringNode.getData());
    System.out.println(intNode.getData());
  }
  @Test
  public void test1(){
    List<String> list = new ArrayList<>();
    list.add("vince");
    // list.add(10);
    // list.add(new Object());
    for (int i = 0; i < list.size(); i++) {
      // 如果我们不能确定集合中的元素类型，那么我们需要在处理元素时
      // 要判断元素的类型，才能做相应的操作
    }
  }
}
