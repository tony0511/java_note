package com.qianfeng.dao;

import com.qianfeng.entity.User;

public interface UserDao {

	public User findByName(String name);
}
