package com.zhiwei.webservice.service;

import com.zhiwei.webservice.config.WsStore;
import com.zhiwei.webservice.entity.User;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

/**
 * @Description: 用户接口
 * @Author: wyjun
 * @UpdateDate: 2019/7/23 16:24
 * @Version: 1.0
 */
@WebService(name = "userServiceImpl",targetNamespace = WsStore.NAMESPACE_URL)
public interface IUserService {
    @WebMethod(operationName = "getUserList",action = "getUserList")
    List<User> getUserList();

    @WebMethod(operationName = "findUserByName",action = "findUserByName")
    User findUserByName(@WebParam(name = "userName") String name);
}
