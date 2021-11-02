package com.siang.springboot.practice.springbootpractice.controller;

import com.siang.springboot.practice.springbootpractice.dao.StudentDao;
import com.siang.springboot.practice.springbootpractice.database.myjdbc.entity.Student;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class PrinterControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private StudentDao studentDao;

    @Test
    public void test() {
        Student mockStudent = new Student();
        mockStudent.setId(100);
        mockStudent.setName("TTT");
        Mockito.when(studentDao.getById(Mockito.any())).thenReturn(mockStudent);

        Student student = studentDao.getById(3);
        assertEquals("TTT", student.getName());

    }

    @Test
    public void showInfo() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/printer/info/sharp");
        MvcResult mvcResult = mockMvc.perform(requestBuilder)
                .andExpect(status().is(200)).andReturn();
        String body = mvcResult.getResponse().getContentAsString();
        System.out.println(body);
    }
}