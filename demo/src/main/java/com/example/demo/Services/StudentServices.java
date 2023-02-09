package com.example.demo.Services;

import com.example.demo.Models.Student;
import com.example.demo.Repositories.StudentInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class StudentServices {

    @Autowired
    StudentInterface studentInterface;

    public void addStudent(){
        Student studentToInseert = new Student();
        studentToInseert.setStudentName("Ahd Yahya");
        studentToInseert.setStudentAge(29);
        studentInterface.save(studentToInseert);
    }
    public void deleteStudent(@RequestParam Integer id){
        Student studentToDelete = studentInterface.findById(id).get();
        studentInterface.delete(studentToDelete);
    }

}
