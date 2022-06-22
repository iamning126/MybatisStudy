package com.iamning.dao;

import com.iamning.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    //获取全部用户
    List<User> getUserList();

    List<User> getUserLike(String value);



    //根据ID查询用户
    User getUserById(int id);
    User getUserById2(Map<String,Object> map);
    //insert一个用户
    int addUser(User user);
    int addUser2(Map<String,Object> map);

    //修改用户
    int UpdateUser(User user);



    int deleteUser(int id);
}
