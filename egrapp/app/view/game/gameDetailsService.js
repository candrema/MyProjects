

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
    
    service.getGameReviews = function(gameId){
    	return reviewService.getReviews(gameId);
    }
    
    
    service.showReviewModal = function (ev, gameId ,callback) {
    	reviewService.showModal(ev, gameId, callback)
    }


    return service;

});

