(function() {
	'use strict';

	angular.module('main').config(
			[ '$stateProvider', '$urlRouterProvider', RouterProvider ]);

	function RouterProvider($stateProvider, $urlRouterProvider) {

		$urlRouterProvider.otherwise('/home');

		$stateProvider
		.state('home', {
			url : '/home',
			templateUrl : 'home/home.html',
			controller : 'HomeController'
		});
		/*
		.state('candidatos', {
			url : '/candidatos',
			templateUrl : 'candidato/candidatos.html',
			controller : 'CandidatoController'
		})
		.state('concursos', {
			url : '/concursos',
			templateUrl : 'concurso/concursos.html',
			controller : 'ConcursoController'
		})
		.state('entidades', {
			url : '/entidades',
			templateUrl : 'entidade/entidades.html',
			controller : 'EntidadeController'
		})
		.state('locais_prova', {
			url : '/locais_prova',
			templateUrl : 'local_prova/locais.html',
			controller : 'EntidadeController'
		})*/





	}
	;

})();
