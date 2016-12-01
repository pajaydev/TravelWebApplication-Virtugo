travelApp.controller("myplansController",["$scope","baseService","baseFactory","$cookieStore","$http",
                                          function($scope,baseService,baseFactory,$cookieStore,$http){
	
	$scope.userName = baseService.getUserName();
	var placeDetails = baseService.getLocationDetails();
	if(placeDetails != undefined && placeDetails.url != undefined){
		alert(placeDetails.url);
		$scope.placeUrl = placeDetails.url;
	}
	if(baseService.getHotelUrl() != undefined){
		$scope.hotelUrl = baseService.getHotelUrl(); 
	}
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

	$scope.deletePlace = function(id){
		alert("place"+id);
		var data = {"userId":$cookieStore.get('userId')};
		var request = {
				method : 'POST',
				url : '/deletePlace/'+id,
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