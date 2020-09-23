package com.sage.FoodTrucks.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.sage.FoodTrucks.pojo.Response;
import com.sage.FoodTrucks.utilities.DataCache;

import ch.qos.logback.classic.Logger;

@org.springframework.stereotype.Service
public class FoodTruckService {
	
	Logger LOGGER = (Logger) LoggerFactory.getLogger(FoodTruckService.class);
	
	@Value("${foodTruck.distance.radius}")
	String distanceRadius;
	
	@Autowired
	DataCache cache;
	
	public Set<String> calculateFoodTruckTypesForALocation(String latitude, String longitude) {
		LOGGER.info("Started calculating types of food nearby given location");
		Double lat = Double.valueOf(latitude);
		Double lon = Double.valueOf(longitude);
		
		Set<String> typeOfFoodAvailable = new HashSet<>();
		
		double uptoDistance = Double.valueOf(distanceRadius);
		
		if(null==cache.getCache() || null==cache.getCache().getRow()) {
			LOGGER.info("Cache for dataAPI is empty, hence enriching cache");
			cache.loadDataFromAPI();
			LOGGER.info("Cache enrichment completed");
		}
		
		List<Response.Rows.Row> rows = cache.getCache().getRow().getRow();
		
		for(Response.Rows.Row row: rows) {
			double dist = Math.pow(lat-row.getLatitude().doubleValue(), 2) + Math.pow(lon-row.getLongitude().doubleValue(), 2);
			if(dist<=uptoDistance && row.getFooditems()!=null) { 
				List<String> foodItems = Arrays.asList(row.getFooditems().split(":"));
				typeOfFoodAvailable.addAll(foodItems);
			}
		}
		LOGGER.info("Caculation of Food Truck types for the given location completed");
		return typeOfFoodAvailable;
	}
}
