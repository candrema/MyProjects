package com.ratemygame.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ratemygame.DTO.ReviewDTO;
import com.ratemygame.repository.ReviewRepository;
import com.ratemygame.wrapper.GameWrapper;

@Service
public class ReviewService {
	
	@Autowired
    private GameWrapper gameMapper;
	
	@Autowired
	private ReviewRepository reviewRepository;
	
	@Transactional
	public void saveReview(ReviewDTO review) {
		reviewRepository.save(gameMapper.getReview(review));
	}

}
