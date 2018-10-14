package com.mail.mailsender.service;

import java.util.Date;
import java.util.UUID;

import org.springframework.stereotype.Service;

import entity.UserToken;

@Service
public class TokenService {
		
	
	public UserEmail createUserToken(long userId) {
		
		String token = UUID.randomUUID().toString();
		UserToken usertoken = new UserToken();
		usertoken.setId(token);
		usertoken.setUserId(userId);
		Date date = new Date();
		usertoken.setTimestamp(date);
		
		return new UserEmail();
		
	}

}
