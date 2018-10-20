package com.ratemygame.wrapper;

import org.modelmapper.ModelMapper;

import com.ratemygame.DTO.GameDetailsDTO;
import com.ratemygame.DTO.ReviewDTO;
import com.ratemygame.entity.Game;
import com.ratemygame.entity.GameDetails;
import com.ratemygame.entity.Review;
import com.ratemygame.entity.TopGames;

public class GameWrapper extends ModelMapper{

	
	public GameDetailsDTO getGameDetailsDTO(Game game) {
		return map(game, GameDetailsDTO.class);
	}
	
	public GameDetailsDTO getGameDetailsDTODetailed(GameDetails gameDetails) {
		return map(gameDetails, GameDetailsDTO.class);
	}
	
	public GameDetailsDTO getGameDetailsDTOTOP(TopGames top) {
		return map(top, GameDetailsDTO.class);
	}
	
	public ReviewDTO getReviewDetailsDTO(Review review) {
		return map(review, ReviewDTO.class);
	}
	
	public Review getReview(ReviewDTO reviewDTO) {
		return map(reviewDTO, Review.class);
	}
}