package com.example.demo.Services;

import com.example.demo.Models.School;
import com.example.demo.Models.Student;
import com.example.demo.Repositories.SchoolInterfase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolServices {

    @Autowired
    SchoolInterfase schoolInterfase;

    public List<School> getAllSchools(){
       return schoolInterfase.getAllSchools();
    }

    public School getSchoollById(Integer id){

        return schoolInterfase.getSchoollById(id);
    }
}
