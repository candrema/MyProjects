package com.ratemygame.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ratemygame.DTO.UserDTO;
import com.ratemygame.services.UserDetailsServiceImpl;

@RestController
public class AuthController {
	
	@Autowired
	private UserDetailsServiceImpl userService;

	@PostMapping("/doLogin")
	public UserDTO login(){	
		return userService.getLoginUserDTO();
	}
	
	@PostMapping("/doRegister")
	public UserDTO register(@RequestBody UserDTO user){	
		return userService.registerUser(user);
	}

}
