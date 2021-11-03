package com.siang.springboot.practice.springbootpractice.service.impl;

import com.siang.springboot.practice.springbootpractice.database.entity.Student;
import com.siang.springboot.practice.springbootpractice.database.repository.StudentRepository;
import com.siang.springboot.practice.springbootpractice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student findById(Integer id) {
        return studentRepository.findById(id).get();
    }
}
