package com.example.demo.Services;

import com.example.demo.Models.School;
import com.example.demo.Repositories.SchoolInterfase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class SchoolServices {

    @Autowired
    SchoolInterfase schoolInterfase;

    public List<School> getAllSchools(){
       return schoolInterfase.getAllSchools();
    }

    public School getSchoollById(Integer id)
    {
        return schoolInterfase.getSchoolById(id);

    }


    public School getBySchoolName(String schoolName)
    {
        return schoolInterfase.getBySchoolName(schoolName);
    }

    public List<School> getAllActiveSchools(){

        return schoolInterfase.getAllActiveSchools();
    }

    public List<School> getAllNotActiveSchools(){

        return schoolInterfase.getAllNotActiveSchools();
    }

    public School getLatestSchool(){
        return schoolInterfase.getLatestSchools();
    }
    public School getIdToDeleteSchoolById(Integer id){

        return schoolInterfase.getIdToDeleteSchoolById(id);
    }

    public School getDeletedAllSchool(){

        return schoolInterfase.getDeletedAllSchool();
    }




    public void setCreatDateByUserInput(String date, Integer id) throws ParseException {

        DateFormat formatter = new SimpleDateFormat("yyy-MM-dd");
        Date javaDate = formatter.parse(date);
        School school = schoolInterfase.getSchoolById(id);
        school.setCreatedDate(javaDate);
        schoolInterfase.save(school);

    }


    public void getDeleteAllSchoolsCreatedAfterDate(String date) throws ParseException {

        DateFormat formatter = new SimpleDateFormat("yyy-MM-dd");
        Date javaDate = formatter.parse(date);
        School school = schoolInterfase.getDeleteAllSchoolsCreatedAfterDate(javaDate);
        school.setActive(false);
        schoolInterfase.save(school);

    }

    public void getDeleteSchoolsByCreatedDate(String date) throws ParseException {

        DateFormat formatter = new SimpleDateFormat("yyy-MM-dd");
        Date javaDate = formatter.parse(date);
        School school = schoolInterfase.getDeleteSchoolsByCreatedDate(javaDate);
        school.setActive(false);
        schoolInterfase.save(school);

    }

    public void getsetDeleteSchoolsByUpdatedDate(String date) throws ParseException {

        DateFormat formatter = new SimpleDateFormat("yyy-MM-dd");
        Date javaDate = formatter.parse(date);
        School school = schoolInterfase.getsetDeleteSchoolsByUpdatedDate(javaDate);
        school.setActive(false);
        schoolInterfase.save(school);

    }

    public void getDeleteSchoolsBySchoolName(String schoolName) throws ParseException {

        School school = schoolInterfase.getDeleteSchoolsBySchoolName(schoolName);
        school.setActive(false);
        schoolInterfase.save(school);

    }

    public School getLatestUpdated() {


        return schoolInterfase.getLatestUpdated();
    }

    public School getSchoolCreatedAfterDate(String date) throws ParseException {
    DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    Date datecreated = format.parse(date);
    return schoolInterfase.getSchoolCreatedAfterDate(datecreated);
    }

    public School getSchoolByCreatedDate(String date) throws ParseException {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date datecreated = format.parse(date);
        return schoolInterfase.getSchoolByCreatedDate(datecreated);
    }

    public School getSchoolByUpdatedDate(String date) throws ParseException {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date datecreated = format.parse(date);
        return schoolInterfase.getSchoolByUpdatedDate(datecreated);
    }
}
