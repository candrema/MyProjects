package com.ratemygame.DTO;

public class GameDetailsDTO {

	private long id;
	private String description;
	private String platforms;
	private String company;
	private String genre;
	private String year;
	private double rate;

	public GameDetailsDTO(long id, String description, String platforms, String company, String genre, String year,
			double rate) {
		
		this.id = id;
		this.description = description;
		this.platforms = platforms;
		this.company = company;
		this.genre = genre;
		this.year = year;
		this.rate = rate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}
	
	

}
