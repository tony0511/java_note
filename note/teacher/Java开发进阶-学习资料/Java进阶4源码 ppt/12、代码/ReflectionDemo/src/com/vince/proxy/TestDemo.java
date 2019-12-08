package com.vince.proxy;

import org.junit.Test;

/**
 * Created by vince on 2017/6/13.
 */
public class TestDemo {
  @Test
  public void testProxy(){
    CreateProxy cp = new CreateProxy(); // 用来创建代理对象的对象
    Hotel person = new Person();
    Hotel proxy = (Hotel) cp.create(person);
    // proxy.shopping(); // invoke
    proxy.reserve();
  }
}
