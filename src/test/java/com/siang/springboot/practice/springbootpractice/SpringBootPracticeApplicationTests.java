package com.siang.springboot.practice.springbootpractice;


import com.siang.springboot.practice.springbootpractice.dao.StudentDao;
import com.siang.springboot.practice.springbootpractice.database.myjdbc.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class SpringBootPracticeApplicationTests {

	@Autowired
	private StudentDao studentDao;

	@Test
	public void contextLoads() {
//		assertNotNull(studentDao.getById());
	}

}
