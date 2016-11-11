//Controller for login and signup corresponds to Login.html

travelApp.controller("loginController",["$scope","$http","$location","$cookieStore","$route",function($scope,$http,$location,$cookieStore,$route){
	
	$scope.loginDetails = {email:"",password:""};
	$scope.loginFlag = true;
	$scope.registerDetails = {email:"",password:"",firstName:"",lastName:"",userName:""};
	 $scope.pwCheck=function(){
	        if($scope.registerDetails.password!=$scope.registerDetails.confirmpassword){
	            $scope.registerForm.$invalid=true;
	            $scope.pwMatch=true;
	        }
	    };
	
	
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
					
					$scope.$parent.$$childHead.buttonEnable = false;
					//$scope.apply();
					$cookieStore.put('userName',response.data.userName);
					alert($cookieStore.get('userName'));
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
					$route.reload();
					alert("Registration is successful");
					$location.path("/login");
					$route.reload();
					
				},
				function(response){
					alert("fails");
				});
	}
	
}]);