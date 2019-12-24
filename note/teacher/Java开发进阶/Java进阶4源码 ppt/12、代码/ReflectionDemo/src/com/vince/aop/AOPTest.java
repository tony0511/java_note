package com.vince.aop;

import org.junit.Test;

import java.io.InputStream;

/**
 * Created by vince on 2017/6/14.
 */
public class AOPTest {
    @Test
    public void test(){
        // 1 读取配置 文件
        InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("com/vince/aop/bean.properties");
        // 2 创建Bean的工厂对象
        BeanFactory beanFactory = new BeanFactory(in);
        // 3 获取代理对象
        ProxyFactoryBean proxyFactoryBean = (ProxyFactoryBean) beanFactory.getBean("bean");
        IManager proxy = (IManager) proxyFactoryBean.getProxy();
        proxy.add("我是一只猫");
    }
}
