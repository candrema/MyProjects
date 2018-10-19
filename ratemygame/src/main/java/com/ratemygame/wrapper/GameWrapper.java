package com.ratemygame.wrapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.ratemygame.DTO.GameDetailsDTO;
import com.ratemygame.entity.Game;
import com.ratemygame.entity.GameDetails;
import com.ratemygame.entity.TopGames;

public class GameWrapper {


	@Autowired
    private static ModelMapper modelMapper;
	
	public static GameDetailsDTO getGameDetailsDTO(Game game) {
		return modelMapper.map(game, GameDetailsDTO.class);
	}
	
	public static GameDetailsDTO getGameDetailsDTODetailed(GameDetails gameDetails) {
		return modelMapper.map(gameDetails, GameDetailsDTO.class);
	}
	
	public static GameDetailsDTO getGameDetailsDTOTOP(TopGames top) {
		return modelMapper.map(top, GameDetailsDTO.class);
	}
}