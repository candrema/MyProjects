package com.ratemygame.wrapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.ratemygame.DTO.ReviewDTO;
import com.ratemygame.entity.Review;

public class ReviewWrapper {

	@Autowired
    private static ModelMapper modelMapper;
	
	public static ReviewDTO getUserDTO(Review review) {
		return modelMapper.map(review, ReviewDTO.class);
	}
	
	public static Review getUser(ReviewDTO reviewDTO) {
		return modelMapper.map(reviewDTO, Review.class);
	}
}
