package com.example.demo.Repositories;

import com.example.demo.Models.Course;
import com.example.demo.Models.Mark;
import com.example.demo.Models.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarkInterfase extends CrudRepository<Student, Integer> {

    @Query("SELECT m FROM Mark m")
    List<Mark> getAllMark();

    @Query(value = "SELECT m FROM Mark m WHERE m.id =:id")
    Mark getMarkById(@Param("id") Integer id);

    @Query(value = "SELECT s from Mark s where s.isActive = true")
    List<Mark> getAllActiveMarks();

}
