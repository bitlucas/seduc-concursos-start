(function () {
    'use strict';

angular.module('main')
  .factory('EstadoService', EstadoService);

  EstadoService.$inject = ['$resource'];

  function EstadoService ($resource){
    return $resource('/concursos/rest/estados/:id',{id:'@_id'},{
        'query': {method: 'GET', isArray: true},
        'get': {
            method: 'GET', isArray: false
        },
        'save': { method:'POST' },
        'update': { method:'PUT' },
        'delete':{ method:'DELETE'}
    });
}

})();
