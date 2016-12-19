/*
 * Angular Service to set and get the 
 * details across application
 */

travelApp.service("baseService", function() {
	var location = "";
	var userName = "";
	var date = "";
	var locationDetails = {};
	var weatherDetails = "";
	var hotelUrl = "";
	var flag = "";
	var id = [];
	this.setId = function(id) {
		this.id = id;
	}
	this.getId = function() {
		return this.id;
	}
	this.setDate = function(date) {
		this.date = date;
	}
	this.getDate = function() {
		return this.date;
	}
	this.setFlag = function(flag) {
		this.flag = flag;
	}
	this.getFlag = function() {
		return this.flag;
	}
	this.setHotelUrl = function(hotelUrl) {
		this.hotelUrl = hotelUrl;
	}
	this.getHotelUrl = function() {
		return this.hotelUrl;
	}

	this.setUserName = function(userName) {
		this.userName = userName;
	}
	this.getUserName = function() {
		return this.userName;
	}
	this.setLocation = function(location) {
		this.location = location;
	}
	this.getLocation = function() {
		return this.location;
	}
	this.setLocationDetails = function(value) {
		this.locationDetails = value;
	}
	this.getLocationDetails = function() {
		return this.locationDetails;
	}
	this.setWeatherDetails = function(value) {
		this.weatherDetails = value;
	}
	this.getweatherDetails = function() {
		return this.weatherDetails;
	}
	this.setPlace = function(place) {
		this.place = place;
	}
	this.getPlace = function() {
		return place;
	}
});