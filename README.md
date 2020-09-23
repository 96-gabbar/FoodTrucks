# FoodTruckService
 Food Truck service that returns types of food available in food trucks nearby a given location

Problem : We have data from a public source, which contains details about Food trucks. We are given a location in terms of latitude and longitude, and we have to extract types of food available nearby the given location.

Solution :

This solution focuses only on back-end track.

Hence, RestAPI has been written.
RestAPI Details:
	Name 		: /nearestFoodTruckTypes
	Consumes 	: JSON Body, with 2 parameters namely Latitude and Longitude with their values in key-value pair.
					Example : {"latitude": "37","longitude": "-122"}
	Produces	: HTTP Response Entity which contains the desired output(Set of food items available nearby the given location), along with HTTP Status.
	
	
The RestAPI has been deployed using AWS EC2.
