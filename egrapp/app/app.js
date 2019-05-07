'use strict';

// Declare app level module which depends on views, and core components
angular.module('myApp', [
    'ui.router',
    'ngMaterial',
    'game',
    'authentication'
])
    .config(['$stateProvider', '$urlRouterProvider','$httpProvider', function ($stateProvider, $urlRouterProvider, $httpProvider) {

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
        
        //homepage
        $urlRouterProvider.when('/', 'home');
        $urlRouterProvider.when('', 'home');

        //Auth header
        $httpProvider.interceptors.push('MyAuthRequestInterceptor');

    }])
    .controller('appCtrl', function ($scope, authService) {

        $scope.user = undefined;

        if(authService.authenticated()){
            $scope.user = authService.user();
            $scope.user.password = null;
        }

        $scope.showAuth = function (ev) {
            authService.showModal(ev, function (user) {
                $scope.user = user;
				if($scope.user !== undefined)
					$scope.user.password = null;
            });
        };



    }).factory('MyAuthRequestInterceptor', function ($q, $rootScope) {
            return {
                'request': function (config) {

                    if ($rootScope.$localStorage.autentication) {
                        config.headers.authorization = "Basic "+btoa($rootScope.$localStorage.user.username+":"+$rootScope.$localStorage.user.password);
                    }
                    return config || $q.when(config);
                }
                
            }
        });
