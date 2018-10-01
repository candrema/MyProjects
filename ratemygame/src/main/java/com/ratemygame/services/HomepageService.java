package com.ratemygame.services;




import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ratemygame.config.HomepageConfig;
import com.ratemygame.entity.Game;
import com.ratemygame.entity.GameDetails;
import com.ratemygame.entity.Review;
import com.ratemygame.repository.GameDetailsRepository;
import com.ratemygame.repository.GameRepository;
import com.ratemygame.repository.ReviewRepository;

@Service
public class HomepageService implements PageService {

	@Autowired
	private HomepageConfig homepageConfig;
	
	@Autowired
	private GameDetailsRepository gameDetailrepository;
	
	@Autowired
	private GameRepository gameRepository;	
	
	@Autowired
	private ReviewRepository reviewRepository;

	@Override
	public Game getGame(long id) {
		return gameRepository.findById(id).get();
	}

	@Override
	public GameDetails getGameDetails(long id) {
		Optional<GameDetails> gameDetails = gameDetailrepository.findById(id);
		// gameDetails.orElseThrow(()-> new UsernameNotFoundException("Username not found"));
		return gameDetails.get();
	}

	public List<String> getBigGames() {
		return homepageConfig.getBigGames();
	}
	
	public String getBigImagePath() {
		return homepageConfig.getBigImagePath();
	}
	
	public String getGameDetailsPath() {
		return homepageConfig.getDetailsImagePath();
	}
	
	public void saveReview(Review review) {
		reviewRepository.save(review);
	}

}
