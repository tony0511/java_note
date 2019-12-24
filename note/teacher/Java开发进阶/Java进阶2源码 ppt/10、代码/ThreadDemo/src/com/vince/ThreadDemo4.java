package com.vince;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by vince on 2017/6/5.
 * 1多线程共享数据时，会发生线程不安全的情况
 * 2多线程共享数据必须使用同步
 * 3实现同步的三种方法：
 * （1）使用同步代码块
 * （2）使用同步方法
 * （3）使用Lock（更灵活的代码控制）
 * 多线程共享数据，会有安全问题 ，使用同步可以解决安全问题 ，但同时会牺牲性能，所以同步的代码块要
 * 尽量保持简短，把不随数据变化的相关代码移除同步块，不要阻塞
 */

public class ThreadDemo4 {
  public static void main(String[] args) {
    MyRunnable5 mr5 = new MyRunnable5();
    Thread t1 = new Thread(mr5);
    Thread t2 = new Thread(mr5);
    t1.start();
    t2.start();
  }
}
class MyRunnable5 implements Runnable {
  private int ticket = 10; // 售票
  // private Object obj = new Object(); // 同步锁
  @Override
  public void run() {
    for (int i = 0; i < 300; i++) {
      // 方式一 使用同步代码块
      // this 为要同步的对象，必须让所有要同步的线程使用同一个同步锁对象才能保证这个同步是正常的
      // synchronized (this) {
      //   if (ticket > 0) {
      //     System.out.println("您购买的票剩余" + --ticket + "张");
      //     try {
      //       Thread.sleep(1000);
      //     } catch (InterruptedException e) {
      //       e.printStackTrace();
      //     }
      //   }
      // }
      // method();
      method2();
    }
  }
  // 方式二 使用同步方法，同步的对象是当前对象(this)
  // private synchronized void method() {
  //   if (ticket > 0) {
  //     System.out.println("您购买的票剩余" + --ticket + "张");
  //     try {
  //       Thread.sleep(1000);
  //     } catch (InterruptedException e) {
  //       e.printStackTrace();
  //     }
  //   }
  // }
  // 方式三 使用Lock（更灵活的代码控制）互斥锁
  ReentrantLock lock = new ReentrantLock();
  private void method2() {
    lock.lock(); // 锁
    try {
      if (ticket > 0) {
        System.out.println("您购买的票剩余" + --ticket + "张");
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    } finally {
      lock.unlock(); // 释放锁
    }
  }
}
