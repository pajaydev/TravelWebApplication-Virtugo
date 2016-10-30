travelApp.factory('baseFactory',['$http','$resource',function($http,$resource){
	
	alert("invoking factory");
	//var baseUrl = 'https://maps.googleapis.com/maps/api/place/nearbysearch/json?type=point_of_interest&radius=5000';
	var baseUrl = 'https://maps.googleapis.com/maps/api/place/nearbysearch/json?type=point_of_interest&radius=5000&location=40.71,-74.00&keyword=NewYork&key=AIzaSyDWIQDRLj908AucZ1ijuJT7oUEPpK9zGxk';
	var key = "AIzaSyDWIQDRLj908AucZ1ijuJT7oUEPpK9zGxk";
	var isLoggedIn = false;
	var baseFactory = {};
	baseFactory.getNearByLocations = function(location,place){
		
		  return $http.get(
				    "https://api.foursquare.com/v2/venues/explore/?near=" +
				    place +
				    "&venuePhotos=1&section=" +
				    "touristplaces" +
				    "&client_id=" + "OU2PQCUCOHJ33UKO0333GTGSKIJ0CLRG14Y35XLPF2JRYRCC" +
				    "&client_secret=" + "OP0UKBNHW22XAJX1O4NQ3O3FARYOUZEZG1YXTMXEWYBWXGOR" +
				    " &v=20131124");
		  };
	
	baseFactory.Session = function(username){
		return{
			IsLoggedIn:true,
			userName:username
		};
	    
	}
	
	return baseFactory;
	/*return {
        "retrieveYelp": function(name, callback) {
        	alert("inside factory");
            var method = 'GET';
            var url = 'http://api.yelp.com/v2/search';
            var params = {
                    
                    location: 'San+Francisc',
                    oauth_consumer_key: 'A1b71RKRCFUywIEw4vhv8g', //Consumer Key
                    oauth_token: 'fld8kU6KJur9r7mzJJjQiNGHzCs-DHHm', //Token
                    oauth_signature_method: "HMAC-SHA1",
                    oauth_signature:"m8o4NWGt7GSytgCG9_EoE3x5UYY",
                    oauth_timestamp: new Date().getTime(),
                    oauth_nonce: randomString(32, '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ'),
                    term: 'food'
                };
            var consumerSecret = ''; //Consumer Secret
            var tokenSecret = ''; //Token Secret
            var signature = oauthSignature.generate(method, url, params, consumerSecret, tokenSecret, { encodeSignature: false});
            params['oauth_signature'] = signature;
            $http.jsonp(url, {params: params});
        }}
	
	
	function randomString(length, chars) {
        var result = '';
        for (var i = length; i > 0; --i) result += chars[Math.round(Math.random() * (chars.length - 1))];
        return result;
    }
	*/
}]);