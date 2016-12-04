travelApp.controller("popupController",['$scope', '$uibModalInstance', '$http','baseFactory',"$cookieStore", function ($scope, $uibModalInstance, $http
		,baseFactory,$cookieStore) {
	alert("popup controller");
    $scope.cancel = function() {
		
		$uibModalInstance.dismiss('cancel');
	};
	 $scope.shareEmail = function(value) {
			alert(value);
		 var data = {"userId":$cookieStore.get('userId'), "emailId":value};
		 baseFactory.shareEmail(data).then(function (result,status) {
			 alert("success");
			 $uibModalInstance.dismiss('cancel');
		 })
		 .then(function (error) {
			 alert("Error");
		 })
		
		};
}]);