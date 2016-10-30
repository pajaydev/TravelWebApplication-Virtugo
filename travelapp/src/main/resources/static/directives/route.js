var travelApp = angular.module("TravelApp",["ngRoute","ui.bootstrap","ngResource","ngMap"]);
alert("route");
travelApp.config(function($routeProvider){
	$routeProvider.
	when("/home",{
		templateUrl:"templates/home.html",
		controller:"homeController as vm"
	})
	.when("/dashboard",{
		templateUrl:"templates/dashboard.html",
		controller:"homeController as vm"
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
	$scope.buttonEnable = true;
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
	
	 $scope.logOut = function(){
		   alert("logout in home");
		   $scope.buttonEnable = true;
		   $location.path('/home');
	   }
	 
	 
	
});