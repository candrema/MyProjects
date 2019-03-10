package com.ratemygame.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ratemygame.DTO.ReviewDTO;
import com.ratemygame.entity.Review;
import com.ratemygame.repository.ReviewRepository;
import com.ratemygame.wrapper.GameWrapper;

@Service
public class ReviewService {
	
	@Autowired
    private GameWrapper gameMapper;
	
	@Autowired
	private ReviewRepository reviewRepository;
	
	@Autowired
	private UserDetailsServiceImpl userService;
	
	@Transactional
	public void saveReview(ReviewDTO review) {
		Review entity = gameMapper.getReview(review);
    	
		entity.setUser(userService.getLoginUser());
		reviewRepository.save(entity);
	}

}
