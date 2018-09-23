package com.ratemygame.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "review")
public class Review {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;
	
	@Column(name = "rate")
	private int rate;
	
	@Column(name = "comment")
	private String comment;
	
	
	public Review() {
		
	}
}
