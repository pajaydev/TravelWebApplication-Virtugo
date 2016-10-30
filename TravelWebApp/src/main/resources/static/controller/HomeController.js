travelApp.controller("homeController",function($scope,NgMap){
	alert("Home Controller");
	 var vm = this;
	    vm.message = 'You can not hide. :)';
	    NgMap.getMap().then(function(map) {
	      vm.map = map;
	    });
	    vm.callbackFunc = function(param) {
	      console.log('I know where '+ param +' are. ' + vm.message);
	      console.log('You are at' + vm.map.getCenter());
	    };
})