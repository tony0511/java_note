package com.qianfeng.service.impl;

import com.qianfeng.dao.UserDao;
import com.qianfeng.dao.impl.UserDaoImpl;
import com.qianfeng.entity.User;
import com.qianfeng.service.UserService;
import com.qianfeng.utils.MD5Utils;

public class UserServiceImpl implements UserService{

	private UserDao userDao = new UserDaoImpl();
	@Override
	public void login(String name, String password) {
		// TODO Auto-generated method stub
		
		User user = null;
		try {
			user = userDao.findByName(name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e.getMessage());
		}
		if(user == null){
			throw new RuntimeException("用户名错误");
		}
		// 针对输入的密码，进行md5处理
		String md5Pwd = MD5Utils.MD5Encode(password, "utf8");
		if(!user.getPassword().equals(md5Pwd)){
			throw new RuntimeException("密码错误");
		}
	}

}
