(function() {
	'use strict';

	angular.module('main').config(['$httpProvider', HttpProvider]);

	function HttpProvider($httpProvider) {

	    $httpProvider.interceptors.push(['$q', '$location', '$rootScope', '$timeout',
			function($q, $location, $rootScope, $timeout) {
			    var sessionRecoverer = {

					'request': function(config) {
						return config;
					},

					'responseError': function (rejection) {
			            if (rejection.status == 403) {
			            	console.log('>>>>>>>>>.  403');
			            	$timeout(
				            	function(){
				            		$rootScope.globalMessage = 'Você não tem permissão para acessar a página requisitada.';
				        	    },
				        	    5000
				        	);

			                //$location.url('/');
			            }

			            if (rejection.status == 401) {
			            	console.log('>>>>>>>>>.  401');
			            	$rootScope.globalMessage = 'Você não tem permissão para acessar a página requisitada.';
			            	//window.location.assign($location.protocol() + '://'+ $location.host() +'/governodigital');
			            	//$location.url('/');
			            }

			            if (rejection.status == 404) {

			            	console.log('>>>>>>>>>.  404');
			            	$timeout(
				            	function(){
				            		$rootScope.globalMessage = 'O recurso solicitado não foi encontrado.';
				            		console.log('>>>>>>>>>.  404 Redirect');
				            		//$location.url('/public/login/login.html');
				            		//window.location.replace("/concursos/public/login/login.html");
				        	    },
				        	    5000
				        	);
			            	console.log('>>>>>>>>>.  404 >>>>>');
			            	 //$location.url('/public/login/login.html');
			            	 //window.location.replace("/concursos/public/login/login.html");
			            }

			            return $q.reject(rejection);
			        }
			    };
			    return sessionRecoverer;
			}]
	    );
	};

})();
