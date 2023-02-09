package com.example.demo.Repositories;

import com.example.demo.Models.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentInterface extends CrudRepository<Student, Integer> {



}
