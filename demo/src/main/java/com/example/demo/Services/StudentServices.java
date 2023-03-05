package com.example.demo.Services;

import com.example.demo.Models.Course;
import com.example.demo.Models.School;
import com.example.demo.Models.Student;
import com.example.demo.Repositories.SchoolInterfase;
import com.example.demo.Repositories.StudentInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class StudentServices {

    @Autowired
    StudentInterface studentInterface;
    @Autowired
    SchoolInterfase schoolInterfase;

//    public void addStudent(){
//        Student studentToInseert = new Student();
//        studentToInseert.setStudentName("Ahd Yahya");
//        studentToInseert.setStudentAge(29);
//        studentInterface.save(studentToInseert);
//    }
//    public void deleteStudent(@RequestParam Integer id){
//        Student studentToDelete = studentInterface.findById(id).get();
//        studentInterface.delete(studentToDelete);
//    }
public List<Student> getAllStudent(){

    return studentInterface.getAllStudent();
}

    public Student getStudentById(Integer id){

        return studentInterface.getStudentById(id);
    }


    public List<Student> getStudentsBySchoolName(String schoolName){
        School school = schoolInterfase.getBySchoolName(schoolName);
        Integer schoolId = school.getId();
        List<Student> studentList = studentInterface.getStudentsBySchoolId(schoolId);
        return studentList;
    }

    public List<Student> getAllActiveStudents(){

        return studentInterface.getAllActiveStudent();
    }

    public List<Student> getAllNotActiveStudents(){

        return studentInterface.getAllNotActiveStudent();
    }

    public Student getLatestStudent(){
        return studentInterface.getLatestStudent();
    }
    public Student getIdToDeleteStudentById(Integer id){

        return studentInterface.getIdToDeleteStudentById(id);
    }


}
