package com.ratemygame.DTO;

public class GameDetailsDTO {

	private long gameId;
	private String description;
	private String platforms;
	private String company;
	private String genre;
	private String year;
	private double average;
	private long reviews;

	public long getGameId() {
		return gameId;
	}

	public void setId(long gameId) {
		this.gameId = gameId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPlatforms() {
		return platforms;
	}

	public void setPlatforms(String platforms) {
		this.platforms = platforms;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public double getAverage() {
		return average;
	}

	public void setAverage(double average) {
		this.average = average;
	}

	public long getReviews() {
		return reviews;
	}

	public void setReviews(long reviews) {
		this.reviews = reviews;
	}

	public void setGameId(long gameId) {
		this.gameId = gameId;
	}
	
}
