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





//    @RequestMapping(value="student/getByName", method = RequestMethod.GET)
//    public List<Student> getSchoollByName(@RequestParam String name){
//        return studentServices.getSchoollByName(name);
//    }
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


    @RequestMapping(value = "student/getStudentsBySchoolName", method = RequestMethod.GET)
    public List<Student> getStudentsBySchoolName(@RequestParam String schoolName) {

        return studentServices.getStudentsBySchoolName(schoolName);

    }

    @RequestMapping(value = "student/getCoursesByStudentName", method = RequestMethod.GET)
    public List<Course> getCoursesByStudentName(@RequestParam String StudentName) {

        return courseServices.getCoursesByStudentName(StudentName);

    }


    @RequestMapping(value = "student/getMarksByCourseName", method = RequestMethod.GET)
    public List<Mark> getMarksByCourseName(@RequestParam String CourseName) {

        return markServices.getMarksByCourseName(CourseName);

    }
}
