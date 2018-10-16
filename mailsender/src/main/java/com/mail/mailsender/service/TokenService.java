package com.mail.mailsender.service;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mail.mailsender.entity.UserToken;
import com.mail.mailsender.repository.UserTokenRepository;

import ratemygameCommon.entity.UserEmail;

@Service
public class TokenService {
	
	@Autowired
	private UserTokenRepository userTokenRepository;
	
	
	public UserToken createUserToken(Long userId) {
		
		String token = UUID.randomUUID().toString();
		UserToken usertoken = new UserToken();
		usertoken.setId(token);
		usertoken.setUserId(userId);
		Date date = new Date();
		usertoken.setTimestamp(date);
		usertoken.setValid(0);
		userTokenRepository.save(usertoken);
		return usertoken;
		
	}

	@Transactional(readOnly = true)
	public int validateToken(UserEmail userEmail) {
		
		Optional<UserToken> optional = userTokenRepository.findByIdAndUserId(userEmail.getToken(), userEmail.getUserId());
		
		return optional.orElse(new UserToken()).getValid();
	}
	
	public UserToken getUserToken(String token) {
		Optional<UserToken> optional = userTokenRepository.findById(token);
		return optional.orElse(null);
	}
}
