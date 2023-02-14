package com.example.demo.Controllers;

import com.example.demo.Models.School;
import com.example.demo.Models.Student;
import com.example.demo.Services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "student")
public class StudentController {
    @Autowired
    StudentServices studentServices;

    @RequestMapping(value="student/getAll", method = RequestMethod.GET)
    public List<Student> getAllStudent(){
        List<Student> student = studentServices.getAllStudent();
        return student;
    }


    @RequestMapping(value="student/getById", method = RequestMethod.GET)
    public Student getStudentById(@RequestParam Integer id){
        Student student = studentServices.getStudentById(id);
        return student;
    }

    @RequestMapping(value = "getAllStudentByIsActive")
    public List<Student> getAllActiveStudents(){
        List<Student>  activeStudentsList = studentServices.getAllActiveStudents();
        return activeStudentsList;
    }
}
