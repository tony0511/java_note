package com.qfedu.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class PersonFactoryTest {

    @Autowired
    Person person1;

    @Autowired
    Person person2;

    @Test
    public void test01(){
        System.out.println(person1);
        System.out.println(person2);
    }
}
