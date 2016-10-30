travelApp.controller("loginController",function($scope,$location){
	alert("login controller");
	$scope.loginFlag = true;
	//alert(loginFlag);
	$scope.register = {"firstname":"","lastname":"","emailid":"","password":"","confirmpassword":""};
	$scope.login = {"emailid":"","password":""};
	$scope.register = function(){
	//$scope.registerForm = {};
	alert($scope.register.password);
	alert($scope.registerForm);
	$scope.registerForm.$invalid = true;
	}
})