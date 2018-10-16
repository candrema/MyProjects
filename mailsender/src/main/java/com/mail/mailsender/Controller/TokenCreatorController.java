package com.mail.mailsender.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mail.mailsender.entity.UserToken;
import com.mail.mailsender.service.EmailServiceImpl;
import com.mail.mailsender.service.TokenService;

import ratemygameCommon.entity.UserEmail;

@RestController
public class TokenCreatorController {
	
	@Autowired
	private EmailServiceImpl emailservice;
	
	@Autowired
	private TokenService tokenService;
	
	@PostMapping("/createToken")
	public HttpStatus createToken(@RequestBody UserEmail userEmail) {
		
		emailservice.sendTokenEmail(tokenService.createUserToken(userEmail.getUserId()), userEmail);
		return HttpStatus.OK;
	}
	
	@PostMapping("/validToken")
	public HttpStatus validToken(@RequestBody UserEmail userEmail) {
		
		int valid = tokenService.validateToken(userEmail);
		return valid == 1 ? HttpStatus.OK : HttpStatus.NOT_FOUND;
	}
	
	@GetMapping("/sendEmail")
	public HttpStatus sendEmail(@RequestBody UserEmail userEmail) {
		UserToken userToken = tokenService.getUserToken(userEmail.getToken());
		
		if(userToken != null) {
			emailservice.sendTokenEmail(userToken, userEmail);
			return HttpStatus.OK;
		}
		
		return HttpStatus.NOT_FOUND;
	}

}
