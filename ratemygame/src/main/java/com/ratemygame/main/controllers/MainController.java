package com.ratemygame.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ratemygame.entity.User;
import com.ratemygame.services.HomepageService;

@Controller
public class MainController {

	@Autowired
	private HomepageService homepageService;

	@GetMapping("/homepage")
	public String getMainPage(Model model) {
		model.addAttribute("bigGames", homepageService.getBigGames());
		model.addAttribute("bigGamesPath", homepageService.getBigImagePath());

		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		model.addAttribute("username", user.getName());
		return "homepage";
	}

	@GetMapping("/getGame/{id}")
	public String getGame(@PathVariable("id") String id, Model model) {

		model.addAttribute("gameDetails", homepageService.getGameDetails(Long.valueOf(id)));
		model.addAttribute("gameDetailsPath", homepageService.getGameDetailsPath());
		model.addAttribute("gameId", id);
		model.addAttribute("reviews", homepageService.getGame(Long.valueOf(id)).getReviews());
		return "homepage";
	}

}
