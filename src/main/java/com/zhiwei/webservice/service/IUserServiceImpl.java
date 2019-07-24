package com.zhiwei.webservice.service;

import com.zhiwei.webservice.config.WsStore;
import com.zhiwei.webservice.dao.UserMapper;
import com.zhiwei.webservice.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebService;
import java.util.List;

/**
 * @Description: 用户实现类
 * @Author: wyjun
 * @UpdateDate: 2019/7/23 16:24
 * @Version: 1.0
 */
@WebService(
        serviceName = "userService",
        name = "userServiceImpl",
        portName = "userPortName",
        endpointInterface = "com.zhiwei.webservice.service.IUserService",
    targetNamespace = WsStore.NAMESPACE_URL
)
@Service
public class IUserServiceImpl implements IUserService {


    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getUserList() {
        return userMapper.UserList();
    }

    @Override
    public User findUserByName(String name) {
        return userMapper.findUserByName(name);
    }
}
