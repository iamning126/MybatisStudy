package com.iamning.pojo;

import lombok.Data;

import java.util.Date;


@Data
public class Blog {
    private String id;
    private String title;
    private String author;
    //属性名和字段名不一致，
    private int views;
    private Date createTime;

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
