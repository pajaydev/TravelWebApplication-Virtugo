/*
 * Angular custom directive which shows ratings
 * in star
 */

travelApp
		.directive(
				'ratings',
				function() {
					// alert("ratingssss");
					return {

						scope : {
							rating : '=',
							maxRating : '@',
							click : '&'
						},
						restrict : 'EA',
						template : "<div style='display: inline-block; margin: 0px; padding: 0px; cursor:pointer;' ng-repeat='idx in maxRatings track by $index'> \
                <img ng-src='{{(($index+1) <= rating) && \"http://www.codeproject.com/script/ratings/images/star-fill-lg.png\" || \"http://www.codeproject.com/script/ratings/images/star-empty-lg.png\"}}' \
                ng-Click='isolatedClick($index + 1)'></img></div>",

						compile : function(element, attrs) {
							if (!attrs.maxRating
									|| (Number(attrs.maxRating) <= 0)) {
								attrs.maxRating = '5';
							}
							;
						},
						controller : function($scope, $element, $attrs) {
							$scope.maxRatings = [];

							for (var i = 1; i <= $scope.maxRating; i++) {
								$scope.maxRatings.push({});
							}
							;

							$scope.newrating = $scope.rating;

							$scope.isolatedClick = function(param) {
								if ($scope.readOnly == 'true')
									return;

								$scope.rating = $scope._rating = param;
								$scope.hoverValue = 0;
								$scope.click({
									param : param
								});
							};
						}
					}
				});