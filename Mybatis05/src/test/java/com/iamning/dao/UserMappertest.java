package com.iamning.dao;

import com.iamning.pojo.User;
import com.iamning.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMappertest {
    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //底层主要使用反射
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//       List<User> users = mapper.getUsers();
//
//        for (User user : users) {
//            System.out.println(user);
//        }
//
//        User userByID = mapper.getUserByID(1);
//        System.out.println(userByID);
//        mapper.addUser(new User(5,"hello","13456"));

//        mapper.updateUser(new User(5,"seven","567987"));

        mapper.deleteUser(5);
        sqlSession.close();
    }
}
