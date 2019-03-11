package com.ratemygame.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ratemygame.DTO.ReviewDTO;
import com.ratemygame.services.ReviewService;

@RestController
public class ReviewController {

	@Autowired
	private ReviewService reviewService;

	@PostMapping("/review/submit")
	public void submitReview(@RequestBody ReviewDTO review) {

		reviewService.saveReview(review);

	}
	
	@GetMapping("/reviews")
	public List<ReviewDTO> getReviews(@RequestParam("gameId") long gameId) {
		
		return reviewService.getReviews(gameId);
	}

}
