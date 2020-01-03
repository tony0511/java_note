package com.qfedu.demo.service.com.qfedu.demo.service.impl;

import com.qfedu.demo.service.UserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * Created by helen 2018/1/26
 */
@Component("ff")
public class UserServiceFestival implements UserService {
    @Override
    public void add() {
        System.out.println("注册用户并发送优惠券");
    }
}
