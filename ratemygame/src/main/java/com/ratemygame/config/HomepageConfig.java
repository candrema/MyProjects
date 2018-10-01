package com.ratemygame.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:homepage.properties")
public class HomepageConfig {

	@Value("${games.imagebig}")
	private List<String> bigGames;

	@Value("${games.imagemedium}")
	private List<String> smallGames;

	@Value("${images}")
	private String gamesImagePath;

	@Value("${games.images.path.imagebig}")
	private String gamesImagePathBig;

	@Value("${games.images.path.details}")
	private String detailsImagePath;

	public List<String> getBigGames() {
		return bigGames;
	}

	public void setBigGames(List<String> bigGames) {
		this.bigGames = bigGames;
	}

	public List<String> getSmallGames() {
		return smallGames;
	}

	public void setSmallGames(List<String> smallGames) {
		this.smallGames = smallGames;
	}

	public String getBigImagePath() {
		return gamesImagePath + gamesImagePathBig;
	}

	public String getDetailsImagePath() {
		return gamesImagePath + detailsImagePath;
	}

}
