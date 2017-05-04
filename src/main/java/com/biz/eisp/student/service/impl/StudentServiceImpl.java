package com.biz.eisp.student.service.impl;

import com.biz.eisp.student.dao.StudentRepository;
import com.biz.eisp.student.entity.Student;
import com.biz.eisp.student.service.StudentService;
import com.biz.eisp.student.vo.StudentMainVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by king on 2017/5/4.
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentRepository studentRepository;

    @Override
    public void deleteStudent(Integer id) {
        studentRepository.deleteStudent(id);
    }

    @Override
    public void saveOrModifyStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public Student getStudent(Integer id) {
        return studentRepository.findStudentById(id);
    }

    @Override
    public StudentMainVo getStudentMain(Integer currentPage) {

        List<Student> s = studentRepository.findAll();
        int size = s.size();
        if (currentPage < 0){
            currentPage = 0;
        } else if(currentPage > size-1){
            currentPage = size-1;
        }
        Sort sort = new Sort(Sort.Direction.DESC, "avgScore");
        Pageable pageable = new PageRequest(currentPage, 3, sort);
        Page<Student> page = studentRepository.findAll(pageable);
        StudentMainVo pageBean = new StudentMainVo();
        List<Student> students = page.getContent();
        int totalPage = page.getTotalPages();
        pageBean.setStudents(students);
        pageBean.setTotalPage(totalPage);
        pageBean.setCurrentPage(currentPage);
        return pageBean;
    }

    @Override
    public StudentMainVo getStudentMainFirst() {
        Pageable pageable = new PageRequest(0,3);
        Page<Student> page = studentRepository.findAll(pageable);
        StudentMainVo studentMainVo = new StudentMainVo();
        int totalPage = page.getTotalPages();
        List<Student> students = page.getContent();
        studentMainVo.setCurrentPage(0);
        studentMainVo.setTotalPage(totalPage);
        studentMainVo.setStudents(students);
        return studentMainVo;
    }
}
