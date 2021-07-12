package com.siang.springboot.practice.springbootpractice.mvc.controller;

import com.siang.springboot.practice.springbootpractice.model.Student;
import com.siang.springboot.practice.springbootpractice.mvc.repository.StudentRepository;
import com.siang.springboot.practice.springbootpractice.mvc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mvc/student")
public class StudentControllerV2 {
    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/{studentId}")
    public Student select(@PathVariable Integer studentId) {
        return studentService.findById(studentId);
    }

    @PostMapping
    public String insert(@RequestBody com.siang.springboot.practice.springbootpractice.mvc.database.entity.Student student) {
        studentRepository.save(student);
        return "執行Create操作";
    }

}
