package com.siang.springboot.practice.springbootpractice.mvc.dao;

import com.siang.springboot.practice.springbootpractice.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class StudentDao {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public Student getById(Integer studentId) {
        String sql = "SELECT id, name FROM student WHERE id = :id";
        Map<String, Object> map = new HashMap<>();
        map.put("id", studentId);

        return namedParameterJdbcTemplate.query(sql, map, rs -> {
           if (rs.next()) {
               Student student = new Student();
               int id = rs.getInt("id");
               student.setId(id);
               student.setName(rs.getString("name"));
               return student;
           } else {
               return null;
           }
        });
    }
}
