package com.siang.springboot.practice.springbootpractice.database.repository;

import com.siang.springboot.practice.springbootpractice.database.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Integer> {
}
