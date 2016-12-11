travelApp.controller("popupController",['$scope', '$uibModalInstance', '$http','baseFactory',"$cookieStore", function ($scope, $uibModalInstance, $http
		,baseFactory,$cookieStore) {
	
    $scope.cancel = function() {
		
		$uibModalInstance.dismiss('cancel');
	};
	 $scope.shareEmail = function(value) {
			
		 var data = {"userId":$cookieStore.get('userId'), "emailId":value};
		 baseFactory.shareEmail(data).then(function (result,status) {
			 alert("Email has been sent successfully");
			 $uibModalInstance.dismiss('cancel');
		 })
		 .then(function (error) {
			 alert("Error");
		 })
		 alert("Email has been sent successfully");
		 $uibModalInstance.dismiss('cancel');
		};
}]);