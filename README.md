# FoodTruckService
 Food Truck service that returns types of food available in food trucks nearby a given location

Problem : We have data from a public source, which contains details about Food trucks. We are given a location in terms of latitude and longitude, and we have to extract types of food available nearby the given location.

Solution :

This solution focuses only on back-end track.

Hence, RestAPI has been written.
RestAPI Details:
        Request Type    : HTTP GET
	Name 		: /nearestFoodTruckTypes
	Consumes 	: JSON Body, with 2 parameters namely Latitude and Longitude with their values in key-value pair.
					Example : {"latitude": "37","longitude": "-122"}
	Produces	: HTTP Response Entity which contains the desired output(Set of food items available nearby the given location), along with HTTP Status.
	

Solution Design:

There is a service which is scheduled, and will call the API to get data.

Once the data is available, we will store it in cache and we can keep updating the cache at some time interval.

When the Rest API is called, we will loop over all the data available, to find out which all types of food is available	nearby the given location.

	
The RestAPI Java Application has been deployed using AWS EC2.
