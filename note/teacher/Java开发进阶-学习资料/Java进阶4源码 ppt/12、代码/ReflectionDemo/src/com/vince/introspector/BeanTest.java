package com.vince.introspector;

import org.junit.Test;

/**
 * Created by vince on 2017/6/14.
 */
public class BeanTest {
  @Test
  public void getBeanTest(){
    Config bean = (Config)BeanFactory.getBean("bean.name");
    System.out.println(bean);
  }
}
