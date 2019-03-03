

var app = angular.module('game');

app.factory('gameDetailsService', ['$http', function ($http) {

    var service = {};


    service.getGameDetails = function (gameId, callback) {
        $http({
            method: 'GET',
            url: "http://localhost:8080/getGameDetails/" + gameId
        }).then(function (response) {

            callback(response.data);

        });

    };



    return service;

}]);

