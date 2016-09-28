(function () {
    'use strict';

    angular.module('main').directive('picklist', [Picklist]);

    function Picklist() {
        return {
            restrict: 'E',
            replace: 'true',
            scope: {
                sourceList: '=sourceList',          // = two way data bind
                targetList: '=targetList',          // = two way data bind
                idAttribute: '@idAttribute',        // @ text
                label: '@label',                    // @ text
                sourceListLabel: '@sourceListLabel',// @ text
                targetListLabel: '@targetListLabel' // @ text
            },
            templateUrl: '../scripts/directives/picklist-template.html',
            link: function(scope, elem, attrs) {
                
                scope.$watch("sourceList",
                    function handleChange( newValue, oldValue ) {
                        if(!oldValue && newValue && newValue.length > 0 && scope.targetList && scope.targetList.length > 0){
                            scope.sourceList = _.differenceBy(newValue, scope.targetList, scope.idAttribute);
                        }
                    }
                );
                
                scope.moverParaDireita = function(item, index){
			
                    if(!scope.targetList){
                        scope.targetList = [];
                    }
                    
                    scope.targetList.push(item);
                    scope.sourceList.splice(index, 1);
                    
                    scope.ordenarListas();
                };
                
                scope.moverTodosParaDireita = function(){
                    
                    scope.targetList = scope.targetList.concat(scope.sourceList);
                    scope.sourceList = [];
                    
                    scope.ordenarListas();
                };
                
                scope.moverParaEsquerda = function(item, index){
                    
                    if(!scope.targetList){
                        scope.targetList = [];
                    }
                    
                    scope.targetList.splice(index, 1);
                    scope.sourceList.push(item);
                    
                    scope.ordenarListas();
                };
                
                scope.moverTodosParaEsquerda = function(){
                    scope.sourceList = scope.sourceList.concat(scope.targetList);
                    scope.targetList = [];
                    
                    scope.ordenarListas();
                };
                
                scope.ordenarListas = function(){
                    
                    if(scope.sourceList && scope.sourceList.length > 0){
                        scope.sourceList = _.orderBy(scope.sourceList, [scope.label], ['asc']);
                    }
                    
                    if(scope.targetList && scope.targetList.length > 0){
                        scope.targetList = _.orderBy(scope.targetList, [scope.label], ['asc']);
                    }
                }
                
                scope.ordenarListas();
            }   
        };
    }

})();