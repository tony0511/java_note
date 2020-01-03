package com.qfedu.demo.dao.impl;

import com.qfedu.demo.dao.UserDao;

/**
 * Created by helen 2018/1/31
 */
public class UserDaoCache implements UserDao{
    @Override
    public void add() {
        System.out.println("添加用户到缓存中......");
    }
}
