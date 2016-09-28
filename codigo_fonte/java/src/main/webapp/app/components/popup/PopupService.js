angular.module('main').service('PopupService',function($window){
    this.showPopup=function(message){
        return $window.confirm(message);
    }
});
