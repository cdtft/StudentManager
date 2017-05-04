package com.biz.eisp.student.dao;

import com.biz.eisp.student.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by king on 2017/5/3.
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Modifying
    @Transactional
    @Query("delete from Student t where t.id = ?1")
    void deleteStudent(Integer id);

    Page<Student> findAll(Pageable pageable);

    Student findStudentById(Integer id);
}
