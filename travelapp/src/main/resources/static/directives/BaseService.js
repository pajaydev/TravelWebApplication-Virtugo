travelApp.service("baseService",function(){
	var location = "";
	var locationDetails = {};
	var weatherDetails = "";
	this.setLocation = function(location){
		this.location = location;
	}
	this.getLocation = function(){
		return location;
	}
	this.setLocationDetails = function(value){
		this.locationDetails = value;
	}
	this.getLocationDetails = function(){
		return locationDetails;
	}
	this.setWeatherDetails = function(value){
		this.weatherDetails = value;
	}
	this.getweatherDetails = function(){
		return weatherDetails;
	}
	this.setPlace = function(place){
		this.place = place;
	}
	this.getPlace = function(){
		return place;
	}
});