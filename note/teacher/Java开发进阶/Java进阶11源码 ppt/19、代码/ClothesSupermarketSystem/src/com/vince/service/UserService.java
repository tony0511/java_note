package com.vince.service;

import com.vince.bean.User;
import com.vince.utils.BusinessException;

/**
 * Created by vince on 2017/7/19.
 */
public interface UserService {

    public User register(User user)throws BusinessException;

    public User login(String username,String password)throws BusinessException;
}
