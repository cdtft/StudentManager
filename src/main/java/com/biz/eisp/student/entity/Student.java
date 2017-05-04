package com.biz.eisp.student.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by king on 2017/5/3.
 */
@Entity
@Table(name = "student")
public class Student implements Serializable{
    private static final long serialVersionUID = -6121021796129711973L;

    /*
    * 用户id
    * */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    /*
    * 平均分
    * */
    @Column(name = "avgScore")
    private Integer avgScore;

    /*
    * 出身日期
    * */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "birthday")
    private Date birthday;

    /*
    * 描述
    * */
    @Column(name = "description")
    private String description;


    /*
    * 名字
    * */
    @Column(name = "name", length = 40)
    private String name;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(Integer avgScore) {
        this.avgScore = avgScore;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
