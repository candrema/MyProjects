var app = angular.module('myApp');

app.factory('homeService', ['$http', function ($http) {

    var service = {};


    service.getTopGames = function (top, callback) {
        $http({
            method: 'GET',
            url: "http://localhost:8080/getTop/" + top
        }).then(function (response) {

            callback(response.data);

        });

    };

    service.getNews = function (callback) {
        $http({
            method: 'GET',
            url: "http://localhost:8080/getNews"
        }).then(function (response) {

            callback(response.data);

        });

    };

    service.getBig = function (callback) {
        $http({
            method: 'GET',
            url: "http://localhost:8080/getBig"
        }).then(function (response) {

            callback(response.data);

        });

    };


    return service;

}]);

