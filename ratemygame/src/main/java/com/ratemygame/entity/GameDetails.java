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
    
    @Column(name = "genre")
    private String genre;
    
    @Column(name = "plataforms")
    private String plataforms;
    
    @Column(name = "year")
    private String year;
    
    @Column(name = "company")
    private String company;
       

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

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getPlataforms() {
		return plataforms;
	}

	public void setPlataforms(String plataforms) {
		this.plataforms = plataforms;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	
	
	
    
	
}
