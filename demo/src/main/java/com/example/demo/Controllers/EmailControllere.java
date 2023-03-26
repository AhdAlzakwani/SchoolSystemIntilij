package com.example.demo.Controllers;

import com.example.demo.Slack.SlackClient;
import com.example.demo.malling.models.EmailDetails;
import com.example.demo.malling.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "mail")
public class EmailControllere {
    @Autowired
    EmailService emailService;

    @Autowired
    SlackClient slackClient;


    // Sending a simple Email
    @PostMapping("/sendMail")
    public String sendMail(@RequestBody EmailDetails details) {
        String status = emailService.sendSimpleMail(details);

        slackClient.sendMessage(status);
        return status;
    }

    // Sending email with attachment
    @PostMapping("/sendMailWithAttachment")
    public String sendMailWithAttachment(@RequestBody EmailDetails details) {
        String status = emailService.sendMailWithAttachment(details);

        return status;
    }



}
