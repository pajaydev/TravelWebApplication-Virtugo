//Controller for login and signup corresponds to Login.html

travelApp.controller("loginController",["$scope","$http","$location",function($scope,$http,$location){
	alert("login controller");
	$scope.loginDetails = {email:"",password:""};
	$scope.loginFlag = true;
	$scope.registerDetails = {email:"",password:"",firstName:"",lastName:"",userName:""};
	
	
	$scope.logOut = function(){
		alert("Logout");
	}
	//Function used to check user credentials
	$scope.login = function(){
		
		var request = {
				method : 'POST',
				url : '/login',
				headers : {
					'Content-Type' : 'application/json'
				},
				data : $scope.loginDetails
			}
		$http(request).then(
				function(response) {
					alert("success");
					$scope.$parent.$$childHead.buttonEnable = false;
					//$scope.apply();
					
					$location.path("/dashboard");
					
				},
				function(response){
					alert("Invalid UserName or Password");
				});
		
	}
	//Function used to register
	$scope.register = function(){
		
		$scope.registerDetails.userName = $scope.registerDetails.firstName + $scope.registerDetails.lastName;
		var request = {
				method : 'POST',
				url : '/registration',
				headers : {
					'Content-Type' : 'application/json'
				},
				data : $scope.registerDetails
			}
		$http(request).then(
				function(response) {
					alert("Registration is successful");
					$route.reload();
					
				},
				function(response){
					alert("fails");
				});
	}
	
}]);