package com.qfedu.demo.soundsystem;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-property.xml")
public class AppTest {

    @Autowired
    private CDPlayer CDPlayer1;

    @Test
    public void test(){

        CDPlayer1.play();
    }
}
