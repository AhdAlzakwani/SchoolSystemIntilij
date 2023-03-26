package com.example.demo.SchedulJob;

import com.example.demo.Models.Student;
import com.example.demo.Services.StudentServices;
import com.example.demo.Slack.SlackClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Component
@RequestMapping(value = "SchedulStudent")
public class SchedulStudent {

    @Autowired
    SlackClient slackClient;
    @Autowired
    StudentServices studentServices;

    @Scheduled(cron = "0 */7 * * * *")
    public List<Student> getAllStudent() {
        List<Student> student = studentServices.getAllStudent();

        slackClient.sendMessage("+++ student/getAll +++");
        for (Student s : student) {
            slackClient.sendMessage("Student Id is:" + s.getId() + "\t Student Name is :" + s.getStudentName() +
                    "\t Student Activation  :" + s.getActive() + "\t Student CreatedDate  :" + s.getCreatedDate());
        }

        return student;
    }


    @Scheduled(cron = "0 */8 * * * *")
    public List<Student> getAllActiveStudents() {
        List<Student> activeStudentsList = studentServices.getAllActiveStudents();
        slackClient.sendMessage("+++ student/getAllStudentByIsActive +++");
        for (Student s : activeStudentsList) {
            slackClient.sendMessage("Student Id is:" + s.getId() + "\t Student Name is :" + s.getStudentName() +
                    "\t Student Activation  :" + s.getActive() + "\t Student CreatedDate  :" + s.getCreatedDate());
        }

        return activeStudentsList;
    }

    @Scheduled(cron = "0 */9 * * * *")
    public List<Student> getAllNotActiveStudents() {
        List<Student> activeStudentsList = studentServices.getAllNotActiveStudents();

        slackClient.sendMessage("+++ student/getAllNotStudentByIsActive +++");
        for (Student s : activeStudentsList) {
            slackClient.sendMessage("Student Id is:" + s.getId() + "\t Student Name is :" + s.getStudentName() +
                    "\t Student Activation  :" + s.getActive() + "\t Student CreatedDate  :" + s.getCreatedDate());
        }
        return activeStudentsList;
    }

    @Scheduled(cron = "0 */10 * * * *")
    public Student getLatestStudent() {
        Student student = studentServices.getLatestStudent();
        slackClient.sendMessage("+++ student/getLatest +++");

        slackClient.sendMessage("Student Id is:" + student.getId() + "\t Student Name is :" + student.getStudentName() +
                "\t Student Activation  :" + student.getActive() + "\t Student CreatedDate  :" + student.getCreatedDate());
        return student;
    }

    @Scheduled(cron = "0 */11 * * * *")
    public Student getLatestUpdated() {
        Student student = studentServices.getLatestUpdated();

        slackClient.sendMessage("+++ student/getLatestUpdated +++");

        slackClient.sendMessage("Student Id is:" + student.getId() + "\t Student Name is :" + student.getStudentName() +
                "\t Student Activation  :" + student.getActive() + "\t Student CreatedDate  :" + student.getCreatedDate());
        return student;

    }

}
