package com.siang.springboot.practice.springbootpractice.database.myjdbc.repository;

import com.siang.springboot.practice.springbootpractice.database.myjdbc.entity.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Integer> {

    List<Student> findByName(String name);

    Student findByIdAndName(Integer id, String name);

    @Query(value = "SELECT s FROM Student s WHERE s.sex = ?1", nativeQuery = true)
    List<Student> findBySex(String sex);
}
