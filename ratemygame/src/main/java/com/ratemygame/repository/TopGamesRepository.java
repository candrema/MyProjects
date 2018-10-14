package com.ratemygame.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ratemygame.entity.TopGames;

public interface TopGamesRepository extends JpaRepository<TopGames,Long>{
	
	public List<TopGames> findAll();

}
