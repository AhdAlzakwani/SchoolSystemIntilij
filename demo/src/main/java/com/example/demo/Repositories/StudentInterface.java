package com.example.demo.Repositories;

import com.example.demo.Models.Mark;
import com.example.demo.Models.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentInterface extends CrudRepository<Student, Integer> {

    @Query("SELECT s FROM Student s")
    List<Student> getAllStudent();

}