var travelApp = angular.module("TravelApp",["ngRoute","ui.bootstrap"]);
alert("route");
travelApp.config(function($routeProvider){
	$routeProvider.
	when("/home",{
		templateUrl:"templates/home.html"
	})
	.when("/index",{
		templateUrl:"templates/home.html",
		controller:"baseController"
	})
	.when("/login",{
		templateUrl:"templates/login.html",
		controller:"loginController"
	})
	.otherwise({
		redirectTo:"/home"
	});
});


travelApp.controller("baseController",function($scope,$location,$route){
	alert("&&&&&&&&&&&&");
	var template = "";
	$scope.login = function(){
		alert("openpopup");
		/*$scope.loginForm.$setPristine();
		 $scope.registerForm.$setPristine();*/
		 alert($location.path());
		 if($location.path() == "/login"){
			 $route.reload();
		 }else{
		$location.path('/login');}
		 
		 
	}
	
});