package com.ratemygame.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ratemygame.DTO.UserDTO;
import com.ratemygame.services.UserDetailsServiceImpl;

@Controller
public class UserController {
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	@PutMapping("/createUser")
	public void createUser(@RequestBody UserDTO userDTO) {
		userDetailsService.createUser(userDTO);
	}
}
