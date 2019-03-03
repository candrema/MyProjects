package com.ratemygame.DTO;

import java.util.List;

import com.ratemygame.entity.Media;
import com.ratemygame.entity.User;

public class ReviewDTO {

	private long gameId;
	private long rate;
	private String comment;
	private long userId;
	
	
	public long getGameId() {
		return gameId;
	}
	public void setGameId(long gameId) {
		this.gameId = gameId;
	}
	public long getRate() {
		return rate;
	}
	public void setRate(long rate) {
		this.rate = rate;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
}
