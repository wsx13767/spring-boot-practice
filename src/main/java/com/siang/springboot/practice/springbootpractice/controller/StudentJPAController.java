package com.siang.springboot.practice.springbootpractice.controller;

import com.siang.springboot.practice.springbootpractice.model.Student;
import com.siang.springboot.practice.springbootpractice.database.myjdbc.repository.StudentRepository;
import com.siang.springboot.practice.springbootpractice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student/jpa")
public class StudentJPAController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/getById/{studentId}")
    public Student select(@PathVariable Integer studentId) {
        return studentService.findById(studentId);
    }

    @PostMapping
    public String insert(@RequestBody com.siang.springboot.practice.springbootpractice.database.myjdbc.entity.Student student) {
        studentRepository.save(student);
        return "執行Create操作";
    }

}
