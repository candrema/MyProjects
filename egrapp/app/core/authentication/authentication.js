var myApp = angular.module('authentication', [
    'ngMaterial',
    'ngMessages',
    'ngStorage'
]);


myApp.service('authService', function ($mdDialog, $http, $rootScope, $localStorage) {

    var service = this;

    $rootScope.$localStorage = $localStorage;

    service.showModal = function (ev, callback) {
        $mdDialog.show({
            controller: ModalController,
            controllerAs: 'ctrl',
            templateUrl: '/core/authentication/auth.tmpl.html',
            parent: angular.element(document.body),
            targetEvent: ev,
            clickOutsideToClose: true,
            fullscreen: true // Only for -xs, -sm breakpoints.
        })
            .then(function (user) {
                $rootScope.$localStorage.user = user;
                $rootScope.$localStorage.autentication = true;
                callback(user);

            }, function () {
                $rootScope.$localStorage.user = null;
                $rootScope.$localStorage.autentication = false;
                callback(undefined);
            });


    };

    service.authenticated = function(){
        return $rootScope.$localStorage.autentication; 
    };

    service.user = function(){
        return $rootScope.$localStorage.user; 
    };





    function ModalController($mdDialog) {
        var ctrl = this;

        ctrl.user;
        ctrl.email;
        ctrl.password;

        ctrl.hide = function () {
            $mdDialog.hide();
        };

        ctrl.cancel = function () {
            $mdDialog.cancel();
        };

        ctrl.login = function () {
            doLogin(ctrl.email, ctrl.password, function(response){
                 ctrl.user = response;
                 $mdDialog.hide(response);
            });
        };
    }


    function doLogin(email, password, callback) {

        $http({
            method: 'POST',
            url: "http://localhost:8080/doLogin",
            headers: {authorization:"Basic "+btoa(email+":"+password)}
        }).then(function (response) {

            callback(response.data);

        });

    };


    return service;

});