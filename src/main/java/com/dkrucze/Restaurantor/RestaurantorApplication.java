package com.dkrucze.Restaurantor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestaurantorApplication {

	// TODO
	// Connect to mongo instance
	// -Save sensitive data as encrypted config?
	// -Save general config as plain .yaml file
	// Create Entity model for data
	// Create processor to convert response into entity?
	// Create endpoints for displaying data
	// Create endpoints for searching through data
	// -Create indexes in mongo for faster search?
	// Test endpoints and configuration

	public static void main(String[] args) {
		SpringApplication.run(RestaurantorApplication.class, args);
	}

}
