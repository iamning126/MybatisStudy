package com.iamning.pojo;


import lombok.Data;

@Data
public class Student {
    private int id;
    private String name;
    //学生需要关联ID
    private int tid;
}
