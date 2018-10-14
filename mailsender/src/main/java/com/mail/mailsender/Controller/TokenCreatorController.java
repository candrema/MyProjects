package com.mail.mailsender.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mail.mailsender.service.EmailServiceImpl;
import com.mail.mailsender.service.TokenService;

@RestController
public class TokenCreatorController {
	
	@Autowired
	private EmailServiceImpl emailservice;
	
	@Autowired
	private TokenService tokenService;
	
	@PostMapping("/createToken/{userId}")
	@ResponseStatus(value = HttpStatus.OK)
	public void createToken(@PathVariable("userId") long userId) {
		
		emailservice.sendTokenEmail(tokenService.createUserToken(userId));
		
	}
	
	@PostMapping("/validToken/{tokenId}")
	public void validToken(@PathVariable("id") long tokenId) {
		
	}

}
