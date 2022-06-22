import com.iamning.dao.UserMapper;
import com.iamning.pojo.User;
import com.iamning.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class Mytest {
    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        SqlSession sqlSession2 = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);



        User user = mapper.queryUserById(1);
        System.out.println(user);
        sqlSession.close();

        System.out.println("=================================");

        UserMapper mapper1 = sqlSession2.getMapper(UserMapper.class);

        User user1 = mapper1.queryUserById(1);
        System.out.println(user1);
//        mapper.UpdateUser(new User(2,"假面骑士","123456"));

//        sqlSession.clearCache();//手动清理缓存

//        System.out.println("=================");
//        User user1 = mapper.queryUserById(1);
//        System.out.println(user1);
//
//        System.out.println(user==user1);
        System.out.println(user==user1);
        sqlSession2.close();
    }
}
