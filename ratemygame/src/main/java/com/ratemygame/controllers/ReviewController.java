package com.ratemygame.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ratemygame.services.ReviewService;

@RestController
public class ReviewController {
	
	@Autowired
	private ReviewService reviewService;

	@PostMapping("/review/submit")
	public void getTopGames() {
		return reviewService.saveReview(review);
	}

}
