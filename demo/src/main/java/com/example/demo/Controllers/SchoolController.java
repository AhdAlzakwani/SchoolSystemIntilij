package com.example.demo.Controllers;

import com.example.demo.Models.School;
import com.example.demo.RequestObject.SchoolRequest;
import com.example.demo.RequestObject.SchoolRequestForCreateDateUpdate;
import com.example.demo.Services.SchoolServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping(value = "school")
public class SchoolController {
    @Autowired
    SchoolServices schoolServices;


    @RequestMapping(value="school/getById", method = RequestMethod.GET)
    public School getSchoollById(@RequestParam Integer id){
        School school = schoolServices.getSchoollById(id);
        return school;
    }
    @RequestMapping(value="school/getAll", method = RequestMethod.GET)
    public List<School> getAllSchool(){
        List<School> schools = schoolServices.getAllSchools();
        return schools;
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

    @RequestMapping(value="getLatest", method = RequestMethod.GET)
    public School getLatestSchool() {
        School schools = schoolServices.getLatestSchool();
        return schools;
    }

    @RequestMapping(value = "getLatestUpdated", method = RequestMethod.GET)

    public School getLatestUpdated(){
        School school = schoolServices.getLatestUpdated();
        return school;

    }

    @RequestMapping(value = "getSchoolCreatedAfterDate", method = RequestMethod.GET)
    public <list>School getSchoolCreatedAfterDate(@RequestParam String date) throws ParseException {
        School school = schoolServices.getSchoolCreatedAfterDate(date);
        return school;
    }

    @RequestMapping(value="school/getBySchoolName", method = RequestMethod.GET)
    public School getSchoolByName(@RequestParam String schoolName) {
        School school = schoolServices.getBySchoolName(schoolName);
        return school;
    }



    @RequestMapping(value = "getSchoolByCreatedDate", method = RequestMethod.GET)
    public School getSchoolByCreatedDate(@RequestParam String date) throws ParseException {
        return schoolServices.getSchoolByCreatedDate(date);
    }

    @RequestMapping(value = "getSchoolByUpdatedDate", method = RequestMethod.GET)
    public School getSchoolByUpdatedDate(@RequestParam String date, Integer id) throws ParseException {
        return schoolServices.getSchoolByUpdatedDate(date);
    }


    ////getSchoolByNumberOfStudents
@RequestMapping(value = "getSchoolByNumberOfStudents", method = RequestMethod.GET)
public List<School> getSchoolByNumberOfStudents(@RequestParam Integer numberOfStudents){
    return schoolServices.getSchoolByNumberOfStudents(numberOfStudents);
}


    @RequestMapping(value="getIdToDeleteSchoolById", method = RequestMethod.POST)
    public School setIdToDeleteSchoolById(@RequestParam Integer id){
        School school = schoolServices.getIdToDeleteSchoolById(id);
        return school;
    }


    @RequestMapping(value="DeletedAllSchool", method = RequestMethod.POST)
    public School setDeletedAllStudent(){
        School school = schoolServices.getDeletedAllSchool();
        return school;
    }

    @RequestMapping(value = "deleteAllSchoolsCreatedAfterDate", method = RequestMethod.POST)
    public void setDeleteAllSchoolsCreatedAfterDate(@RequestParam SchoolRequestForCreateDateUpdate date) throws ParseException {
        schoolServices.getDeleteAllSchoolsCreatedAfterDate(date.getDate());

    }


    @RequestMapping(value = "deleteSchoolsBySchoolName", method = RequestMethod.POST)
    public void setDeleteSchoolsBySchoolName(@RequestParam String schoolName) throws ParseException {
        schoolServices.getDeleteSchoolsBySchoolName(schoolName);

    }


    @RequestMapping(value = "deleteSchoolsByCreatedDate", method = RequestMethod.POST)
    public void setDeleteSchoolsByCreatedDate(@RequestParam SchoolRequestForCreateDateUpdate date) throws ParseException {
        schoolServices.getDeleteSchoolsByCreatedDate(date.getDate());

    }

    @RequestMapping(value = "deleteSchoolsByUpdatedDate", method = RequestMethod.POST)
    public void setDeleteSchoolsByUpdatedDate(@RequestParam SchoolRequestForCreateDateUpdate date) throws ParseException {
        schoolServices.getsetDeleteSchoolsByUpdatedDate(date.getDate());

    }





    @RequestMapping (value ="addSchool", method = RequestMethod.POST)
    public String addSchool(){
        schoolServices.addSchool();
        return "School Add Successfull";

    }

    @RequestMapping(value="updateCreatedDateByUserInput",method = RequestMethod.POST)
    public void setCreatDateByUserInput(@RequestBody SchoolRequestForCreateDateUpdate data) throws ParseException {
        schoolServices.setCreatDateByUserInput(data.getDate(), data.getId());
    }






}
