package com.example.demo.Controllers;

import com.example.demo.Models.Course;
import com.example.demo.Models.Mark;
import com.example.demo.Models.School;
import com.example.demo.Models.Student;
import com.example.demo.Services.CourseServices;
import com.example.demo.Services.MarkServices;
import com.example.demo.Services.SchoolServices;
import com.example.demo.Services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@RestController
public class Controllers {
    @GetMapping(value ="hello")
    public String getHello(){
        return "hello To TechnoPark";
    }
    @GetMapping(value ="fullName")
    public String getFullName(String firstName, String lastName){
        firstName = "AHD ";
        lastName = "ALZAKWANI";
        return "My Name Is "+firstName+" "+lastName;
    }
    @Autowired
    StudentServices studentServices;
    @Autowired
    SchoolServices schoolServices;
    @Autowired
    CourseServices courseServices ;

    @Autowired
    MarkServices markServices  ;

    @RequestMapping(value="student/getAll", method = RequestMethod.GET)
    public List<Student> getAllStudent(){
        List<Student> student = studentServices.getAllStudent();
        return student;
    }
    @RequestMapping(value="school/getAll", method = RequestMethod.GET)
    public List<School> getAllSchool(){
        List<School> schools = schoolServices.getAllSchools();
        return schools;
    }

    @RequestMapping(value="course/getAll", method = RequestMethod.GET)
    public List<Course> getAllCourse(){
        List<Course> course = courseServices.getAllCourse();
        return course;
    }

    @RequestMapping(value="mark/getAll", method = RequestMethod.GET)
    public List<Mark> getAllMark(){
        List<Mark> mark = markServices.getAllMark();
        return mark;
    }

    @RequestMapping(value="school/getById", method = RequestMethod.GET)
    public School getSchoollById(@RequestParam Integer id){
       School school = schoolServices.getSchoollById(id);
       return school;
    }
//    @GetMapping(value ="addStudent")
//    public String addStudent(){
//
//        studentServices.addStudent();
//        return "Student Add Successfull";
//
//    }
//    @GetMapping(value ="deleteStudent")
//    public String deleteStudentById(Integer id){
//
//        studentServices.deleteStudent(id);
//        return "Student Delete Successfull";
//    }



}
