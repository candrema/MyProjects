package com.ratemygame.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ratemygame.DTO.GameDetailsDTO;
import com.ratemygame.services.GameService;

@RestController
public class GameController {

	@Autowired
	private GameService gameService;

	@GetMapping("/getTop/{top}")
	public List<GameDetailsDTO> getTopGames(@PathVariable("top") int top) {
		return gameService.getTopGames(top);
	}

	@GetMapping("/getNews")
	public List<String> getNews() {
		return gameService.getSmallGames();
	}

	@GetMapping("/getBig")
	public List<String> getBig() {
		return gameService.getBigGames();
	}
	
	@GetMapping("/getGameDetails/{gameId}")
	public GameDetailsDTO getGameDetails(@PathVariable("gameId") long gameId) {
		return gameService.getGameDetails(gameId);
	}
}
