travelApp.controller("myplansController",["$scope","baseService","baseFactory","$cookieStore","$http",
                                          function($scope,baseService,baseFactory,$cookieStore,$http){
	
	$scope.userName = baseService.getUserName();
	var data = {"userId":$cookieStore.get('userId')}
	var request = {
			method : 'POST',
			url : '/plan',
			headers : {
				'Content-Type' : 'application/json'
			},
			data : data
		}
	$http(request).then(
			function(response) {
				alert("my plans success");
				$scope.myPlaces = response.data;
				
				
			},
			function(response){
				//$scope.hotelFlag = true;
			});
	
	$scope.sendEmail = function(){
		
		var data = {"userId":$cookieStore.get('userId')}
		var request = {
				method : 'POST',
				url : '/sendEmail',
				headers : {
					'Content-Type' : 'application/json'
				},
				data : data
			}
		$http(request).then(
				function(response) {
					
					$scope.myPlaces = response.data;
					
					
				},
				function(response){
					//$scope.hotelFlag = true;
				});
		
	}
	

	$scope.convertToCelsius = function(temp) {
  	  return Math.round((temp - 32) * 0.5);
  	};
}]);