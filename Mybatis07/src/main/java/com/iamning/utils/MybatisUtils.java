package com.iamning.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

//sqlSessionFactory--> sqlSession
public class MybatisUtils {

    private static SqlSessionFactory sqlSessionFactory;
    static{
        try {
            //使用Mybatis第一步，sqlSessionFactory对象
            String resource = "mybatis-config.xml";
            //将文件核心地址作为流进行读取，创建对象接收
            InputStream inputStream = Resources.getResourceAsStream(resource);
            //用SqlSessionBuilder（）.build（）方法创建SqlFactory
           sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static SqlSession getSqlSession(){
        //重载
        //开启自动提交
        return sqlSessionFactory.openSession(true);
    }
}
