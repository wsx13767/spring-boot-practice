package com.siang.springboot.practice.springbootpractice.service;

import com.siang.springboot.practice.springbootpractice.database.entity.Student;

public interface StudentService {
    Student findById(Integer id);
}
