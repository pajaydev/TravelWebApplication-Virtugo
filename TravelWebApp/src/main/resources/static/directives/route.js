var travelApp = angular.module("TravelApp",["ngRoute"]);
travelApp.config(function($routeProvider){
	$routeProvider.
	when("/login",{
		templateUrl:"templates/login.html"
	})
	.otherwise({
		redirectTo:"/login"
	});
});