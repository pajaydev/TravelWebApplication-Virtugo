/*
 * Controller to share details 
 */
travelApp.controller("popupController", [
		'$scope',
		'$uibModalInstance',
		'$http',
		'baseFactory',
		'baseService',
		"$cookieStore",
		"$location",
		"$route",
		function($scope, $uibModalInstance, $http, baseFactory, baseService,
				$cookieStore, $location, $route) {

			$scope.cancel = function() {

				$uibModalInstance.dismiss('cancel');
			};
			$scope.shareEmail = function(value) {

				var data = {
					"userId" : $cookieStore.get('userId'),
					"emailId" : value,
					"idList" : baseService.getId()
				};
				baseFactory.shareEmail(data).then(function(result, status) {
					alert("Email has been sent successfully");
					$uibModalInstance.dismiss('cancel');
					$route.reload();
				}).then(function(error) {
					alert("Error");
				})
				alert("Email has been sent successfully");
				$route.reload();
				$uibModalInstance.dismiss('cancel');
			};
		} ]);