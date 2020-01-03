package com.qfedu.demo.dao.impl;

import com.qfedu.demo.dao.UserDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * Created by helen 2018/1/27
 */
//@Component
@Repository
public class UserDaoNormal implements UserDao{
    @Override
    public void add() {
        System.out.println("添加用户到数据库中......");
    }
}
