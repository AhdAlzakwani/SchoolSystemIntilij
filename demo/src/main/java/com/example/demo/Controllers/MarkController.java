package com.example.demo.Controllers;

import com.example.demo.Models.Course;
import com.example.demo.Models.Mark;
import com.example.demo.RequestObject.CourseRequestForCreateDateUpdate;
import com.example.demo.Services.MarkServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping(value = "mark")
public class MarkController {

    @Autowired
    MarkServices markServices  ;



    @RequestMapping(value="mark/getAll", method = RequestMethod.GET)
    public List<Mark> getAllMark(){
        List<Mark> mark = markServices.getAllMark();
        return mark;
    }


    @RequestMapping(value="mark/getById", method = RequestMethod.GET)
    public Mark getMArkById(@RequestParam Integer id){
        Mark mArk = markServices.getMarkById(id);
        return mArk;
    }

    @RequestMapping(value = "getAllMarksByIsActive")
    public List<Mark> getAllActiveMarks() {
        List<Mark> activeMarksList = markServices.getAllActiveMarks();
        return activeMarksList;
    }

    @RequestMapping(value="getLatest", method = RequestMethod.GET)
    public Mark getLatestCourse() {
        Mark mark = markServices.getLatestMark();
        return mark;
    }

    @RequestMapping(value = "getLatestUpdated", method = RequestMethod.GET)

    public Mark getLatestUpdated(){
        Mark mark = markServices.getLatestUpdated();
        return mark;

    }
    @RequestMapping(value = "getMarkCreatedAfterDate", method = RequestMethod.GET)
    public <list>Mark getMarkCreatedAfterDate(@RequestParam String date) throws ParseException {
        Mark mark = markServices.getmarkCreatedAfterDate(date);
        return mark;
    }

    @RequestMapping(value = "getMarkByCreatedDate", method = RequestMethod.GET)
    public Mark getMarkByCreatedDate(@RequestParam String date) throws ParseException {
        return markServices.getmarkByCreatedDate(date);
    }

    @RequestMapping(value = "getSchoolByUpdatedDate", method = RequestMethod.GET)
    public Mark getCourseByUpdatedDate(@RequestParam String date, Integer id) throws ParseException {
        return markServices.getmarkByUpdatedDate(date);
    }
    @RequestMapping(value="getIdToDeleteSchoolById", method = RequestMethod.POST)
    public Mark setIdToDeleteSchoolById(@RequestParam Integer id){
        Mark mark = markServices.getIdToDeleteMarkById(id);
        return mark;
    }


    @RequestMapping(value="DeletedAllMark", method = RequestMethod.POST)
    public Mark setDeletedAllMark(){
        Mark mark = markServices.getDeletedAllmark();
        return mark;
    }

    @RequestMapping(value = "deleteAllMarksCreatedAfterDate", method = RequestMethod.POST)
    public void setDeleteAllMarksCreatedAfterDate(@RequestParam CourseRequestForCreateDateUpdate date) throws ParseException {
        markServices.getDeleteAllmarkCreatedAfterDate(date.getDate());

    }

    @RequestMapping(value = "deleteCoursesByCreatedDate", method = RequestMethod.POST)
    public void setDeleteMarksByCreatedDate(@RequestParam CourseRequestForCreateDateUpdate date) throws ParseException {
        markServices.getDeletemarksByCreatedDate(date.getDate());

    }

    @RequestMapping(value = "deleteCoursesByUpdatedDate", method = RequestMethod.POST)
    public void setDeleteMarkByUpdatedDate(@RequestParam CourseRequestForCreateDateUpdate date) throws ParseException {
        markServices.getsetDeletemarksByUpdatedDate(date.getDate());

    }

    @RequestMapping(value = "setDeleteMarksByCourseid", method = RequestMethod.POST)
    public void setDeleteMarksByCourseid(@RequestParam Integer courseid) throws ParseException {
        markServices.getDeleteCoursesByCourseid(courseid);

    }


    @RequestMapping(value="updateCreatedDateByUserInput",method = RequestMethod.POST)
    public void setCreatDateByUserInput(@RequestBody CourseRequestForCreateDateUpdate data) throws ParseException {
        markServices.setCreatDateByUserInput(data.getDate(), data.getId());
    }


    @RequestMapping(value="getIdToDeleteCourseById", method = RequestMethod.GET)
    public Mark getIdToDeleteCourseById(@RequestParam Integer id){
        Mark mark = markServices.getIdToDeleteMarkById(id);
        return mark;
    }

}
