package com.siang.springboot.practice.springbootpractice.controller;

import com.siang.springboot.practice.springbootpractice.database.myjdbc.entity.Student;
import com.siang.springboot.practice.springbootpractice.database.myjdbc.repository.StudentRepository;
import com.siang.springboot.practice.springbootpractice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student/jpa")
public class StudentJPAController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/insert")
    public String insert(@RequestBody Student student) {
        studentRepository.save(student);
        return "執行Create操作";
    }

    @GetMapping("/getById/{studentId}")
    public Student select(@PathVariable Integer studentId) {
        return studentService.findById(studentId);
    }

    @GetMapping("/getByName/{name}")
    public List<Student> findByName(@PathVariable String name) {
        return studentRepository.findByName(name);
    }

    @GetMapping("/getBySex/{sex}")
    public List<Student> findBySex(@PathVariable String sex) {
        return studentRepository.findBySex(sex);
    }

    @GetMapping("/getByIdAndName/{id}/{name}")
    public Student findByIdAndName(@PathVariable Integer id, @PathVariable String name) {
        return studentRepository.findByIdAndName(id, name);
    }

    @PutMapping("/update")
    public Student update(Student student) throws Exception {
        if (studentRepository.findById(student.getId()) != null) {
            return studentRepository.save(student);
        }

        throw new Exception("查無此ID");
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        studentRepository.deleteById(id);
        return "執行刪除成功";
    }

    @GetMapping("/queryAll")
    public Iterable<Student> queryAll() {
        return studentRepository.findAll();
    }


}
