package com.iamning.dao;

import com.iamning.pojo.User;
import com.iamning.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {
    @Test
    public void getUserLike(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> users = mapper.getUserList();

        for (User user : users) {
            System.out.println(user);
        }

        sqlSession.close();
    }
}
