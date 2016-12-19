/*
 * Controller for my plans page
 * corresponds to myplans.html
 */

travelApp.controller("myplansController", [
		"$scope",
		"baseService",
		"baseFactory",
		"$cookieStore",
		"$http",
		"$route",
		'$uibModal',
		'$log',
		function($scope, baseService, baseFactory, $cookieStore, $http, $route,
				$uibModal, $log) {

			$scope.userName = baseService.getUserName();
			$scope.emailFlag = false;
			$scope.ids = [];
			baseService.getId("");
			var placeDetails = baseService.getLocationDetails();
			/*
			 * if(placeDetails != undefined && placeDetails.url != undefined){
			 * alert(placeDetails.url); $scope.placeUrl = placeDetails.url;
			 * alert("placeUrl"+placeDetails.url); }
			 */
			if (baseService.getHotelUrl() != undefined) {

				$scope.hotelUrl = baseService.getHotelUrl();
			}
			var data = {
				"userId" : $cookieStore.get('userId')
			}
			var request = {
				method : 'POST',
				url : '/plan',
				headers : {
					'Content-Type' : 'application/json'
				},
				data : data
			}
			$http(request).then(function(response) {

				$scope.myPlaces = response.data;

			}, function(response) {
				// $scope.hotelFlag = true;
			});
            // Sending Email to registered User
			$scope.sendEmail = function() {
				var data = {
					"userId" : $cookieStore.get('userId'),
					"idList" : baseService.getId()
				}
				$scope.emailFlag = true;
				var request = {
					method : 'POST',
					url : '/sendEmail',
					headers : {
						'Content-Type' : 'application/json'
					},
					data : data
				}
				$http(request).then(function(response) {

					$scope.myPlaces = response.data;
					$scope.emailFlag = true;

				}, function(response) {
					// $scope.hotelFlag = true;
				});

			}
            // Delete plans of registered user
			$scope.deletePlan = function(id) {
				var data = {
					"userId" : $cookieStore.get('userId')
				};
				// alert("Confirm Delete Plan!!");
				var request = {
					method : 'POST',
					url : '/deletePlace/' + id,
					headers : {
						'Content-Type' : 'application/json'
					},
					data : data
				}
				alert("Confirm Delete");
				$http(request).then(function(response) {

					$route.reload();
				}, function(response) {
					// $scope.hotelFlag = true;
				});

			}

			$scope.convertToCelsius = function(temp) {
				return Math.round((temp - 32) * 0.5);
			};

			$scope.checkbox = function(id) {
				// alert(id);

				$scope.ids.push(id);
				baseService.setId($scope.ids);
			}
			//Function which opens popup on click of shareEmail button
			$scope.openPopup = function() {
				var template = "";

				$uibModal.open({
					templateUrl : "templates/popup.html",
					controller : 'popupController',
					scope : $scope
				});
			};

		} ]);