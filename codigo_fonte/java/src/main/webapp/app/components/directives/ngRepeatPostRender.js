(function () {
    'use strict';

    angular.module('main').directive('ngRepeatePostRender', [ngRepeatePostRender]);

    function ngRepeatePostRender() {
        return function (scope, element, attrs) {
            if (scope.$last) setTimeout(function () {
                scope.$emit('onRepeatLast', element, attrs);
            }, 1);
        };
    };
    
})();