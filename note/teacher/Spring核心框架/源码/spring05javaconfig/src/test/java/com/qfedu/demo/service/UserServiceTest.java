package com.qfedu.demo.service;

import com.qfedu.demo.config.AppConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by helen 2018/1/31
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= AppConfig.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testAdd(){
        userService.add();
    }
}
