package com.example.demo.Repositories;

import com.example.demo.Models.Mark;
import com.example.demo.Models.School;
import com.example.demo.Models.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentInterface extends CrudRepository<Student, Integer> {

    @Query("SELECT s FROM Student s")
    List<Student> getAllStudent();

    @Query(value = "SELECT s FROM Student s WHERE s.id =:id")
    Student getStudentById(@Param("id") Integer id);

    @Query(value = "SELECT st from Student st " +
            "WHERE st.school.id = :id ")
    List<Student> getStudentsBySchoolId(@Param("id") Integer id);



}
