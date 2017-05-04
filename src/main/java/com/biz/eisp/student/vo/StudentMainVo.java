package com.biz.eisp.student.vo;

import com.biz.eisp.student.entity.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by king on 2017/5/3.
 */
public class StudentMainVo {

    /*
    * 学生信息集合
    * */
    private List<Student> students = new ArrayList<>();

    /*
    * 当前页数
    * */
    private Integer currentPage;

    /*
    * 总页数
    * */
    private Integer totalPage;

    /*
    * 分页大小
    * */

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
}
