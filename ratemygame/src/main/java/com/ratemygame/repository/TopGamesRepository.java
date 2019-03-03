package com.ratemygame.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ratemygame.entity.TopGames;

public interface TopGamesRepository extends JpaRepository<TopGames,Long>{
	
	public List<TopGames> findAll();
	
	@Query("SELECT top FROM TopGames top")
	public List<TopGames> findTopGames(Pageable pageable);
	

}
