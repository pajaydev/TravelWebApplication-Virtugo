/*
 * Controller which describes details about the place,
 * nearby hotels, weather conditions
 */

travelApp
		.controller(
				"placeDetailsController",
				[
						"$scope",
						"baseService",
						"baseFactory",
						"$http",
						"$cookieStore",
						function($scope, baseService, baseFactory, $http,
								$cookieStore) {

							var placeDetails = baseService.locationDetails;
							var flag = baseService.getFlag();

							var today = new Date();
							$scope.icon = "";
							$scope.rating = 3;
							$scope.placeDetails = placeDetails;
							$scope.dateFormat = 'yyyy-MM-dd';
							$scope.today = new Date();
							var hour = today.getHours();
							$scope.hotelFlag = false;
							$scope.hotelSuccess = false;
							$scope.reviewsDiv = "";
							$scope.reviews = false;
							if (flag == "details") {
								// populate all the NearBy hotel details
								baseFactory
										.getNearByHotels(
												$scope.placeDetails.location.city,
												$scope.placeDetails.location.city)
										.then(
												function(result, status) {
													$scope.reviewsDiv = false;
													// $scope.placesDiv = true;
													$scope.filteredPlaces = result.data.response.groups[0].items;
													$scope.filteredPlacesCount = result.data.response.totalResults;

												},
												function(error) {
													// alert("error"+error.message);
													alert("No Nearby Hotels Available");
												});
							} else {
								$scope.reviews = false;
								$scope.reviewsDiv = true;
								var data = {
									"place" : $scope.placeDetails.name
								}
								baseFactory.getReviews(data).then(
										function(result, status) {

											$scope.reviewDetails = result.data;
											$scope.maxRatings = [];

											// $scope.savedRatings =
											// $scope.reviewItem.rating;
											// alert($scope.savedRatings);
											// $scope.filteredPlacesCount =
											// result.data.response.totalResults;

										}, function(error) {
											// alert("error"+error.message);
											$scope.weatherFlag = true;
										});
							}

							var date = $scope.today.toISOString().substring(0,
									10);
							// Populate all the weather details
							baseFactory
									.getWeatherDetails(
											$scope.placeDetails.location, date)
									.then(
											function(result, status) {

												$scope.weatherDetails = result.data;
												baseService
														.setWeatherDetails(result.data.currently.temperature);
												$scope.temperatureDetails = result.data.currently;
												var icon = $scope.temperatureDetails.icon;
												$scope.icon = weatherIcon(icon);
											}, function(error) {
												$scope.weatherFlag = true;
											});

							$scope.buildCategoryIcon = function(icon) {

								return icon.prefix + '44' + icon.suffix;
							};

							$scope.buildVenueThumbnail = function(photo) {

								return photo.items[0].prefix + '100x100'
										+ photo.items[0].suffix;
							};

							$scope.getWeather = function() {

								var date = $scope.today.toISOString()
										.substring(0, 10);

								// alert($scope.today);
								// alert(date);
								baseService.setDate(date);
								baseFactory
										.getWeatherDetails(
												$scope.placeDetails.location,
												date)
										.then(
												function(result, status) {

													$scope.weatherDetails = result.data;
													baseService
															.setWeatherDetails(result.data.currently.temperature);
													var icon = result.data.currently.icon;
													$scope.icon = weatherIcon(icon);
													// $scope.filteredPlacesCount
													// =
													// result.data.response.totalResults;

												}, function(error) {
													// alert("error"+error.message);
													$scope.weatherFlag = true;
												});
							}

							$scope.availableDatePopup = {
								opened : false
							};

							$scope.OpenAvailableDate = function() {
								$scope.availableDatePopup.opened = !$scope.availableDatePopup.opened;
							};

							$scope.availableDateOptions = {
								formatYear : 'yy',
								startingDay : 1,
								minDate : today,
								maxDate : new Date(2030, 5, 22)
							};

							$scope.saveHotel = function(value) {
								var weather = baseService.getweatherDetails();
								var date = baseService.getDate();

								if (value.url != undefined) {
									baseService.setHotelUrl(value.url);
								}

								var data = {
									"place" : $scope.placeDetails.name,
									"address" : value.location.address + ", "
											+ value.location.city + ", "
											+ value.location.country,
									"hotel" : value.name,
									"dateTravel" : date,
									"dateAdded" : "",
									"climate" : weather,
									"userId" : $cookieStore.get('userId'),
									"placeUrl" : placeDetails.url,
									"hotelUrl" : value.url

								}
								var request = {
									method : 'POST',
									url : '/savePlan',
									headers : {
										'Content-Type' : 'application/json'
									},
									data : data
								}
								$http(request)
										.then(
												function(response) {

													$scope.$parent.$$childHead.buttonEnable = false;
													$scope.hotelSuccess = true;
													// $scope.apply();
													$cookieStore
															.put(
																	'userName',
																	response.data.userName);

													$location
															.path("/dashboard");

												}, function(response) {
													// $scope.hotelFlag = true;
												});
							};

							$scope.convertToCelsius = function(temp) {
								return Math.round((temp - 32) * 0.5);
							};

							function createJson(value) {

							}
							// Method to persist User's review into the database
							$scope.createReview = function(rating, review) {

								var data = {
									"rating" : rating,
									"review" : review,
									"place" : $scope.placeDetails.name,
									"userId" : $cookieStore.get('userId')
								}
								baseFactory
										.postReviews(data)
										.then(
												function(result, status) {

													$scope.ReviewsSuccess = result.data;

													// $scope.filteredPlacesCount
													// =
													// result.data.response.totalResults;

												}, function(error) {
													//alert("error"+error.message);
													$scope.weatherFlag = true;
												});

							}
							//Method to retrieve the reviews from the database
							$scope.getReviews = function() {
								$scope.reviews = false;
								//$scope.reviewDetails = [];

								var data = {
									"place" : $scope.placeDetails.name
								}
								baseFactory
										.getReviews(data)
										.then(
												function(result, status) {

													$scope.reviewDetails = result.data;
													$scope.maxRatings = [];

													for (var i = 1; i <= $scope.reviewDetails.review; i++) {
														$scope.maxRatings
																.push({});
													}
													;
													//$scope.savedRatings = $scope.reviewItem.rating;
													//alert($scope.savedRatings);
													//$scope.filteredPlacesCount  = result.data.response.totalResults;

												}, function(error) {
													//alert("error"+error.message);
													$scope.weatherFlag = true;
												});

							}

						} ])