package com.example.demo.Controllers;

import com.example.demo.Models.School;
import com.example.demo.Services.SchoolServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "school")
public class SchoolController {
    @Autowired
    SchoolServices schoolServices;

    @RequestMapping(value="school/getAll", method = RequestMethod.GET)
    public List<School> getAllSchool(){
        List<School> schools = schoolServices.getAllSchools();
        return schools;
    }

    @RequestMapping(value="school/getById", method = RequestMethod.GET)
    public School getSchoollById(@RequestParam Integer id){
        School school = schoolServices.getSchoollById(id);
        return school;
    }

    public School getSchoolById(@RequestParam Integer schoolId) {
        School school = schoolServices.getSchoollById(schoolId);
        return school;
    }

    @RequestMapping(value = "getAllSchoolByIsActive")
    public List<School> getAllActiveSchools(){
        List<School>  activeSchoolsList = schoolServices.getAllActiveSchools();
        return activeSchoolsList;
    }

    @RequestMapping(value = "getAllSchoolByIsNotActive")
    public List<School> getAllNotActiveSchools(){
        List<School>  activeSchoolsList = schoolServices.getAllNotActiveSchools();
        return activeSchoolsList;
    }




}
