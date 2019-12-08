package com.vince.ex;

/**
 * 自定义异常通常都是通过继承一个异常类来实现
 * 1、Throwable
 * 2、Exception
 * 3、RuntimeException
 * @company www.codingke.com
 * 自定义异常常的实现是，提供构造方法
 * 异常对象本身是没有实际功能，只是一个有意义的标识
 * @author vince
 * @description
 */
public class MyException extends RuntimeException{
  public MyException(){
    super();
  }
  public MyException(String message){
    super(message);
  }
}
