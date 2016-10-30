travelApp.service("baseService",function(){
	var location = "";
	this.setLocation = function(location){
		this.location = location;
	}
	this.getLocation = function(){
		return location;
	}
	this.setPlace = function(place){
		this.place = place;
	}
	this.getPlace = function(){
		return place;
	}
});