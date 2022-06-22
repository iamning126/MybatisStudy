package com.iamning.dao;

import com.iamning.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    //获取全部用户
    List<User> getUserList();


    //根据ID查询用户
    User getUserById(int id);

    //insert一个用户
    int addUser(User user);


    //修改用户
    int UpdateUser(User user);

    int deleteUser(int id);
}
