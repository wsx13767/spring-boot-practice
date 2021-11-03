package com.siang.springboot.practice.springbootpractice.service.impl;

import com.siang.springboot.practice.springbootpractice.database.entity.Student;
import com.siang.springboot.practice.springbootpractice.database.repository.StudentRepository;
import com.siang.springboot.practice.springbootpractice.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentServiceImplTest {
    @Autowired
    private StudentService studentService;
    @MockBean
    private StudentRepository studentRepository;

    /**
     * 執行Test 方法前皆會執行此方法
     */
    @BeforeEach
    public void beforeEach() {
        Student student = new Student();
        student.setId(1);
        student.setName("MockTest");
        student.setGraduate(false);
        student.setScore(20.2);
        // 替換studentRepository.findById回傳的物件
        Mockito.when(studentRepository.findById(Mockito.any())).thenReturn(Optional.of(student));
    }

    @Test
    public void findId() {
        Student student = studentService.findById(1);
        assertNotNull(student);
        assertEquals(1, student.getId());
    }
}