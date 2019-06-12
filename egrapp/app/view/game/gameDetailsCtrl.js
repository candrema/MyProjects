var app = angular.module('game', ['reviewModule']);



app.controller('gameDetailsCtrl', function($scope, $stateParams, gameDetailsService) {
	
	var game = this;

	game.gameId = $stateParams.gameId;
	game.gameDetail = {};

	var refreshReviews = function(){
		gameDetailsService.getGameReviews(game.gameId, function(response){
			console.log(response);
			game.reviews  = response;
		});
	}
	
	
	var refreshDetails = function(){
		gameDetailsService.getGameDetails(game.gameId, function(response){
			game.gameDetail  = response;
		});
	}

	var init = function init(){
		refreshDetails();
		refreshReviews();
	};

	
	game.showModal = function(ev){
		gameDetailsService.showReviewModal(ev, game.gameId, function(){
			refreshReviews();
		});
	}

	init();
	
	
});