/*
 * Controller for home.html and dashboard.html
 */


travelApp
		.controller(
				"homeController",
				function(NgMap, baseFactory, baseService, $location,
						$rootScope, $scope, $cookieStore) {
					$scope.notify = false;
					$scope.showMap = true;
					/*
					 * if($location.path() == "/dashboard"){ if($cookieStore !=
					 * undefined && $cookieStore.get('userName') != ""){
					 * $rootScope.$$childHead.buttonEnable = false; }else{
					 * alert("Hey Please Login Into Application!!");
					 * $location.path("/home");
					 * $rootScope.$$childHead.buttonEnable = true;
					 *  }
					 * 
					 * }else{ $cookieStore.put('userName',"");
					 * $rootScope.$$childHead.buttonEnable = true; }
					 */
					var vm = this;

				
					vm.placeChanged = function() {
						$scope.showMap = false;
						vm.place = this.getPlace();
						NgMap.getMap().then(function(map) {
							vm.map = map;
						});

						vm.callbackFunc = function(param) {
							if (vm.map.getCenter() != undefined) {
								
							}
						};
						console.log('location', vm.place.geometry.location);
						vm.map.setCenter(vm.place.geometry.location);
						getNearestLocations(vm.place.geometry.location,
								vm.place.name);
						// getNearestLocations("Chennai","Chennai");
					}
					NgMap.getMap().then(function(map) {
						vm.map = map;
					});

					vm.callbackFunc = function(param) {
						if (vm.map.getCenter() != undefined) {
							console.log('I know where ' + param + ' are. '
									+ vm.message);
							console.log('You are at' + vm.map.getCenter());
						}
					};

					function getNearestLocations(location, place) {
						// Getting all nearby tourist locations
						baseFactory
								.getNearByLocations(location, place)
								.then(
										function(result, status) {

											$scope.filteredPlaces = result.data.response.groups[0].items;
											$scope.filteredPlacesCount = result.data.response.totalResults;

										},
										function(error) {
											// alert("error"+error.message);
											alert("No Nearby locations available");
										});
					}

					$scope.buildCategoryIcon = function(icon) {

						return icon.prefix + '44' + icon.suffix;
					};

					$scope.buildVenueThumbnail = function(photo) {

						return photo.items[0].prefix + '128x128'
								+ photo.items[0].suffix;
					};

					// To View Place details

					$scope.viewDetails = function(value, flag) {

						baseService.setLocationDetails(value);
						baseService.setFlag(flag);
						$location.path("/placeDetails");
					}

					$scope.func = function() {

						$scope.notify = true;
					}

				})