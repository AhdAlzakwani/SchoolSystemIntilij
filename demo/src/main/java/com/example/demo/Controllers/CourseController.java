package com.example.demo.Controllers;

import com.example.demo.Models.Course;
import com.example.demo.Models.Student;
import com.example.demo.Services.CourseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "course")
public class CourseController {



    @Autowired
    CourseServices courseServices ;

    @RequestMapping(value="course/getAll", method = RequestMethod.GET)
    public List<Course> getAllCourse(){
        List<Course> course = courseServices.getAllCourse();
        return course;
    }

    @RequestMapping(value="course/getById", method = RequestMethod.GET)
    public Course getCourseById(@RequestParam Integer id){
        Course course = courseServices.getCourseById(id);
        return course;
    }

    @RequestMapping(value = "getAllCoursesByIsActive")
    public List<Course> getAllActiveCourses() {
        List<Course> activeCoursesList = courseServices.getAllActiveCourses();
        return activeCoursesList;
    }




}
