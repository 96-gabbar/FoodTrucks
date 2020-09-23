package com.sage.FoodTrucks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = FoodTrucksApplication.class)
public class FoodTrucksApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodTrucksApplication.class, args);
	}

}
