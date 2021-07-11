package com.siang.springboot.practice.springbootpractice.controller;

import com.siang.springboot.practice.springbootpractice.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @PostMapping
    public String insert(@RequestBody Student student) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", student.getName());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update("INSERT INTO student(name) value (:name)", new MapSqlParameterSource(map),
                keyHolder);
        return "Student " + student.getName() + " id is " + keyHolder.getKey().intValue();
    }

    @DeleteMapping("/{studentId}")
    public String delete(@PathVariable Integer studentId) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", studentId);
        namedParameterJdbcTemplate.update("DELETE FROM student WHERE id = :id", map);

        return "Student id " + studentId + " is delete";
    }

    @PutMapping
    public String update(@RequestBody Student student) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", student.getId());
        map.put("name", student.getName());
        namedParameterJdbcTemplate.update("UPDATE student SET name = :name WHERE id = :id", map);
        return "Student id " + student.getId() + " name has update to " + student.getName();
    }

    @GetMapping
    public List<Student> selectAll() {
        return namedParameterJdbcTemplate.query("SELECT id, name FROM student",(rs, index) -> {
            Student student = new Student();
            student.setId(rs.getInt("id"));
            student.setName(rs.getString("name"));
            return student;
        });
    }

    @GetMapping("/{studentId}")
    public Student select(@PathVariable Integer studentId) {
        Map<String, Object> map = new HashMap<>();
        String sql = "SELECT id, name FROM student WHERE id = :id";
        map.put("id", studentId);

        return namedParameterJdbcTemplate.query(sql, map, rs -> {
            Student student = new Student();
            student.setId(rs.getInt("id"));
            student.setName(rs.getString("name"));
            return student;
        });
    }
}
