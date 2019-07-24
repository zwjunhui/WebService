package com.zhiwei.webservice.dao;

import com.zhiwei.webservice.entity.User;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface UserMapper {
    List<User> UserList();

    User findUserByName(String name);
}
