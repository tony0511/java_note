package com.vince.introspector;

import com.sun.corba.se.impl.ior.WireObjectKeyTemplate;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * Created by vince on 2017/6/14.
 * 通过内省的API来装配一个Bean对象，Bean对象的值是通过配置文件中来获取
 * 目的是为了提高维护性
 */
public class BeanFactory {
  private static Properties prop = new Properties();
  // 使用静态代码块读取配置文件
  static {
    InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("com/vince/introspector/config.properties");
    try {
      prop.load(in);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  // 获取一个Bean
  public static Object getBean(String name){
    Object bean = null;
    String beanName = prop.getProperty(name);
    try {
      Class<?> aClass = Class.forName(beanName);
      bean = aClass.newInstance();
      // 通过类信息获取javaBean的描述信息
      BeanInfo beanInfo = Introspector.getBeanInfo(aClass);
      // getMethodDescriptors() 获取该类的所有方法描述器(然后通过 getMethod() 获得此 MethodDescriptor 封装的方法)
      // getPropertyDescriptors() 获取该类的所有属性描述器
      PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
      for (int i = 0; i < propertyDescriptors.length; i++) {
        String propertyName = propertyDescriptors[i].getName(); // 获得属性名
        // getReadMethod() 获得用于读取属性值的方法
        // getWriteMethod() 获得用于写入属性值的方法
        Method writeMethod = propertyDescriptors[i].getWriteMethod();
        if("username".equals(propertyName)) {
          // 调用属性的set方法，写入该属性值
          writeMethod.invoke(bean, prop.getProperty("bean.username"));
        } else if ("password".equals(propertyName)){
          writeMethod.invoke(bean, prop.getProperty("bean.password"));
        } else if("url".equals(propertyName)){
          writeMethod.invoke(bean, prop.getProperty("bean.url"));
        }
      }
    } catch (ClassNotFoundException|IntrospectionException|IllegalAccessException|InstantiationException|InvocationTargetException e) {
      e.printStackTrace();
    }
    return bean;
  }
}
