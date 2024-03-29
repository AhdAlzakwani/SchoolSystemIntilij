package com.example.demo.malling.service;

import com.example.demo.malling.Interface.EmailInterface;
import com.example.demo.malling.models.EmailDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.List;

@Service
public class EmailService  implements EmailInterface {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String sender;

    @Override
    public String sentSimpleMailToMany(EmailDetails emailDetails) {

        // Try block to check for exceptions
        try {

            // Creating a simple mail message
            SimpleMailMessage mailMessage = new SimpleMailMessage();

            List<String> mailingList = emailDetails.getRecipient();
            for (String email : mailingList) {
                // Setting up necessary details
                mailMessage.setFrom(sender);
                mailMessage.setTo(email);
                mailMessage.setText(emailDetails.getMsgBody());
                mailMessage.setSubject(emailDetails.getSubject());

                // Sending the mail
                javaMailSender.send(mailMessage);
            }

            return "Mail Sent Successfully...";
        }

// Catch block to handle the exceptions
        catch (Exception e) {
            return "Error while Sending Mail";
        }

    }

    @Override
    public String sendSimpleMail(EmailDetails emailDetails) {
        try {

            // Creating a simple mail message
            SimpleMailMessage mailMessage = new SimpleMailMessage();

          //  String mailingList = emailDetails.getRecipient().toString();

                // Setting up necessary details
                mailMessage.setFrom(sender);
                mailMessage.setTo(emailDetails.getRecipient().get(0));
                mailMessage.setText(emailDetails.getMsgBody());
                mailMessage.setSubject(emailDetails.getSubject());

                // Sending the mail
                javaMailSender.send(mailMessage);


            return "Mail Sent Successfully...";
        }

// Catch block to handle the exceptions
        catch (Exception e) {
            return "Error while Sending Mail";
        }

    }

    @Override
    public String sendMailWithAttachmentToMany(EmailDetails emailDetails) {
        // Creating a mime message
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;

        try {
            List<String> mailingList = emailDetails.getRecipient();

            // Setting multipart as true for attachments to
            // be send
            mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(sender);
            mimeMessageHelper.setText(emailDetails.getMsgBody());
            mimeMessageHelper.setSubject(emailDetails.getSubject());

            // Adding the attachment
            FileSystemResource file = new FileSystemResource(new File(emailDetails.getAttachment()));

            mimeMessageHelper.addAttachment(file.getFilename(), file);

            // Sending the mail
            for (String email : mailingList) {
                mimeMessageHelper.setTo(email);
                javaMailSender.send(mimeMessage);
            }

            return "Mail sent Successfully";
        }

        // Catch block to handle MessagingException
        catch (MessagingException e) {

            // Display message when exception occurred
            return "Error while sending mail!!!";

        }

    }

    @Override
    public String sendMailWithAttachment(EmailDetails emailDetails) {
        // Creating a mime message
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;

        try {
            String mailingList = emailDetails.getRecipient().toString();

            // Setting multipart as true for attachments to
            // be send
            mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(sender);
            mimeMessageHelper.setTo(emailDetails.getRecipient().get(0));
            mimeMessageHelper.setText(emailDetails.getMsgBody());
            mimeMessageHelper.setSubject(emailDetails.getSubject());

            // Adding the attachment
            FileSystemResource file = new FileSystemResource(new File(emailDetails.getAttachment()));

            mimeMessageHelper.addAttachment(file.getFilename(), file);

            // Sending the mail
            javaMailSender.send(mimeMessage);


            return "Mail sent Successfully";
        }

        // Catch block to handle MessagingException
        catch (MessagingException e) {

            // Display message when exception occurred
            return "Error while sending mail!!!";

        }
    }
}
