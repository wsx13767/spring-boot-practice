package com.siang.springboot.practice.springbootpractice.controller;

import com.siang.springboot.practice.springbootpractice.database.myjdbc.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/student/jdbc")
public class StudentJDBCController {

    @Autowired
    @Qualifier("myJdbcJdbcTemplate")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @PostMapping("/insert")
    public String insertWithJDBC(@RequestBody Student student) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", student.getName());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update("INSERT INTO student(name) value (:name)", new MapSqlParameterSource(map),
                keyHolder);
        return "Student " + student.getName() + " id is " + keyHolder.getKey().intValue();
    }

    @DeleteMapping("/delete/{studentId}")
    public String deleteWithJDBC(@PathVariable Integer studentId) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", studentId);
        namedParameterJdbcTemplate.update("DELETE FROM student WHERE id = :id", map);

        return "Student id " + studentId + " is delete";
    }

    @PutMapping("/update")
    public String updateWithJDBC(@RequestBody Student student) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", student.getId());
        map.put("name", student.getName());
        namedParameterJdbcTemplate.update("UPDATE student SET name = :name WHERE id = :id", map);
        return "Student id " + student.getId() + " name has update to " + student.getName();
    }

    @GetMapping("/getALL")
    public List<Student> getALLWithJDBC() {
        return namedParameterJdbcTemplate.query("SELECT id, name FROM student",(rs, index) -> {
            Student student = new Student();
            student.setId(rs.getInt("id"));
            student.setName(rs.getString("name"));
            return student;
        });
    }

    @GetMapping("/getById/{studentId}")
    public Student getByIdWithJDBC(@PathVariable Integer studentId) {
        Map<String, Object> map = new HashMap<>();
        String sql = "SELECT id, name FROM student WHERE id = :id";
        map.put("id", studentId);

        return namedParameterJdbcTemplate.query(sql, map, rs -> {
            if (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                return student;
            } else {
                return null;
            }
        });
    }
}
