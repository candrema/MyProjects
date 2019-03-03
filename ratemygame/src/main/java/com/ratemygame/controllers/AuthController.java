package com.ratemygame.controllers;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ratemygame.DTO.UserDTO;
import com.ratemygame.services.UserService;

@RestController
public class AuthController {
	
	@Autowired
	private UserService userService;

	@PostMapping("/doLogin/{email}/{password}")
	public UserDTO login(HttpServletRequest req, @PathVariable("email") String email, @PathVariable("password") String password)
			throws AuthenticationException, Exception {

		userService.doLogin(req, email, password);
		return userService.getUser();
	}

}
