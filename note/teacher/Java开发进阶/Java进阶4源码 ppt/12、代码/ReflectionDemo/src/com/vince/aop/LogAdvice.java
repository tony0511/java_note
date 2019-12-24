package com.vince.aop;

/**
 * Created by vince on 2017/6/14.
 * 切面的实现类
 */
public class LogAdvice implements Advice{
  @Override
  public void beforeAdvice() {
    System.out.println("start time:" + System.currentTimeMillis());
  }
  @Override
  public void afterAdvice() {
    System.out.println("end time:" + System.currentTimeMillis());
  }
}
