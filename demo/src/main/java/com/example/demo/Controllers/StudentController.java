package com.example.demo.Controllers;

import com.example.demo.Models.School;
import com.example.demo.Models.Student;
import com.example.demo.RequestObject.SchoolRequestForCreateDateUpdate;
import com.example.demo.RequestObject.StudentRequestForCreateDateUpdate;
import com.example.demo.Services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping(value = "student")
public class StudentController {
    @Autowired
    StudentServices studentServices;
    @RequestMapping(value="student/getById", method = RequestMethod.GET)
    public Student getStudentById(@RequestParam Integer id){
        Student student = studentServices.getStudentById(id);
        return student;
    }
    @RequestMapping(value="student/getAll", method = RequestMethod.GET)
    public List<Student> getAllStudent(){
        List<Student> student = studentServices.getAllStudent();
        return student;
    }




    @RequestMapping(value = "getAllStudentByIsActive")
    public List<Student> getAllActiveStudents(){
        List<Student>  activeStudentsList = studentServices.getAllActiveStudents();
        return activeStudentsList;
    }

    @RequestMapping(value = "getAllNotStudentByIsActive")
    public List<Student> getAllNotActiveStudents(){
        List<Student>  activeStudentsList = studentServices.getAllNotActiveStudents();
        return activeStudentsList;
    }

    @RequestMapping(value="getLatest", method = RequestMethod.GET)
    public Student getLatestStudent() {
        Student student = studentServices.getLatestStudent();
        return student;
    }

    @RequestMapping(value = "getLatestUpdated", method = RequestMethod.GET)

    public Student getLatestUpdated(){
        Student student = studentServices.getLatestUpdated();
        return student;

    }
    @RequestMapping(value = "getStudentCreatedAfterDate", method = RequestMethod.GET)
    public <list>Student getSchoolCreatedAfterDate(@RequestParam String date) throws ParseException {
        Student student = studentServices.getStudentCreatedAfterDate(date);
        return student;
    }

    @RequestMapping(value = "getStudentByCreatedDate", method = RequestMethod.GET)
    public Student getSchoolByCreatedDate(@RequestParam String date) throws ParseException {
        return studentServices.getStudentByCreatedDate(date);
    }

    @RequestMapping(value = "getStudentByUpdatedDate", method = RequestMethod.GET)
    public Student getStudentByUpdatedDate(@RequestParam String date, Integer id) throws ParseException {
        return studentServices.getStudentByUpdatedDate(date);
    }






    @RequestMapping(value="getIdToDeleteStudentById", method = RequestMethod.GET)
    public Student getIdToDeleteStudentById(@RequestParam Integer id){
        Student student = studentServices.getIdToDeleteStudentById(id);
        return student;
    }

    @RequestMapping(value="DeletedAllStudent", method = RequestMethod.POST)
    public Student setDeletedAllStudent(){
        Student student = studentServices.getDeletedAllStudent();
        return student;
    }

    @RequestMapping(value = "deleteAllStudentsCreatedAfterDate", method = RequestMethod.POST)
    public void setDeleteAllStudentsCreatedAfterDate(@RequestParam StudentRequestForCreateDateUpdate date) throws ParseException {
        studentServices.setDeleteAllStudentsCreatedAfterDate(date.getDate());

    }

    @RequestMapping(value = "deleteStudentsByCreatedDate", method = RequestMethod.POST)
    public void setDeleteStudentsByCreatedDate(@RequestParam StudentRequestForCreateDateUpdate date) throws ParseException {
        studentServices.getDeleteStudentsByCreatedDate(date.getDate());

    }

    @RequestMapping(value = "deleteStudentsByUpdatedDate", method = RequestMethod.POST)
    public void setDeleteStudentsByUpdatedDate(@RequestParam StudentRequestForCreateDateUpdate date) throws ParseException {
        studentServices.setDeleteStudentsByUpdatedDate(date.getDate());

    }

    @RequestMapping(value = "deleteStudentsBySchoolName", method = RequestMethod.POST)
    public void setDeleteStudentsBySchoolName(@RequestParam String studentName) throws ParseException {
        studentServices.getDeleteStudentsByStudentName(studentName);

    }


    @RequestMapping(value="updateCreatedDateByUserInput",method = RequestMethod.POST)
    public void setCreatDateByUserInput(@RequestBody StudentRequestForCreateDateUpdate data) throws ParseException {
        studentServices.setCreatDateByUserInput(data.getDate(), data.getId());
    }

}
