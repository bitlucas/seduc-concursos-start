(function () {
	'use strict';

	angular.module('main').controller('HomeController', ['$scope', '$http', '$location', '$window', HomeController]);

	function HomeController($scope, $http, $location, $window) {

		activate();

		function activate() {
			/*if (!$window.loading_screen.finishing) {
				$window.loading_screen.finish();
			}*/
			$scope.loading = false;
		}
	};

})();
