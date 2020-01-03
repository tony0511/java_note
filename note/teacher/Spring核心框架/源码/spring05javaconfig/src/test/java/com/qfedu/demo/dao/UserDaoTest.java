package com.qfedu.demo.dao;

import com.qfedu.demo.config.AppConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by helen 2018/1/30
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= AppConfig.class)
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void testAdd(){
        userDao.add();
    }
}
