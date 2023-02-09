package com.example.demo.Models;

import javax.persistence.*;
import java.util.List;


@Entity
public class Student {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "Student Name")
    String studentName;
    @Column(name = "Student Age")
    Integer studentAge;

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    List<Course> courseList;


    public void setId(Integer id) {
        this.id = id;
    }
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setStudentAge(Integer studentAge) {
        this.studentAge = studentAge;
    }

    public Integer getId() {
        return id;
    }

    public String getStudentName() {
        return studentName;
    }

    public Integer getStudentAge() {
        return studentAge;
    }

}
