package com.ratemygame.services;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import com.ratemygame.DTO.UserDTO;
import com.ratemygame.config.SecurityConfig;

@Service
public class UserService {
	
	@Autowired
	private SecurityConfig securityConfig;
	
	public void doLogin(HttpServletRequest req, String username, String password) throws AuthenticationException, Exception {
		securityConfig.doLogin(req, username, password);
	}
	
	public UserDTO getUser() {
		return securityConfig.getLoginUserDTO();
	}

}
