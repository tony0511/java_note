package com.qfedu.demo.service.com.qfedu.demo.service.impl;

import com.qfedu.demo.dao.UserDao;
import com.qfedu.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by helen 2018/1/26
 */
//@Component
@Service
public class UserServiceNormal implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void add() {
        userDao.add();
    }
}
