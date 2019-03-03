var myApp = angular.module('authentication', [
    'ngMaterial',
    'ngMessages'
]);


myApp.service('authService', function ($mdDialog, $http) {

    var service = this;
    service.user;


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
                callback(user);

            }, function () {
                callback(undefined);
            });


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
            url: "http://localhost:8080/doLogin/" + email + "/" + password
        }).then(function (response) {

            callback(response.data);

        });

    };


    return service;

});