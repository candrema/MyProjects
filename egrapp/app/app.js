'use strict';

// Declare app level module which depends on views, and core components
angular.module('myApp', [
    'ui.router',
    'ngMaterial',
    'game',
    'authentication',
])
    .config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {

        // states

        $stateProvider
            .state('home', {
                name: "home",
                url: "/home",
                templateUrl: '/view/homepage.html',
                controller: 'homepageCtrl',
                controllerAs: 'homeCtrl'
            })
            .state('game', {
                name: "game",
                url: "/game/{gameId}",
                templateUrl: '/view/game/game.html',
                controller: 'gameDetailsCtrl',
                controllerAs: 'gameDCtrl'
            });

        $urlRouterProvider.when('/', 'home');
        $urlRouterProvider.when('', 'home');

        /*
        // set the domains and variables for each environment
        envServiceProvider.config({
            domains: {
                development: ['localhost', 'acme.dev.local'],
                production: ['acme.com', '*.acme.com', 'acme.dev.prod'],
            },
            vars: {
                development: {
                    baseUrl: 'C:/candrema/mnt/storage/ratemygame/assets',
                    imagesBigUrl: '/images/imageBig',
                    imagesUrl: '/images/imageDetails'
    
                },
                production: {
                    apiUrl: '//api.acme.com/v1',
                    staticUrl: '//static.acme.com',
    
                },
                defaults: {
                    apiUrl: '//api.default.com/v1',
                    staticUrl: '//static.default.com'
                }
            }
        });*/

        /*   envServiceProvider.check();*/

    }])
    .controller('appCtrl', function ($scope, authService) {

        $scope.user;

        $scope.showAuth = function(ev){
            authService.showModal(ev, function(user){
                 $scope.user = user;
                 console.log($scope.user);
            });
        };


    });
