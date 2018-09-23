package com.ratemygame.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "game")
public class Game {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "fullname")
	private String fullname;

	@OneToOne(mappedBy = "game", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
	private GameDetails gameDetails;
	
	public Game() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public GameDetails getGameDetails() {
		return gameDetails;
	}

	public void setGameDetails(GameDetails gameDetails) {
		this.gameDetails = gameDetails;
	}
	
	

}
