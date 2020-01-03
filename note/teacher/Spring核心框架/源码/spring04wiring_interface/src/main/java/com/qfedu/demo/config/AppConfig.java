package com.qfedu.demo.config;

import com.qfedu.demo.dao.UserDao;
import com.qfedu.demo.service.UserService;
import com.qfedu.demo.web.UserController;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by helen 2018/1/26
 */
@Configuration
@ComponentScan("com.qfedu.demo")
@ComponentScan(basePackages = {"com.qfedu.demo.web", "com.qfedu.demo.service", "com.qfedu.demo.dao"})

@ComponentScan(basePackageClasses = {UserController.class, UserService.class, UserDao.class})


public class AppConfig {
}
