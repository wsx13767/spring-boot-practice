package com.siang.springboot.practice.springbootpractice.mvc.repository;

import com.siang.springboot.practice.springbootpractice.mvc.database.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Integer> {

}
