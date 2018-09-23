package com.ratemygame.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "game_details")
public class GameDetails {
	
	@Id
	private long id;
	
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Game game;
    
    @Column(name = "description")
    private String description;

    public GameDetails() {
    	
    }
    
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
    
	
}
