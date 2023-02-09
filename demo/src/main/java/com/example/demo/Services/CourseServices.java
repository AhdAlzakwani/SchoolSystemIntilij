package com.example.demo.Services;

import com.example.demo.Models.Course;
import com.example.demo.Models.School;
import com.example.demo.Repositories.CourseInterfase;
import com.example.demo.Repositories.SchoolInterfase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServices {

    @Autowired
    CourseInterfase courseInterfase;


    public List<Course> getAllCourse(){
        return courseInterfase.getAllCourse();
    }

}
