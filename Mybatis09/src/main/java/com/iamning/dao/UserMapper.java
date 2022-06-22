package com.iamning.dao;

import com.iamning.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    //根据id查询数据
    User queryUserById(@Param("id") int id);

    int UpdateUser(User user);
}
