package com.example.demo.Models;

import javax.persistence.*;
import java.util.List;


public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
@Column(name = "School Name")
    String Name;
   List<Student> studentList;



    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }



}
