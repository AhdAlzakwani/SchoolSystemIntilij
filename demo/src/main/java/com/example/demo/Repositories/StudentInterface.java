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

    @Query(value = "SELECT s from Student s where s.isActive = true")
    List<Student> getAllActiveStudent();
    @Query(value = "SELECT s from Student s where s.isActive = false")
    List<Student> getAllNotActiveStudent();

    @Query(value = "SELECT s from Student s " +
            "WHERE s.studentName = :studentName")
    Student getByStudentName(@Param("studentName") String studentName);

    @Query(value = "SELECT s from Student s where s.id=(SELECT max(s.id) from Student s)")
    Student getLatestStudent();

    @Query(value = "UPDATE Student s SET s.isActive = false WHERE s.id =:id")
    Student getIdToDeleteStudentById(@Param("id") Integer id);


}
