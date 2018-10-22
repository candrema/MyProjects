package com.ratemygame.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.ratemygame.DTO.GameDetailsDTO;
import com.ratemygame.DTO.ReviewDTO;
import com.ratemygame.DTO.UserDTO;
import com.ratemygame.config.HomepageConfig;
import com.ratemygame.config.SecurityConfig;
import com.ratemygame.entity.Game;
import com.ratemygame.entity.GameDetails;
import com.ratemygame.entity.TopGames;
import com.ratemygame.repository.GameDetailsRepository;
import com.ratemygame.repository.GameRepository;
import com.ratemygame.repository.ReviewRepository;
import com.ratemygame.repository.TopGamesRepository;
import com.ratemygame.wrapper.GameWrapper;

@Service
public class HomepageService implements PageService {

	@Autowired
	private HomepageConfig homepageConfig;

	@Autowired
	private GameDetailsRepository gameDetailrepository;

	@Autowired
	private GameRepository gameRepository;

	@Autowired
	private ReviewRepository reviewRepository;

	@Autowired
	private TopGamesRepository topGamesRepository;
	
	@Autowired
    private GameWrapper gameMapper;
	
	@Autowired
	private SecurityConfig securityConfig;
	

	@Override
	@Transactional(readOnly = true)
	public Game getGame(long id) {
		return gameRepository.findById(id).get();
	}

	@Override
	@Transactional(readOnly = true)
	public GameDetails getGameDetailsEntity(long id) {
		Optional<GameDetails> gameDetails = gameDetailrepository.findById(id);
		// gameDetails.orElseThrow(()-> new UsernameNotFoundException("Username not
		// found"));
		return gameDetails.get();
	}

	public List<String> getBigGames() {
		return homepageConfig.getBigGames();
	}

	public String getBigImagePath() {
		return homepageConfig.getBigImagePath();
	}

	@Transactional(readOnly = true)
	public String getGameDetailsPath() {
		return homepageConfig.getDetailsImagePath();
	}

	public List<TopGames> getTopGamesEntity() {
		return topGamesRepository.findAll();
	}

	@Transactional
	public void saveReview(ReviewDTO review) {
		reviewRepository.save(gameMapper.getReview(review));
	}

	public List<GameDetailsDTO> getTopGames() {
		return getTopGamesEntity().stream().map(gameMapper::getGameDetailsDTOTOP).collect(Collectors.toList());
		
	}

	public GameDetailsDTO getGameDetails(long id) {
		return gameMapper.getGameDetailsDTODetailed(getGameDetailsEntity(id));
	}
	
	public List<ReviewDTO> getGameReviews(Game game) {
		return game.getReviews().stream().map(gameMapper::getReviewDetailsDTO).collect(Collectors.toList());
	}
	
	public String loadHomePage(Model model) {
	    model.addAttribute("bigGames", getBigGames());
		model.addAttribute("bigGamesPath", getBigImagePath());
		
		UserDTO user = securityConfig.getLoginUserDTO();
		
		model.addAttribute("user", user);
		model.addAttribute("topGames", getTopGames());
		
		return "homepage";
	}
	
	public void doLogin(HttpServletRequest req, String username, String password) throws AuthenticationException, Exception {
		securityConfig.doLogin(req, username, password);
	}

}
