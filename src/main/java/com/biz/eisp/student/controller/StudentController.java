package com.biz.eisp.student.controller;

import com.biz.eisp.student.entity.Student;
import com.biz.eisp.student.service.StudentService;
import com.biz.eisp.student.vo.StudentMainVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;


/**
 * Created by king on 2017/5/3.
 */
@Controller
@RequestMapping("student")
public class StudentController {

    @Resource
    private StudentService studentService;


    @RequestMapping("/toModify/{id}")
    public ModelAndView goStudentForm(@PathVariable("id") Integer id){
        ModelAndView modelAndView = new ModelAndView("studentForm");
        Student student = studentService.getStudent(id);
        modelAndView.addObject("s", student);
        return modelAndView;
    }

    @RequestMapping("/toMain/{currentPage}")
    public ModelAndView goStudentMain(@PathVariable("currentPage") Integer currentPage){
        ModelAndView modelAndView = new ModelAndView("studentMain");
        StudentMainVo pageBean = studentService.getStudentMain(currentPage);
        modelAndView.addObject("pageBean",pageBean);
        return modelAndView;
    }

    @RequestMapping("/show")
    public ModelAndView showStudent(){
        ModelAndView modelAndView = new ModelAndView("studentMain");
        StudentMainVo studentMainVo = studentService.getStudentMainFirst();
        modelAndView.addObject("pageBean",studentMainVo);
        return modelAndView;
    }

    @RequestMapping("/save")
    public ModelAndView saveStudent(Student student){
        ModelAndView modelAndView = new ModelAndView("redirect:/student/show");
        studentService.saveOrModifyStudent(student);
        return modelAndView;
    }

    @RequestMapping("/delete/{id}")
    public ModelAndView deleteStudent(@PathVariable("id") Integer id){
        ModelAndView modelAndView = new ModelAndView("redirect:/student/show");
        studentService.deleteStudent(id);
        return modelAndView;
    }

    @RequestMapping("/toAdd")
    public String goStudentForm(){
        return "studentForm";
    }
}
