package com.ratemygame.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TOP_GAMES")
public class TopGames {

	@Id
	@Column(name = "game_Id")
	private long gameId;
	
	@Column(name = "average")
	private double average;
	
	@Column(name = "reviews")
	private int reviews;

	public long getGameId() {
		return gameId;
	}

	public void setGameId(long gameId) {
		this.gameId = gameId;
	}

	public double getAverage() {
		return average;
	}

	public void setAverage(double average) {
		this.average = average;
	}

	public int getReviews() {
		return reviews;
	}

	public void setReviews(int reviews) {
		this.reviews = reviews;
	}

}
