package com.example.demo.Controllers;

import com.example.demo.Models.Course;
import com.example.demo.Models.Mark;
import com.example.demo.Models.Student;
import com.example.demo.RequestObject.CourseRequestForCreateDateUpdate;
import com.example.demo.Services.MarkServices;
import com.example.demo.Slack.SlackClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping(value = "mark")
public class MarkController {

    @Autowired
    MarkServices markServices  ;
@Autowired
    SlackClient slackClient;


    @RequestMapping(value="mark/getById", method = RequestMethod.GET)
    public Mark getMArkById(@RequestParam Integer id){
        Mark mArk = markServices.getMarkById(id);
        slackClient.sendMessage("Mark id is :\t"+mArk.getId()+"\t Mark Grade : \t"+mArk.getGrade()+"\t Mark ObtainMark \t"+mArk.getObtainMark()+"\t Mark Course Name :\t"+mArk.getCourse().getCourseName());
        return mArk;
    }

    @RequestMapping(value="mark/getAll", method = RequestMethod.GET)
    public List<Mark> getAllMark(){
        List<Mark> mark = markServices.getAllMark();
        for (Mark mArk:mark) {
            slackClient.sendMessage("Mark id is :\t"+mArk.getId()+"\t Mark Grade : \t"+mArk.getGrade()+"\t Mark ObtainMark \t"+mArk.getObtainMark()+"\t Mark Course Name :\t"+mArk.getCourse().getCourseName());


        }
        return mark;
    }


    @RequestMapping(value = "getAllMarksByIsActive")
    public List<Mark> getAllActiveMarks() {
        List<Mark> activeMarksList = markServices.getAllActiveMarks();
        for (Mark mArk:activeMarksList) {
            slackClient.sendMessage("Mark id is :\t"+mArk.getId()+"\t Mark Grade : \t"+mArk.getGrade()+"\t Mark ObtainMark \t"+mArk.getObtainMark()+"\t Mark Course Name :\t"+mArk.getCourse().getCourseName()+"\t Course Activation :"+mArk.getActive());


        }
        return activeMarksList;
    }


    @RequestMapping(value = "getAllNotMarksByIsActive")
    public List<Mark> getAllNotActiveMarks(){
        List<Mark>  activeMarksList = markServices.getAllNotActiveCourses();
        for (Mark mArk:activeMarksList) {
            slackClient.sendMessage("Mark id is :\t"+mArk.getId()+"\t Mark Grade : \t"+mArk.getGrade()+"\t Mark ObtainMark \t"+mArk.getObtainMark()+"\t Mark Course Name :\t"+mArk.getCourse().getCourseName()+"\t Course Activation :"+mArk.getActive());


        }
        return activeMarksList;
    }

    @RequestMapping(value="getLatest", method = RequestMethod.GET)
    public Mark getLatestCourse() {
        Mark mArk = markServices.getLatestMark();
        slackClient.sendMessage("Mark id is :\t"+mArk.getId()+"\t Mark Grade : \t"+mArk.getGrade()+"\t Mark ObtainMark \t"+mArk.getObtainMark()+"\t Mark Course Name :\t"+mArk.getCourse().getCourseName()+"\t Course Created Date :"+mArk.getCreatedDate());

        return mArk;
    }

    @RequestMapping(value = "getLatestUpdated", method = RequestMethod.GET)

    public Mark getLatestUpdated(){
        Mark mArk = markServices.getLatestUpdated();
        slackClient.sendMessage("Mark id is :\t"+mArk.getId()+"\t Mark Grade : \t"+mArk.getGrade()+"\t Mark ObtainMark \t"+mArk.getObtainMark()+"\t Mark Course Name :\t"+mArk.getCourse().getCourseName()+"\t Course UpdatedDate :"+mArk.getUpdatedDate());

        return mArk;

    }
    @RequestMapping(value = "getMarkCreatedAfterDate", method = RequestMethod.GET)
    public List<Mark> getMarkCreatedAfterDate(@RequestParam String date) throws ParseException {
        List<Mark> mark = markServices.getmarkCreatedAfterDate(date);
        for (Mark mArk:mark) {
            slackClient.sendMessage("Mark id is :\t"+mArk.getId()+"\t Mark Grade : \t"+mArk.getGrade()+"\t Mark ObtainMark \t"+mArk.getObtainMark()+"\t Mark Course Name :\t"+mArk.getCourse().getCourseName()+"\t Course Created Date :"+mArk.getCreatedDate());
        }

        return mark;
    }


    @RequestMapping(value = "getAllByGrade", method = RequestMethod.GET)
    public List<Mark> getAllByGrade(String grade)
    {
        List<Mark> marklistByGrade = markServices.getAllByGrade(grade);
        for (Mark mArk:marklistByGrade) {
            slackClient.sendMessage("Mark id is :\t"+mArk.getId()+"\t Mark Grade : \t"+mArk.getGrade()+"\t Mark ObtainMark \t"+mArk.getObtainMark()+"\t Mark Course Name :\t"+mArk.getCourse().getCourseName()+"\t Course Created Date :"+mArk.getCreatedDate());
        }
        return marklistByGrade;
    }

    @RequestMapping(value = "getByObtainedMarksMoreThan", method = RequestMethod.POST)
    public List<Mark> getByObtainedMarksMoreThan(Integer obtainMark)
    {
        List<Mark> marklistByObtain = markServices.getByObtainedMarksMoreThan(obtainMark);
        return marklistByObtain;
    }

    @RequestMapping(value = "getByObtainedMarksLessThan", method = RequestMethod.POST)
    public List<Mark> getByObtainedMarksLessThan(Integer obtainMark)
    {
        List<Mark> marklistByObtain = markServices.getByObtainedMarksLessThan(obtainMark);
        return marklistByObtain;
    }

    @RequestMapping(value = "getMarkByUpdatedDate", method = RequestMethod.GET)
    public Mark getMarkByUpdatedDate(@RequestParam String date, Integer id) throws ParseException {
        return markServices.getmarkByUpdatedDate(date);
    }

    @RequestMapping(value = "getMarksByCourseId", method = RequestMethod.GET)
    public List<Mark> getMarksByCourseId(@RequestParam Integer courseid) {

        return markServices.getMarksByCourseId(courseid);

    }

    @RequestMapping(value="getIdToDeleteMarkById", method = RequestMethod.POST)
    public Mark setIdToDeleteMarkById(@RequestParam Integer id){
        Mark mark = markServices.getIdToDeleteMarkById(id);
        return mark;
    }
    @RequestMapping(value="DeletedAllMark", method = RequestMethod.POST)
    public Mark setDeletedAllMark(){
        Mark mark = markServices.getDeletedAllmark();
        return mark;
    }

    @RequestMapping(value = "deleteAllMarksCreatedAfterDate", method = RequestMethod.POST)
    public String setDeleteAllMarksCreatedAfterDate(@RequestParam CourseRequestForCreateDateUpdate date) throws ParseException {
        markServices.getDeleteAllmarkCreatedAfterDate(date.getDate());
        String deleteAllMarksCreatedAfterDate = "deleteAllMarksCreatedAfterDate Succesfully";
        slackClient.sendMessage(deleteAllMarksCreatedAfterDate);
        return deleteAllMarksCreatedAfterDate;

    }


    @RequestMapping(value = "setDeleteMarksByCourseid", method = RequestMethod.POST)
    public String setDeleteMarksByCourseid(@RequestParam Integer courseid) throws ParseException {
        markServices.getDeleteCoursesByCourseid(courseid);
        String setDeleteMarksByCourseid = "setDeleteMarksByCourseid Succesfully";
        slackClient.sendMessage(setDeleteMarksByCourseid);
        return setDeleteMarksByCourseid;


    }



    @RequestMapping(value = "deleteCoursesByCreatedDate", method = RequestMethod.POST)
    public String setDeleteMarksByCreatedDate(@RequestParam CourseRequestForCreateDateUpdate date) throws ParseException {
        markServices.getDeletemarksByCreatedDate(date.getDate());
        String deleteCoursesByCreatedDate = "deleteCoursesByCreatedDate Succesfully";
        slackClient.sendMessage(deleteCoursesByCreatedDate);
        return deleteCoursesByCreatedDate;
    }

    @RequestMapping(value = "deleteCoursesByUpdatedDate", method = RequestMethod.POST)
    public String setDeleteMarkByUpdatedDate(@RequestParam CourseRequestForCreateDateUpdate date) throws ParseException {
        markServices.getsetDeletemarksByUpdatedDate(date.getDate());
        String deleteCoursesByUpdatedDate = "deleteCoursesByUpdatedDate Successfully";
        slackClient.sendMessage(deleteCoursesByUpdatedDate);
        return deleteCoursesByUpdatedDate;

    }


    @RequestMapping(value="addMark",method = RequestMethod.POST)
    public String addMark(){
        markServices.addMark();
        String mark = "Mark Add Successfully";
        slackClient.sendMessage(mark);
        return mark;

    }

    @RequestMapping(value="updateCreatedDateByUserInput",method = RequestMethod.POST)
    public String setCreatDateByUserInput(@RequestBody CourseRequestForCreateDateUpdate data) throws ParseException {
        markServices.setCreatDateByUserInput(data.getDate(), data.getId());
        String updateCreatedDateByUserInput = "updateCreatedDateByUserInput Successfully";
        slackClient.sendMessage(updateCreatedDateByUserInput);
        return updateCreatedDateByUserInput;

    }



}
