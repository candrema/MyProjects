package com.ratemygame.main.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.ratemygame.DTO.ReviewDTO;
import com.ratemygame.DTO.UserDTO;
import com.ratemygame.entity.Game;
import com.ratemygame.entity.User;
import com.ratemygame.services.HomepageService;

@Controller
public class MainController {

	@Autowired
	private HomepageService homepageService;


	@GetMapping("/homepage")
	public String getMainPage(Model model) {
		return homepageService.loadHomePage(model);
	}

	@GetMapping("/game/{id}")
	public String getGame(@PathVariable("id") String id, Model model) {
		
		Game game = homepageService.getGame(Long.valueOf(id));
		model.addAttribute("gameDetails", homepageService.getGameDetails(Long.valueOf(id)));
		model.addAttribute("gameDetailsPath", homepageService.getGameDetailsPath());
		model.addAttribute("gameId", id);
		model.addAttribute("reviews", game.getReviews());
		model.addAttribute("media", game.getMedia());
		model.addAttribute("game", game );
		model.addAttribute("newReview", new ReviewDTO());
		return "gamepage";
	}

	@PutMapping("/game/submitReview")
	public String submitReview(@ModelAttribute("newReview") ReviewDTO newReview,
							   BindingResult result,
							   Model model) {
		
		newReview.setUser((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
		homepageService.saveReview(newReview);
		return "gamepage";
	}
	
	@PostMapping("/login")
	public String login(HttpServletRequest req,
			@ModelAttribute("user") UserDTO user,
			BindingResult result,
			Model model) throws AuthenticationException, Exception {
		
		homepageService.doLogin(req, user.getUsername(), user.getPassword());
	    return homepageService.loadHomePage(model);
	    
	}

}
