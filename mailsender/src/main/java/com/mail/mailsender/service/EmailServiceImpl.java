package com.mail.mailsender.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.mail.mailsender.entity.UserToken;

import ratemygameCommon.entity.UserEmail;

@Service
public class EmailServiceImpl {
  
    @Autowired
    private JavaMailSender emailSender;
 
    public void sendSimpleMessage() {
        SimpleMailMessage message = new SimpleMailMessage(); 
        message.setTo("theguywithoutpants@gmail.com"); 
        message.setSubject("teste"); 
        message.setText("enviar email");
        emailSender.send(message);
    }
    
    public void sendTokenEmail(UserToken usertoken, UserEmail userEmail){
    	SimpleMailMessage message = new SimpleMailMessage(); 
        message.setTo(userEmail.getEmail()); 
        message.setSubject("Confirm your E-GamingReviews Email"); 
        message.setText("Please confirm your acount clicking on this link: blablalba?token=" + usertoken.getId());
        emailSender.send(message);
    }
}
