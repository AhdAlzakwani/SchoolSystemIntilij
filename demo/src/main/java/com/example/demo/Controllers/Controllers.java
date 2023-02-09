package com.example.demo.Controllers;

import com.example.demo.Services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Entity;
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

    @GetMapping(value ="addStudent")
    public String addStudent(){

        studentServices.addStudent();
        return "Student Add Successfull";

    }
    @GetMapping(value ="deleteStudent")
    public String deleteStudentById(Integer id){

        studentServices.deleteStudent(id);
        return "Student Delete Successfull";
    }



}
