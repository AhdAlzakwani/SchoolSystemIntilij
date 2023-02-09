package com.example.demo.Models;

import javax.persistence.*;

@Entity
public class Mark {
    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
        Integer id;
        Integer obtainMark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getObtainMark() {
        return obtainMark;
    }

    public void setObtainMark(Integer obtainMark) {
        this.obtainMark = obtainMark;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
    @Column(name = "Course Grade")
    String grade;

}
