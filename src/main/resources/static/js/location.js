
const findMyLocation = () => {


	const status = document.querySelector('.status');


	const success = async (position) => {

		latitude = position.coords.latitude
		longitude = position.coords.longitude

		let geoApiUrl = 'https://api.bigdatacloud.net/data/reverse-geocode-client?latitude=${latitude}&longitude=${longitude}&localityLanguage=en'

		const res = await fetch(geoApiUrl)
		const data = await res.json()
		status.textContent = data.locality + ' ' + data.principalSubdivision

		initMap(latitude, longitude)
	}

	const error = () => {
		status.textContent = 'Location not allowed'
		
	}
	navigator.geolocation.getCurrentPosition(success, error);

}
findMyLocation();



function initMap(latitude, longitude) {
	
	var map;
console.log(latitude)
	map = new google.maps.Map(document.getElementById('map'), {
		center: { lat: latitude, lng: longitude },
		zoom: 8
	});
	const marker = new google.maps.Marker({
		postiton: { lat: latitude, lng: longitude },
		map: map
	});
	
}
document.querySelector('.find-state').addEventListener('click', findMyLocation)
