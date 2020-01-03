package com.qfedu.demo.config;

import com.qfedu.demo.dao.UserDao;
import com.qfedu.demo.dao.impl.UserDaoCache;
import com.qfedu.demo.dao.impl.UserDaoNormal;
import com.qfedu.demo.service.UserService;
import com.qfedu.demo.service.impl.UserServiceNormal;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * Created by helen 2018/1/30
 */
@Configuration
public class AppConfig {

    @Bean
    public UserDao userDaoNormal(){
        System.out.println("创建UserDaoNormal对象");
        return new UserDaoNormal();
    }

    @Bean
    public UserDao userDaoCache(){
        System.out.println("创建UserDaoCache对象");
        return new UserDaoCache();
    }

    @Bean
    public UserService userServiceNormal(@Qualifier("userDaoNormal") UserDao userDao){
        System.out.println("创建UserService对象");
        UserServiceNormal userService = new UserServiceNormal();
        //userService.setUserDao(userDao);
        userService.prepare(userDao);
        return userService;
    }
}
