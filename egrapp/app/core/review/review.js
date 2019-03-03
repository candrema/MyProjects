var myApp = angular.module('reviewModule', [
    'ngMaterial',
    'ngMessages'
]);


myApp.service('reviewService', function ($mdDialog, $http) {

    var service = this;


    service.showModal = function (ev, callback) {
        $mdDialog.show({
            controller: ModalController,
            controllerAs: 'ctrl',
            templateUrl: '/core/review/review.tmpl.html',
            parent: angular.element(document.body),
            targetEvent: ev,
            clickOutsideToClose: true,
            fullscreen: true // Only for -xs, -sm breakpoints.
        })
            .then(function (review) {
                callback();
            }, function () {
                callback(undefined);
            });
    };

    function ModalController($mdDialog) {
        var ctrl = this;

        ctrl.review;

        ctrl.hide = function () {
            $mdDialog.hide();
        };

        ctrl.cancel = function () {
            $mdDialog.cancel();
        };

        ctrl.submit = function () {
            submit(ctrl.review, function (response) {
                $mdDialog.hide(response);
            });
        };
    }


    function submit(review, callback) {

        $http({
            method: 'POST',
            url: "http://localhost:8080/review/submit",
            data: review
        }).then(function (response) {

            callback(response.data);

        });

    };


    return service;

});