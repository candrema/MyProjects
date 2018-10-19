package com.ratemygame.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PutMapping;

import com.ratemygame.DTO.UserDTO;
import com.ratemygame.services.UserDetailsServiceImpl;

@Controller
public class UserController {
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	@PutMapping("/createUser")
	public String createUser(@ModelAttribute("user") UserDTO userDTO) {
		userDetailsService.createUser(userDTO);
		return "/homepage";
	}
	
	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("user", new UserDTO());
		return "register";
	}
}
