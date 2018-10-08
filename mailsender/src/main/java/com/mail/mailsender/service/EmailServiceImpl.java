package com.mail.mailsender.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import entity.UserToken;

@Component
public class EmailServiceImpl {
  
    @Autowired
    public JavaMailSender emailSender;
 
    public void sendSimpleMessage() {
        SimpleMailMessage message = new SimpleMailMessage(); 
        message.setTo("theguywithoutpants@gmail.com"); 
        message.setSubject("teste"); 
        message.setText("enviar email");
        emailSender.send(message);
    }
    
    public void sendTokenEmail(UserToken usertoken){
    	SimpleMailMessage message = new SimpleMailMessage(); 
        message.setTo("theguywithoutpants@gmail.com"); 
        message.setSubject("Confirm your account e-gamingreviews"); 
        message.setText("Please confirm your acount clicking on this link: blablalba?token=" + usertoken.getId());
        emailSender.send(message);
    }
    
    
    
}
