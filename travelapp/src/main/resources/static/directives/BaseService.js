travelApp.service("baseService",function(){
	var location = "";
	var userName = "";
	var date = "";
	var locationDetails = {};
	var weatherDetails = "";
	this.setDate = function(date){
		this.date = date;
	}
	this.getDate = function(){
		return this.date;
	}
	this.setUserName = function(userName){
		this.userName = userName;
	}
	this.getUserName = function(){
		return this.userName;
	}
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
		return this.weatherDetails;
	}
	this.setPlace = function(place){
		this.place = place;
	}
	this.getPlace = function(){
		return place;
	}
});