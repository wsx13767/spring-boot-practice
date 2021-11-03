package com.siang.springboot.practice.springbootpractice.controller;

import com.siang.springboot.practice.springbootpractice.database.entity.Student;
import com.siang.springboot.practice.springbootpractice.database.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.servlet.ServletContext;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class StudentControllerTest {
    @Autowired
    private MockMvc mockMvc;

    // 替換StudentRepository
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
    public void findById() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/student/1"))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andReturn();
        String body = mvcResult.getResponse().getContentAsString();
        System.out.println(body);
    }
}