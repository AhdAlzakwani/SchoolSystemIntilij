package com.example.demo.SchedulJob;

import com.example.demo.Models.Course;
import com.example.demo.Services.CourseServices;
import com.example.demo.Services.StudentServices;
import com.example.demo.Slack.SlackClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Component
@RequestMapping(value = "SchedulCourse")
public class SchedulCourse {

    @Autowired
    SlackClient slackClient;
    @Autowired
    CourseServices courseServices;

    @Scheduled(cron = "0 */12 * * * *")
    public List<Course> getAllCourse(){
        List<Course> course = courseServices.getAllCourse();
        for (Course c:course) {
            slackClient.sendMessage("Course id is :\t "+c.getId().toString()+"\t Course name is: \t"+c.getCourseName());

        }
        return course;
    }



    @Scheduled(cron = "0 */13 * * * *")
    public List<Course> getAllActiveCourses() {
        List<Course> activeCoursesList = courseServices.getAllActiveCourses();
        for (Course c:activeCoursesList) {
            slackClient.sendMessage("Course id is :\t "+c.getId().toString()+"\t Course name is: \t"+c.getCourseName()+"Course Activation :\t"+c.getActive());
        }
        return activeCoursesList;
    }

    @Scheduled(cron = "0 */14 * * * *")
    public List<Course> getAllNotActiveCourses(){
        List<Course>  activeCoursesList = courseServices.getAllNotActiveCourses();
        for (Course c:activeCoursesList) {
            slackClient.sendMessage("Course id is :\t "+c.getId().toString()+"\t Course name is: \t"+c.getCourseName()+"Course Activation :\t"+c.getActive());
        }
        return activeCoursesList;
    }


    @Scheduled(cron = "0 */15 * * * *")
    public Course getLatestCourse() {
        Course course = courseServices.getLatestCourse();
        slackClient.sendMessage("Course id is :\t "+course.getId().toString()+"\t Course name is: \t"+course.getCourseName()+"Course Lastest created :\t"+course.getCreatedDate());
        return course;
    }
    @Scheduled(cron = "0 */16 * * * *")

    public Course getLatestUpdated(){
        Course course = courseServices.getLatestUpdated();
        slackClient.sendMessage("Course id is :\t "+course.getId().toString()+"\t Course name is: \t"+course.getCourseName()+"Course Lastest Update :\t"+course.getUpdatedDate());

        return course;

    }
}
