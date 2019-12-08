package com.qianfeng.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.qianfeng.dao.UserDao;
import com.qianfeng.entity.User;
import com.qianfeng.utils.JDBCUtils;

public class UserDaoImpl implements UserDao{

	@Override
	public User findByName(String name) {
		// TODO Auto-generated method stub
		String sql = "select * from t_user where username=?";
		QueryRunner qr = JDBCUtils.getQueryRunner();
		User user = null;
		try {
			user = qr.query(sql, new BeanHandler<>(User.class), name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		return user;
	}

}
