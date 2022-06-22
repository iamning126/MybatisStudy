package com.iamning.dao;

import com.iamning.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    //根据ID查询用户
    User getUserById(int id);

    //sql分页
    List<User> getUserByLimit(Map<String,Integer> map);

    //rowBounds分页2
    List<User> getUserByRowBounds();


}