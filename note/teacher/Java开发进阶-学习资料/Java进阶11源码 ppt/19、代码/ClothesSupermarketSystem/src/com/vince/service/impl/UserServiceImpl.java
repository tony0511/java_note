package com.vince.service.impl;

import com.vince.bean.User;
import com.vince.service.UserService;
import com.vince.utils.BusinessException;
import com.vince.utils.EmptyUtils;
import com.vince.utils.UserIO;

/**
 * Created by vince on 2017/7/19.
 */
public class UserServiceImpl implements UserService {
    @Override
    public User register(User user) throws BusinessException {
        UserIO userIO = new UserIO();
        userIO.add(user);
        userIO.writeUsers();
        return user;
    }

    @Override
    public User login(String username, String password) throws BusinessException {
        if(EmptyUtils.isEmpty(username)){
            throw new BusinessException("username.notnull");
        }
        if(EmptyUtils.isEmpty(password)){
            throw new BusinessException("password.notnull");
        }

        UserIO userIO = new UserIO();
        userIO.readUsers();
        User user = userIO.findByUsernameAndPassword(username,password);

        return user;
    }
}
