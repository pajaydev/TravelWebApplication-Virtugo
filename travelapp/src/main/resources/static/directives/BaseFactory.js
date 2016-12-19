/*
 * Angular Factory which has methods to fetch data 
 * from REST Api's
 */

travelApp
		.factory(
				'baseFactory',
				[
						'$http',
						'$resource',
						function($http, $resource) {

							var baseUrl = "https://api.foursquare.com/v2/venues/explore/?near=";
							// var key =
							// "AIzaSyDWIQDRLj908AucZ1ijuJT7oUEPpK9zGxk";
							var clientId = "--foursquare api client id---";
							var clientSecret = "--foursquare api client secret---";
							var weatherKey = "-- dark sky weather api key---";
							var isLoggedIn = false;
							var baseFactory = {};
							baseFactory.getNearByLocations = function(location,
									place) {

								return $http.get(baseUrl + place
										+ "&venuePhotos=1&section="
										+ "touristplaces" + "&client_id="
										+ clientId + "&client_secret="
										+ clientSecret + " &v=20131124");
							};

							baseFactory.getNearByHotels = function(location,
									place) {

								return $http.get(baseUrl + place
										+ "&venuePhotos=1&query=" + "hotels"
										+ "&client_id=" + clientId
										+ "&client_secret=" + clientSecret
										+ " &v=20131124");
							};

							baseFactory.getWeatherDetails = function(place,
									date) {

								return $http
										.jsonp("https://api.darksky.net/forecast/"
												+ weatherKey
												+ "/"
												+ place.lat
												+ ","
												+ place.lng
												+ ","
												+ date
												+ "T00:00:00?callback=JSON_CALLBACK");

							};

							baseFactory.getReviews = function(data) {
								var request = {
									method : 'POST',
									url : '/getReview',
									headers : {
										'Content-Type' : 'application/json'
									},
									data : data
								}
								return $http(request);

							};

							baseFactory.postReviews = function(data) {
								// alert("post reviews in directive");
								var request = {
									method : 'POST',
									url : '/createReview',
									headers : {
										'Content-Type' : 'application/json'
									},
									data : data
								}
								return $http(request);

							};
							baseFactory.shareEmail = function(data) {

								var request = {
									method : 'POST',
									url : '/shareEmail',
									headers : {
										'Content-Type' : 'application/json'
									},
									data : data
								}
								return $http(request);

							};

							baseFactory.Session = function(username) {
								return {
									IsLoggedIn : true,
									userName : username
								};

							}

							return baseFactory;
							
						} ]);