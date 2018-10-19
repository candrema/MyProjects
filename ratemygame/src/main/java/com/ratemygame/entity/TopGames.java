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
	
	@Column(name = "rate")
	private double rate;
	
	@Column(name = "reviewsCount")
	private int reviewsCount;

	public long getGameId() {
		return gameId;
	}

	public void setGameId(long gameId) {
		this.gameId = gameId;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public int getReviewsCount() {
		return reviewsCount;
	}

	public void setReviewsCount(int reviewsCount) {
		this.reviewsCount = reviewsCount;
	}

}
