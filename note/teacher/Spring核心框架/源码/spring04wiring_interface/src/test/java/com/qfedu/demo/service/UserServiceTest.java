package com.qfedu.demo.service;

import com.qfedu.demo.config.AppConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by helen 2018/1/26
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=AppConfig.class)
public class UserServiceTest {

    /*@Autowired
    @Qualifier("userServiceFestival")*/
    @Resource(name="ff")
    private UserService userService;

    @Test
    public void testAdd(){
        userService.add();
    }
}
