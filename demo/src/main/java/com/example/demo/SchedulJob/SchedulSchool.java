package com.example.demo.SchedulJob;

import com.example.demo.Models.School;
import com.example.demo.Services.SchoolServices;
import com.example.demo.Slack.SlackClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Component
@RequestMapping(value = "SchedulSchool")
public class SchedulSchool {

    @Autowired
    SlackClient slackClient;
    @Autowired
    SchoolServices schoolServices;
    @Scheduled(cron = "0 */3 * * * *")
    public List<School> getAllSchool(){
        List<School> schools = schoolServices.getAllSchools();
        slackClient.sendMessage("+++ school/getAll +++");
        for (School s:schools) {
            slackClient.sendMessage("School Id is:"+s.getName());
            slackClient.sendMessage("SchoolName is :"+s.getId());
        }

        return schools;
    }
    @Scheduled(cron = "0 */5 * * * *")
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
    @Scheduled(cron = "0 */2 * * * *")
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
    @Scheduled(cron = "0 */4 * * * *")

    public School getLatestSchool() {
        School schools = schoolServices.getLatestSchool();
        slackClient.sendMessage("+++ school/getLatest +++");
        slackClient.sendMessage("School Id is:"+schools.getId());
        slackClient.sendMessage("School Name is :"+schools.getName());
        slackClient.sendMessage("School Activation  :"+schools.getActive());
        slackClient.sendMessage("School CreatedDate  :"+schools.getCreatedDate());
        return schools;
    }

    @Scheduled(cron = "0 */6 * * * *")
    public School getLatestUpdated(){
        School school = schoolServices.getLatestUpdated();
        slackClient.sendMessage("+++ school/getLatestUpdated +++");
        slackClient.sendMessage("School Id is:"+school.getId());
        slackClient.sendMessage("School Name is :"+school.getName());
        slackClient.sendMessage("School Activation  :"+school.getActive());
        slackClient.sendMessage("School UpdatedDate  :"+school.getUpdatedDate());

        return school;

    }




}
