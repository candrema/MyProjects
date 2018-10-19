package com.ratemygame.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ratemygame.DTO.GameDetailsDTO;
import com.ratemygame.config.HomepageConfig;
import com.ratemygame.entity.Game;
import com.ratemygame.entity.GameDetails;
import com.ratemygame.entity.Review;
import com.ratemygame.entity.TopGames;
import com.ratemygame.repository.GameDetailsRepository;
import com.ratemygame.repository.GameRepository;
import com.ratemygame.repository.ReviewRepository;
import com.ratemygame.repository.TopGamesRepository;
import com.ratemygame.wrapper.GameWrapper;

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
	
	@Autowired
	private TopGamesRepository topGamesRepository;

	@Override
	@Transactional(readOnly=true)
	public Game getGame(long id) {
		return gameRepository.findById(id).get();
	}
	
	@Override
	@Transactional(readOnly=true)
	public GameDetails getGameDetailsEntity(long id) {
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
	
	@Transactional(readOnly=true)
	public String getGameDetailsPath() {
		return homepageConfig.getDetailsImagePath();
	}
	
	public List<TopGames> getTopGamesEntity(){
		return topGamesRepository.findAll();
	}
	
	@Transactional
	public void saveReview(Review review) {
		reviewRepository.save(review);
	}
	
	public List<GameDetailsDTO> getTopGames(){
	//TODO	return getTopGamesEntity().stream().forEach(action);
		return null;
	}
	
	public GameDetailsDTO getGameDetails(long id) {
		GameDetails game = getGameDetailsEntity(id);
		return GameWrapper.getGameDetailsDTODetailed(game);
	}
	
}
