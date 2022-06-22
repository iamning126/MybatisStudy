package com.iamning.dao;

import com.iamning.pojo.Student;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentMapper {
    //查询所有的学生信息，以及对应的老师的信息

    public List<Student> getStudent();
}
