/*
 *function displays corresponding weather icons
 */


function weatherIcon(value) {
	var image = "";
	switch (value) {
	case "clear-night":
		image = "http://openweathermap.org/img/w/01d.png";
		break;
	case "clear-day":
		image = "http://openweathermap.org/img/w/01n.png";
		break;
	case "partly-cloudy-night":
		image = "http://openweathermap.org/img/w/02n.png";
		break;
	case "partly-cloudy-day":
		image = "http://openweathermap.org/img/w/02d.png";
		break;
	case "cloudy":
		image = "http://openweathermap.org/img/w/04d.png";
		break;
	case "rain":
		image = "http://openweathermap.org/img/w/10n.png";
		break;
	case "wind":
		image = "http://openweathermap.org/img/w/10n.png";
		break;
	case "fog":
		image = "http://openweathermap.org/img/w/741.png";
		break;

	default:
		image = "http://openweathermap.org/img/w/04d.png"

	}
	return image;
}