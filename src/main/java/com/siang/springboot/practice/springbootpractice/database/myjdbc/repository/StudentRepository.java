package com.siang.springboot.practice.springbootpractice.database.myjdbc.repository;

import com.siang.springboot.practice.springbootpractice.database.myjdbc.entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface StudentRepository extends CrudRepository<Student, Integer> {

}
