package com.sage.FoodTrucks.controller;

import java.util.Map;
import java.util.Set;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sage.FoodTrucks.service.FoodTruckService;

import ch.qos.logback.classic.Logger;

@RestController
public class FoodTruckController {

	Logger LOGGER = (Logger) LoggerFactory.getLogger(FoodTruckController.class);
	
	@Autowired
	FoodTruckService service;
	
	@GetMapping(value = "/nearestFoodTruckTypes")
	public ResponseEntity<Set<String>> getFoodTruckTypesNearLocation(@RequestBody Map<String, String> loc) {
		try {
			LOGGER.info("Request Received ");
			Set<String> result = service.calculateFoodTruckTypesForALocation(loc.get("latitude"), loc.get("longitude"));
			LOGGER.info("Types of food found near : "+loc+" are : "+result);
			return new ResponseEntity<Set<String>>(result, HttpStatus.OK);
		}catch (Exception e) {
			LOGGER.error("Exception occured while calculating types of food near by given location ----------- \n",e);
			return new ResponseEntity<Set<String>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
