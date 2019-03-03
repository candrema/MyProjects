var app = angular.module('myApp');



app.controller('homepageCtrl', function ($http, $scope, homeService) {


    var home = this;


    home.user;
    home.choosedBottom;
    home.topGames;
    home.news;
    home.big;


    home.chooseCombo = function chooseCombo(type) {
        if (chooseCombo !== type) {
            this.choosedBottom = type;
        }
    }


    var init = function init() {
        home.user = {
            username: "anom",
            password: "anom"
        }

        home.choosedBottom = "video";


        homeService.getTopGames(5, function (response) {
            home.topGames = response;
        });

        homeService.getNews(function (response) {
            home.news = response;
        });

        homeService.getBig(function (response) {
            home.big = response;
        });

    }


    init();



});