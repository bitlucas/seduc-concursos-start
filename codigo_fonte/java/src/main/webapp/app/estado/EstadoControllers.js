(function () {
	'use strict';
	/**
	 * Created by Sandeep on 01/06/14.
	 */
	angular.module('main')

	.controller('EstadoListController', function($http, $scope,$state,PopupService,$window,EstadoService) {

			$scope.estadoEnable = true;

			$scope.estadosSearch = {};
			
			$scope.estados = EstadoService.query();

			console.log('List ' + $scope.estados );

			$scope.searchEstados = function() {
				console.log('Search .... ');

				$http.post('/concursos/rest/estados/search', $scope.estadosSearch)
				.then(function successCallback(response) {
					$scope.estados = response.data;
			  }, function errorCallback(response) {
			    // called asynchronously if an error occurs
			    // or server returns response with an error status.
			  });

			}

	    $scope.deleteEstado = function(estado){
	      if(PopupService.showPopup('Really delete this?')) {
	          EstadoService.delete({id: estado.id}, function(){
							$scope.estados = EstadoService.query();
	          });
	      }
	    }

	})
	.controller('EstadoViewController',function($scope, $stateParams, EstadoService) {

	    console.log("View " + $stateParams.id);

	    $scope.estadoEnable = true;

	    $scope.estado = EstadoService.get({id:$stateParams.id});

	    console.log("view " + JSON.stringify($scope.estado));

	}).controller('EstadoCreateController',function($scope, $state, $stateParams, EstadoService){

		$scope.estadoEnable = true;

	    $scope.estado = new EstadoService();

	    $scope.addEstado = function() {
			$scope.estado.$save(function(){
				$state.go('estados');
			});
	    }

	}).controller('EstadoEditController',function($scope,$state,$stateParams,EstadoService){

	    console.log("edit");

			$scope.estadoEnable = true;

	    $scope.updateEstado = function() {
				console.log('UPDATE');
	        $scope.estado.$update(function(){
	            $state.go('estados');
	        });
	    };

	    $scope.loadEstado = function(){
	      $scope.estado = EstadoService.get({id:$stateParams.id});
	      console.log("edit load " + $stateParams.id + "  " + JSON.stringify($scope.estado));
	    };

	    $scope.loadEstado();
	});


})();
