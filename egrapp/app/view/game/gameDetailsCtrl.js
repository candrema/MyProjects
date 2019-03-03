var app = angular.module('game', ['reviewModule']);



app.controller('gameDetailsCtrl', function($scope, $stateParams, gameDetailsService, reviewService) {
	
	var game = this;

	game.gameId = $stateParams.gameId;
	game.gameDetail = {};



	var init = function init(){
		gameDetailsService.getGameDetails(game.gameId, function(response){
			game.gameDetail  = response;
		});
	};

	game.showModal = function(ev){
		reviewService.showModal(ev, function(){

		})
	};


	init();
	
	
});