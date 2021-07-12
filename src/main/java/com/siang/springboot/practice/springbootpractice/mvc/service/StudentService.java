package com.siang.springboot.practice.springbootpractice.mvc.service;

import com.siang.springboot.practice.springbootpractice.model.Student;
import com.siang.springboot.practice.springbootpractice.mvc.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentService {

    @Autowired
    private StudentDao studentDao;

    public Student findById(Integer studentId) {
        return studentDao.getById(studentId);
    }
}
