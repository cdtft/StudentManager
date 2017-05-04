package com.biz.eisp.student.dao;

import com.biz.eisp.student.entity.Student;
import org.junit.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by king on 2017/5/3.
 */
public class TestStudentDao extends BasicTest {

    @Resource
    private StudentRepository studentRepository;

    @Test
    public void testDelete(){
        Student student = new Student();
        student.setId(2);
        student.setAvgScore(5);
        student.setName("lee");
        studentRepository.save(student);
    }

    @Test
    public void testFindAll(){
        Sort sort = new Sort(Sort.Direction.ASC, "avgScore");
        Pageable pageable = new PageRequest(1,1, sort);
        Page<Student> page = studentRepository.findAll(pageable);
        List<Student> students = page.getContent();
        int currentPage = page.getTotalPages();
    }

    @Test
    public void testGetOne(){
        studentRepository.getOne(1);
    }

    @Test
    public void testFindStudentById(){
        studentRepository.findStudentById(3);
    }
}
