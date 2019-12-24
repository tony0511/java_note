package com.vince;

/**
 * Created by vince on 2017/6/1.
 * <p>
 * 线程的休眠
 * 在当前线程的执行中，暂停指定的毫秒数，释放CPU的时间片
 */
public class ThreadDemo1 {
  public static void main(String[] args) {
    MyThread mt = new MyThread();
    MyRunnable mr = new MyRunnable(); // 推荐
    Thread t2 = new Thread(mr);
    mt.start(); // 启动线程
    t2.start();
    for (int i = 0; i < 100; i++) {
      System.out.println(Thread.currentThread().getName() + "-" + i);
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
// 第一种方式：继承 Thread 类
class MyThread extends Thread {
  @Override
  public void run() {
    for (int i = 0; i < 100; i++) {
      System.out.println(Thread.currentThread().getName() + "-" + i);
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
// 第二种方式：实现 Runnable 接口
class MyRunnable implements Runnable {
  @Override
  public void run() {
    for (int i = 0; i < 100; i++) {
      System.out.println(Thread.currentThread().getName() + "-" + i);
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
