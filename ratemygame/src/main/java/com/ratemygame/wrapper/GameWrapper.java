package com.ratemygame.wrapper;

import com.ratemygame.DTO.GameDetailsDTO;
import com.ratemygame.entity.Game;

public class GameWrapper {

	private long id;
	private String name;
	private String fullName;
	private String description;
	private String platforms;
	private String company;
	private String genre;
	private String year;
	private double rate;
	
	public GameWrapper() {
	}

	public static Game getGame() {
		return new Game();
	}
	
	public GameWrapper setDescription(String description) {
		this.description = description;
		return this;
	}
	
	public GameWrapper setPlatforms(String platforms) {
		this.platforms = platforms;
		return this;
	}

	public GameWrapper setCompany(String company) {
		this.company = company;
		return this;
	}
	
	public GameWrapper setgGenre(String genre) {
		this.genre = genre;
		return this;
	}
	
	public GameWrapper setYear(String year) {
		this.year = year;
		return this;
	}
	
	public GameWrapper setRate(double rate) {
		this.rate = rate;
		return this;
	}
	
	public GameWrapper setName(String name) {
		this.name = name;
		return this;
	}
	
	public GameWrapper setFullName(String fullName) {
		this.fullName = fullName;
		return this;
	}
	
	public Game getGameEntity() {
		return new Game(id, name, fullName);
	}
	
	public GameDetailsDTO getGameDetailsDTO() {
		return new GameDetailsDTO(id, description, platforms, company, genre, year, rate);
	}
	
}
