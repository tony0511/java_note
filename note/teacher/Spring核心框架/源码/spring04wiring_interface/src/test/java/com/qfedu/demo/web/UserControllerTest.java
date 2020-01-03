package com.qfedu.demo.web;

import com.qfedu.demo.config.AppConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by helen 2018/1/27
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes=AppConfig.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UserControllerTest {

    @Autowired
    private UserController userController;

    @Test
    public void testAdd(){
        userController.add();
    }
}
