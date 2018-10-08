package com.ratemygame.services;

import com.ratemygame.entity.Game;
import com.ratemygame.entity.GameDetails;

public interface PageService {
	
	public Game getGame(long id);
	public GameDetails getGameDetails(long id);
	
}
