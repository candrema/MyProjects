package com.ratemygame.main.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
public class MainController {
	
	@GetMapping("/mainpage")
	public String getMainPage(Model model) {
		return "mainpage";
	}

}