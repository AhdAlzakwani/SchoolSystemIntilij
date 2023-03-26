package com.example.demo.Controllers;

import com.example.demo.Models.School;
import com.example.demo.RequestObject.SchoolRequest;
import com.example.demo.RequestObject.SchoolRequestForCreateDateUpdate;
import com.example.demo.Services.SchoolServices;
import com.example.demo.Slack.SlackClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping(value = "school")
public class SchoolController {
    @Autowired
    SchoolServices schoolServices;
@Autowired
SlackClient slackClient;


    @RequestMapping(value="school/getById", method = RequestMethod.GET)
    public School getSchoollById(@RequestParam Integer id){
        School school = schoolServices.getSchoollById(id);
        slackClient.sendMessage("+++ school/getById +++");

        slackClient.sendMessage("School Id is:"+school.getId().toString());
        slackClient.sendMessage("SchoolName is :"+school.getName());
        return school;
    }
    @RequestMapping(value="school/getAll", method = RequestMethod.GET)
    public List<School> getAllSchool(){
        List<School> schools = schoolServices.getAllSchools();
        slackClient.sendMessage("+++ school/getAll +++");

        for (School s:schools) {
            slackClient.sendMessage("School Id is:"+s.getName());
            slackClient.sendMessage("SchoolName is :"+s.getId());
        }

        return schools;
    }

    @RequestMapping(value = "getAllSchoolByIsActive")
    public List<School> getAllActiveSchools(){
        List<School>  activeSchoolsList = schoolServices.getAllActiveSchools();
        slackClient.sendMessage("+++ school/getAllSchoolByIsActive +++");

        for (School s:activeSchoolsList) {
            slackClient.sendMessage("School Id is:"+s.getId());
            slackClient.sendMessage("School Name is :"+s.getName());
            slackClient.sendMessage("School Activation  :"+s.getActive());

        }

        return activeSchoolsList;
    }

    @RequestMapping(value = "getAllSchoolByIsNotActive")
    public List<School> getAllNotActiveSchools(){
        List<School>  activeSchoolsList = schoolServices.getAllNotActiveSchools();
        slackClient.sendMessage("+++ school/getAllSchoolByIsNotActive +++");
        for (School s:activeSchoolsList) {

            slackClient.sendMessage("School Id is:"+s.getId());
            slackClient.sendMessage("School Name is :"+s.getName());
            slackClient.sendMessage("School Activation  :"+s.getActive());

        }
        return activeSchoolsList;
    }

    @RequestMapping(value="getLatest", method = RequestMethod.GET)
    public School getLatestSchool() {
        School schools = schoolServices.getLatestSchool();
        slackClient.sendMessage("+++ school/getLatest +++");

        slackClient.sendMessage("School Id is:"+schools.getId());
        slackClient.sendMessage("School Name is :"+schools.getName());
        slackClient.sendMessage("School Activation  :"+schools.getActive());
        slackClient.sendMessage("School CreatedDate  :"+schools.getCreatedDate());
        return schools;
    }

    @RequestMapping(value = "getLatestUpdated", method = RequestMethod.GET)

    public School getLatestUpdated(){
        School school = schoolServices.getLatestUpdated();
        slackClient.sendMessage("+++ school/getLatestUpdated +++");
        slackClient.sendMessage("School Id is:"+school.getId());
        slackClient.sendMessage("School Name is :"+school.getName());
        slackClient.sendMessage("School Activation  :"+school.getActive());
        slackClient.sendMessage("School UpdatedDate  :"+school.getUpdatedDate());

        return school;

    }

    @RequestMapping(value = "getSchoolCreatedAfterDate", method = RequestMethod.GET)
    public <list>School getSchoolCreatedAfterDate(@RequestParam String date) throws ParseException {
        School school = schoolServices.getSchoolCreatedAfterDate(date);
        slackClient.sendMessage("+++ school/getSchoolCreatedAfterDate +++");
            slackClient.sendMessage("School Id is:"+school.getId());
            slackClient.sendMessage("School Name is :"+school.getName());
            slackClient.sendMessage("School Activation  :"+school.getActive());
            slackClient.sendMessage("School CreatedDate  :"+school.getCreatedDate());
        return school;
    }

    @RequestMapping(value="school/getBySchoolName", method = RequestMethod.GET)
    public School getSchoolByName(@RequestParam String schoolName) {
        School school = schoolServices.getBySchoolName(schoolName);
        slackClient.sendMessage("+++ school/getBySchoolName +++");
        slackClient.sendMessage("School Id is:"+school.getId());
        slackClient.sendMessage("School Name is :"+school.getName());
        slackClient.sendMessage("School Activation  :"+school.getActive());
        slackClient.sendMessage("School CreatedDate  :"+school.getCreatedDate());

        return school;
    }



    @RequestMapping(value = "getSchoolByCreatedDate", method = RequestMethod.GET)
    public School getSchoolByCreatedDate(@RequestParam String date) throws ParseException {
        School school = schoolServices.getSchoolByCreatedDate(date);
        slackClient.sendMessage("+++ school/getSchoolByCreatedDate +++");
        slackClient.sendMessage("School Id is:"+school.getId());
        slackClient.sendMessage("School Name is :"+school.getName());
        slackClient.sendMessage("School Activation  :"+school.getActive());
        slackClient.sendMessage("School CreatedDate  :"+school.getCreatedDate());
        return school;
    }

    @RequestMapping(value = "getSchoolByUpdatedDate", method = RequestMethod.GET)
    public School getSchoolByUpdatedDate(@RequestParam String date, Integer id) throws ParseException {
        School school =schoolServices.getSchoolByUpdatedDate(date);
        slackClient.sendMessage("+++ school/getSchoolByUpdatedDate +++");
        slackClient.sendMessage("School Id is:"+school.getId());
        slackClient.sendMessage("School Name is :"+school.getName());
        slackClient.sendMessage("School Activation  :"+school.getActive());
        slackClient.sendMessage("School CreatedDate  :"+school.getCreatedDate());
        return school;
    }


    ////getSchoolByNumberOfStudents
@RequestMapping(value = "getSchoolByNumberOfStudents", method = RequestMethod.GET)
public List<School> getSchoolByNumberOfStudents(@RequestParam Integer numberOfStudents){

   List<School> school =schoolServices.getSchoolByNumberOfStudents(numberOfStudents);
    slackClient.sendMessage("+++ school/getSchoolByNumberOfStudents +++");
    for (School s:school) {
        slackClient.sendMessage("School Id is:"+s.getId());
        slackClient.sendMessage("School Name is :"+s.getName());
        slackClient.sendMessage("School Activation  :"+s.getActive());
        slackClient.sendMessage("School CreatedDate  :"+s.getCreatedDate());
    }

    return school;
}


    @RequestMapping(value="getIdToDeleteSchoolById", method = RequestMethod.POST)
    public School setIdToDeleteSchoolById(@RequestParam Integer id){
        School school = schoolServices.getIdToDeleteSchoolById(id);
        slackClient.sendMessage("+++ school/getIdToDeleteSchoolById +++");
        slackClient.sendMessage("School Id is:"+school.getId() +"School Name is :"+school.getName()+
                "School Activation  :"+school.getActive()+"School CreatedDate  :"+school.getCreatedDate());

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
