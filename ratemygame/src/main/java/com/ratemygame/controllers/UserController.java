package com.ratemygame.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ratemygame.DTO.UserDTO;
import com.ratemygame.services.UserDetailsServiceImpl;

@Controller
public class UserController {
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	@PostMapping("/createUser")
	public ResponseEntity<?> createUser(String username,
			String password,
			String email,
			Model model) {
		userDetailsService.createUser(new UserDTO(username, password, email));
		
		return ResponseEntity.ok("url");
	}
	
	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("user", new UserDTO());
		return "register";
	}
}
