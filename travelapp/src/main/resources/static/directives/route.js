/*
 * Implementing Angular Route
 */

var travelApp = angular.module("TravelApp", [ "ngRoute", "ui.bootstrap",
		"ngResource", "ngMap", "ngCookies" ]);

travelApp.config(function($routeProvider, $httpProvider) {
	$routeProvider.when("/home", {
		templateUrl : "templates/home.html",
		controller : "homeController as vm"
	}).when("/dashboard", {
		templateUrl : "templates/dashboard.html",
		controller : "homeController as vm"
	}).when("/placeDetails", {
		templateUrl : "templates/placeDetails.html",
		controller : "placeDetailsController"
	}).when("/myplans", {
		templateUrl : "templates/myplans.html",
		controller : "myplansController"
	}).when("/index", {
		templateUrl : "templates/home.html",
		controller : "baseController"
	}).when("/login", {
		templateUrl : "templates/login.html",
		controller : "loginController"
	}).otherwise({
		redirectTo : "/home"
	});

	$httpProvider.defaults.useXDomain = true;
	delete $httpProvider.defaults.headers.common['X-Requested-With'];
});

travelApp.run(function($rootScope, $location, $window, $cookieStore) {
	$rootScope.$on('$routeChangeStart', function($scope, event, next, current) {

		if ($location.path() == "/dashboard" || $location.path() == "/myplans"
				|| $location.path() == "/placeDetails") {
			if ($cookieStore != undefined && $cookieStore.get('userId') != "") {
				$scope.currentScope.$$childHead.buttonEnable = false;
			} else {
				alert("Hey Please Login Into Application!!");
				$location.path("/home");
				$scope.currentScope.$$childHead.buttonEnable = true;

			}
		}

	});
});

travelApp.controller("baseController", [ "$scope", "$location", "$cookieStore",
		function($scope, $location, $cookieStore, $route) {

			var template = "";
			$scope.buttonEnable = true;
			$scope.login = function() {
				if ($location.path() == "/login") {
					$cookieStore.put('userId', "");
					$route.reload();
				} else {
					$location.path('/login');
					$cookieStore.put('userId', "");
				}

			}

			$scope.explore = function() {

				$location.path('/dashboard');
			}

			$scope.myplans = function() {

				$location.path('/myplans');
			}

			$scope.logOut = function() {

				$scope.buttonEnable = true;
				$cookieStore.put('userId', "");
				$location.path('/home');
			}

		} ]);