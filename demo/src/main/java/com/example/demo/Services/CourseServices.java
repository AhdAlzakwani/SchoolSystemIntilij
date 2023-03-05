package com.example.demo.Services;

import com.example.demo.Models.Course;
import com.example.demo.Models.School;
import com.example.demo.Models.Student;
import com.example.demo.Repositories.CourseInterfase;
import com.example.demo.Repositories.SchoolInterfase;
import com.example.demo.Repositories.StudentInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServices {

    @Autowired
    CourseInterfase courseInterfase;
    @Autowired
    StudentInterface studentInterface ;



    public List<Course> getAllCourse(){
        return courseInterfase.getAllCourse();
    }

    public Course getCourseById(Integer id){

        return courseInterfase.getCourseById(id);
    }

    public List<Course> getAllActiveCourses(){

        return courseInterfase.getAllActiveCourses();
    }


    public List<Course> getCoursesByStudentName(String studentName){
        Student student = studentInterface.getByStudentName(studentName);
        Integer studentId = student.getId();
        List<Course> courseList = courseInterfase.getCourseByStudentId(studentId);
        return courseList;
    }


    public Course getLatestCourse(){
        return courseInterfase.getLatestCourse();
    }

    public Course getIdToDeleteCourseById(Integer id){

        return courseInterfase.getIdToDeleteCourseById(id);
    }

}
