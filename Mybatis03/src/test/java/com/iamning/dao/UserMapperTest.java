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

        User user1 = mapper.getUserById(3);

        System.out.println(user1);
//        select * from mybatis.user where id=#{id};

//        类型处理器
//        select id,name,pwd as password from mybatis.user where id=#{id};

        sqlSession.close();
    }
}
