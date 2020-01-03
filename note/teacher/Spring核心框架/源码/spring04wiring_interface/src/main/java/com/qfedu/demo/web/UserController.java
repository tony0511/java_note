package com.qfedu.demo.web;

import com.qfedu.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

/**
 * Created by helen 2018/1/27
 */
//@Component
@Controller
public class UserController {

    @Autowired
    @Qualifier("userServiceNormal")
    private UserService userService;

    public void add(){
        userService.add();
    }
}
