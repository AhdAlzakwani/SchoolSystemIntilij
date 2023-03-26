package com.example.demo.SchedulJob;

import com.example.demo.Models.Mark;
import com.example.demo.Services.CourseServices;
import com.example.demo.Services.MarkServices;
import com.example.demo.Slack.SlackClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Component
@RequestMapping(value = "SchedulCourse")
public class SchadulMark {
    @Autowired
    SlackClient slackClient;
    @Autowired
    MarkServices markServices;
    @Scheduled(cron = "0 */17 * * * *")
    public List<Mark> getAllMark(){
        List<Mark> mark = markServices.getAllMark();
        for (Mark mArk:mark) {
            slackClient.sendMessage("Mark id is :\t"+mArk.getId()+"\t Mark Grade : \t"+mArk.getGrade()+"\t Mark ObtainMark \t"+mArk.getObtainMark()+"\t Mark Course Name :\t"+mArk.getCourse().getCourseName());


        }
        return mark;
    }


    @Scheduled(cron = "0 */18 * * * *")
    public List<Mark> getAllActiveMarks() {
        List<Mark> activeMarksList = markServices.getAllActiveMarks();
        for (Mark mArk:activeMarksList) {
            slackClient.sendMessage("Mark id is :\t"+mArk.getId()+"\t Mark Grade : \t"+mArk.getGrade()+"\t Mark ObtainMark \t"+mArk.getObtainMark()+"\t Mark Course Name :\t"+mArk.getCourse().getCourseName()+"\t Course Activation :"+mArk.getActive());


        }
        return activeMarksList;
    }


    @Scheduled(cron = "0 */19 * * * *")
    public List<Mark> getAllNotActiveMarks(){
        List<Mark>  activeMarksList = markServices.getAllNotActiveCourses();
        for (Mark mArk:activeMarksList) {
            slackClient.sendMessage("Mark id is :\t"+mArk.getId()+"\t Mark Grade : \t"+mArk.getGrade()+"\t Mark ObtainMark \t"+mArk.getObtainMark()+"\t Mark Course Name :\t"+mArk.getCourse().getCourseName()+"\t Course Activation :"+mArk.getActive());


        }
        return activeMarksList;
    }

    @Scheduled(cron = "0 */20 * * * *")
    public Mark getLatestCourse() {
        Mark mArk = markServices.getLatestMark();
        slackClient.sendMessage("Mark id is :\t"+mArk.getId()+"\t Mark Grade : \t"+mArk.getGrade()+"\t Mark ObtainMark \t"+mArk.getObtainMark()+"\t Mark Course Name :\t"+mArk.getCourse().getCourseName()+"\t Course Created Date :"+mArk.getCreatedDate());

        return mArk;
    }

    @Scheduled(cron = "0 */21 * * * *")

    public Mark getLatestUpdated(){
        Mark mArk = markServices.getLatestUpdated();
        slackClient.sendMessage("Mark id is :\t"+mArk.getId()+"\t Mark Grade : \t"+mArk.getGrade()+"\t Mark ObtainMark \t"+mArk.getObtainMark()+"\t Mark Course Name :\t"+mArk.getCourse().getCourseName()+"\t Course UpdatedDate :"+mArk.getUpdatedDate());

        return mArk;

    }

}
