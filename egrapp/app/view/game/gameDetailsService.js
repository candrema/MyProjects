

var app = angular.module('game');

app.factory('gameDetailsService', function ($http, reviewService) {

    var service = {};


    service.getGameDetails = function (gameId, callback) {
        $http({
            method: 'GET',
            url: "http://localhost:8080/getGameDetails/" + gameId
        }).then(function (response) {

            callback(response.data);

        });

    };
    
    service.getGameReviews = function(gameId, callback){
    	reviewService.getReviews(gameId, callback(response));
    }
    
    
    service.showReviewModal = function (ev, callback) {
    	reviewService.showModal(ev, game.gameId, callback)
    }


    return service;

});

