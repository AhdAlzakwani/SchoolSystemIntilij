package com.example.demo.Repositories;

import com.example.demo.Models.Course;
import com.example.demo.Models.School;
import com.example.demo.Models.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseInterfase extends CrudRepository<Student, Integer> {
    @Query("SELECT c FROM Course c")
    List<Course> getAllCourse();


    @Query(value = "SELECT s FROM Course s WHERE s.id =:id")
    Course getCourseById(@Param("id") Integer id);

    @Query(value = "SELECT s from Course s where s.isActive = true")
    List<Course> getAllActiveCourses();

    @Query(value = "SELECT st from Course st " +
            "WHERE st.student.id = :id ")
    List<Course> getCourseByStudentId(@Param("id") Integer id);

    @Query(value = "SELECT s from Course s " +
            "WHERE s.CourseName = :courseName")
    Course getByCourseName(@Param("courseName") String courseName);

    @Query(value = "SELECT s from Course s where s.id=(SELECT max(s.id) from Course s)")
    Course getLatestCourse();

    @Query(value = "UPDATE Student s SET s.isActive = false WHERE s.id =:id")
    Course getIdToDeleteCourseById(@Param("id") Integer id);


}
