package com.ratemygame.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.math3.util.Precision;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ratemygame.DTO.GameDetailsDTO;
import com.ratemygame.config.HomepageConfig;
import com.ratemygame.entity.GameDetails;
import com.ratemygame.entity.TopGames;
import com.ratemygame.repository.GameDetailsRepository;
import com.ratemygame.repository.TopGamesRepository;
import com.ratemygame.wrapper.GameWrapper;

@Service
public class GameService {

	@Autowired
	private TopGamesRepository topGamesRepository;

	@Autowired
	private GameDetailsRepository gameDetailrepository;

	@Autowired
	private GameWrapper gameMapper;

	@Autowired
	private HomepageConfig homepageConfig;

	// DTO
	
	public List<GameDetailsDTO> getTopGames(int top) {

		List<GameDetailsDTO> games = getTopGamesEntity(top).stream().map(gameMapper::getGameDetailsDTOTOP)
				.collect(Collectors.toList());
		games.forEach(game -> game.setAverage(Precision.round(game.getAverage(), 1)));

		return games;
	}
	
	public GameDetailsDTO getGameDetails(long id) {
		Optional<GameDetails> gameDetails = getGameDetailsEntity(id);
		return gameMapper.getGameDetailsDTODetailed(gameDetails.get());
		
	}

	// From Repository

	private Optional<GameDetails> getGameDetailsEntity(long gameid) {
		return gameDetailrepository.findById(gameid);
	}

	private List<TopGames> getTopGamesEntity(int top) {
		return topGamesRepository.findTopGames(PageRequest.of(0, top));
	}

	// From Properties
	
	public List<String> getBigGames() {
		return homepageConfig.getBigGames();
	}

	public List<String> getSmallGames() {
		return homepageConfig.getSmallGames();
	}

}
