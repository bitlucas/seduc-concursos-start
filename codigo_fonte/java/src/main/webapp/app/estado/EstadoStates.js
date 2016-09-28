(function() {
	'use strict';

	angular.module('main').config(
			[ '$stateProvider', '$urlRouterProvider', RouterProvider ]);

	function RouterProvider($stateProvider, $urlRouterProvider) {

		$stateProvider
	  .state('estados',{
        url:'/estados',
        templateUrl:'estado/list.html',
        controller:'EstadoListController'
    })
		.state('viewEstado',{
       url:'/estados/:id/view',
       templateUrl:'estado/view.html',
       controller:'EstadoViewController'
    }).state('newEstado',{
        url:'/estados/new',
        templateUrl:'estado/form.html',
        controller:'EstadoCreateController'
    }).state('editEstado',{
        url:'/estados/:id/edit',
        templateUrl:'estado/form.html',
        controller:'EstadoEditController'
    });
	};
})();
