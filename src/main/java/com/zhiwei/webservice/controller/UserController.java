package com.zhiwei.webservice.controller;

import com.zhiwei.webservice.entity.User;
import com.zhiwei.webservice.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: wyjun
 * @UpdateDate: 2019/7/23 16:36
 * @Version: 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/list")
    public List<User> UserList(){
        List<User> users = userService.getUserList();
        return users;
    }

    @RequestMapping("/findUserByName")
    public User findUserByName(String userName){
        return userService.findUserByName(userName);
    }
}
