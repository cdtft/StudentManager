package com.biz.eisp.student.service;

import com.biz.eisp.student.entity.Student;
import com.biz.eisp.student.vo.StudentMainVo;


/**
 * Created by king on 2017/5/4.
 */
public interface StudentService {

    void deleteStudent(Integer id);

    void saveOrModifyStudent(Student student);

    Student getStudent(Integer id);

    StudentMainVo getStudentMain(Integer currentPage);

    //第一次请求
    StudentMainVo getStudentMainFirst();
}
