package com.iamning.dao;

import com.iamning.pojo.User;
import com.iamning.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;


public class UserMapperTest {
    static Logger logger = Logger.getLogger(UserMapperTest.class);
    @Test
    public void getUserLike(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        logger.info("测试进入getuserlike成功");
        User user1 = mapper.getUserById(3);

        System.out.println(user1);
//        select * from mybatis.user where id=#{id};

//        类型处理器
//        select id,name,pwd as password from mybatis.user where id=#{id};

        sqlSession.close();
    }

    @Test
    public void testLog4j(){

        logger.info("info进入了testlog4j");
        logger.debug("debug:进入了testLog4j");
        logger.error("erro进入了log4j");
    }
    @Test
    public void getUserByLimit(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        HashMap<String, Integer> map = new HashMap<String, Integer>();

        map.put("startIndex",1);
        map.put("pageSize",3);

        List<User> users = mapper.getUserByLimit(map);

        for (User user : users) {
            System.out.println(user);
        }
        sqlSession.close();
    }
    @Test
    public void getUseRowBounds(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //getUserByRowBounds
        RowBounds rowBounds = new RowBounds(1, 2);


        //通过java代码层面实现分页
        List<User> userList = sqlSession.selectList("com.iamning.dao.UserMapper.getUserByRowBounds",null,rowBounds);


        for (User user : userList) {
            System.out.println(user);
        }

        sqlSession.close();
    }
}
