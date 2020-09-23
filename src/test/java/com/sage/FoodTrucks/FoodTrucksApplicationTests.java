package com.sage.FoodTrucks;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.sage.FoodTrucks.utilities.DataCache;

@SpringBootTest
class FoodTrucksApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Test
	void testApiFetchService() {
		DataCache cache = new DataCache();
		cache.loadDataFromAPI();
		assertTrue(null != cache.getCache());
	}

}
