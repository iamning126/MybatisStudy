package com.iamning;

import com.iamning.dao.StudentMapper;
import com.iamning.dao.TeacherMapper;
import com.iamning.pojo.Student;
import com.iamning.pojo.Teacher;
import com.iamning.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class Mytest {
    public static void main(String[] args) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);

        Teacher teacher = mapper.getTeacher(1);

        System.out.println(teacher);

        sqlSession.close();
    }
    @Test
    public void testStudent(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        List<Student> students = mapper.getStudent();

        for (Student student : students) {
            System.out.println(student);
        }

        sqlSession.close();
    }

}
