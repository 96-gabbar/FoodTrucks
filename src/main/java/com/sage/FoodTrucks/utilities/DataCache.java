package com.sage.FoodTrucks.utilities;

import javax.xml.bind.JAXBException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.sage.FoodTrucks.pojo.Response;

@Component
@EnableScheduling
public class DataCache {

	@Autowired
	Response cache;
	
	@Value("${foodTruck.data.apiUri}")
	String apiUri;
	
	@Scheduled(cron = "${foodTruck.data.cachingRefresh.cron}")
	public void loadDataFromAPI() {
		RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.getForObject(apiUri, String.class);
	    try {
			cache = Utilities.xmlToObject(result);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	public Response getCache() {
		return cache;
	}

	public void setCache(Response cache) {
		this.cache = cache;
	}
}
