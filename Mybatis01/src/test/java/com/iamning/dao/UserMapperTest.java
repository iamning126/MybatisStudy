package com.iamning.dao;

import com.iamning.pojo.User;
import com.iamning.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest {
    @Test
    public void test(){

        //获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();


        try {
            //方式一：getMapper执行SQL

            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<User> userList = userMapper.getUserList();

            //方式二：
            //List<User> userList = sqlSession.selectList("com.iamning.dao.UserDao.getUserList");

            for (User user : userList) {
                System.out.println(user);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭SqlSession

            sqlSession.close();
        }
    }

    @Test
    public void getUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

//        UserMapper mapper=new UserMapperImpl;
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.getUserById(1);

        System.out.println(user);

        sqlSession.close();
    }
    //增删改需要提交事务
    @Test
    public void addUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

//        UserMapper mapper=new UserMapperImpl;
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

       int res=mapper.addUser(new User(4,"张三疯","123456"));

        if(res>0){
            System.out.println("插入成功");
        }
        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void updateUser(){
        //工具类创建sqlSession
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //用sqlSession读取mapper接口，并创建对象接受
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //读取返回的行数
        int i = mapper.UpdateUser(new User(3, "王也", "981126"));

        //若大于0
        //则执行修改
        if(i>0){
            System.out.println("修改成功");
        }
        //提交事务
        sqlSession.commit();
        //关闭
        sqlSession.close();
    }
    @Test
    public void delete(){
        //工具类创建sqlSession
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //用sqlSession读取mapper接口，并创建对象接受

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int i = mapper.deleteUser(5);

        if(i>0){
            System.out.println("删除成功");
        }

        //提交事务
        sqlSession.commit();
        //关闭
        sqlSession.close();
    }
    @Test
    public void addUser2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        Map<String, Object> map = new HashMap<>();

        map.put("userid",5);
        map.put("username","Hello");
        map.put("password","222222");

        int i = mapper.addUser2(map);


        if(i>0){
            System.out.println("插入成功");
        }
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void getUserByid2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        Map<String, Object> map = new HashMap<>();

        map.put("helloid",4);
        map.put("name","张三疯");

        User user = mapper.getUserById2(map);

        System.out.println(user);

        sqlSession.close();
    }
    @Test
    public void getUserLike(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> users = mapper.getUserLike("%李%");

        for (User user : users) {
            System.out.println(user);
        }

        sqlSession.close();
    }
}
