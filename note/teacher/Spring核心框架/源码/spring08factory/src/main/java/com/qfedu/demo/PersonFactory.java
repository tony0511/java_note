package com.qfedu.demo;

public class PersonFactory {

    /**
     * 静态工厂方法
     * @return
     */
    public static Person createPerson1(){
        System.out.println("静态工厂创建Person......");
        return new Person();
    }

    public Person createPerson2(){
        System.out.println("实例工厂创建Person......");
        return new Person();
    }
}
