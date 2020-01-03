package com.qfedu.demo.service.impl;

import com.qfedu.demo.dao.UserDao;
import com.qfedu.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by helen 2018/1/31
 */
public class UserServiceNormal implements UserService{

    private UserDao userDao;

    public UserServiceNormal() {
        super();
    }

    public UserServiceNormal(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void prepare(UserDao userDao){
        this.userDao = userDao;
    }

    @Override
    public void add() {
        userDao.add();
    }
}
