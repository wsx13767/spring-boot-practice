package com.siang.springboot.practice.springbootpractice.service;

import com.siang.springboot.practice.springbootpractice.dao.StudentDao;
import com.siang.springboot.practice.springbootpractice.database.myjdbc.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
public class StudentService {

    @Autowired
    private StudentDao studentDao;

    public Student findById(Integer studentId) {
        return studentDao.getById(studentId);
    }
}
