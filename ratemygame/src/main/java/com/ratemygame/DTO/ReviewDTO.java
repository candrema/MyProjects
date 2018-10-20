package com.ratemygame.DTO;

import java.util.List;

import com.ratemygame.entity.Media;
import com.ratemygame.entity.User;

public class ReviewDTO {

	private long gameId;
	private int rate;
	private String comment;
	private User user;
	private List<Media> media; 
	
	
	public long getGameId() {
		return gameId;
	}
	public void setGameId(long gameId) {
		this.gameId = gameId;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Media> getMedia() {
		return media;
	}
	public void setMedia(List<Media> media) {
		this.media = media;
	}
	
}
