var travelApp = angular.module("TravelApp",["ngRoute","ui.bootstrap","ngResource","ngMap","ngCookies"]);

travelApp.config(function($routeProvider, $httpProvider){
	$routeProvider.
	when("/home",{
		templateUrl:"templates/home.html",
		controller:"homeController as vm"
	})
	.when("/dashboard",{
		templateUrl:"templates/dashboard.html",
		controller:"homeController as vm"
	})
	.when("/placeDetails",{
		templateUrl:"templates/placeDetails.html",
		controller:"placeDetailsController"
	})
	.when("/myplans",{
		templateUrl:"templates/myplans.html",
		controller:"myplansController"
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
	
	  $httpProvider.defaults.useXDomain = true;
	  delete $httpProvider.defaults.headers.common['X-Requested-With'];
});

travelApp.run(function($rootScope, $location,$window){
$rootScope.$on('$routeChangeStart',function($scope,event,next,current){
	alert("route changes");
	if(event.$$route.originalPath == "/placeDetails"){
		$scope.currentScope.$$childHead.buttonEnable = false;
	}
    

});
});



travelApp.controller("baseController",["$scope","$location","$cookieStore",function($scope,$location,$cookieStore,$route){
	
	var template = "";
	$scope.buttonEnable = true;
	$scope.login = function(){
		 if($location.path() == "/login"){
			 $cookieStore.put('userName',"");
			 $route.reload();
		 }else{
		$location.path('/login');
		$cookieStore.put('userName',"");}
		 
		 
	}
	
	$scope.explore = function(){
		alert("Explore");
		$location.path('/dashboard');
	}
	
	$scope.myplans = function(){
		alert("My plans");
		$location.path('/myplans');
	}
	
	 $scope.logOut = function(){
		  
		   $scope.buttonEnable = true;
		   $cookieStore.put('userName',"");
		   $location.path('/home');
	   }
	 
	 
	
}]);