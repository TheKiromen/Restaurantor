package com.dkrucze.Restaurantor;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@SpringBootTest
@DisplayName("Configuration Test")
class RestaurantorApplicationTests {

	//YAML Config file saved in resources folder
	Resource resource;

	@BeforeEach
	void loadClasspath(){
		resource = new ClassPathResource("application.yaml");
		if(!resource.exists()) resource = new ClassPathResource("application.yml");
	}

	@Test
	void ConfigFile_Exists(){
		assertAll(
			() -> assertTrue(resource.exists()),
			() -> assertTrue(resource.isFile())
		);
	}

	@Test
	void ConfigFile_Contains_MongoDB_Properties(){
		assumeTrue(resource.exists());
		try(
			FileReader fr = new FileReader(resource.getFile());
			BufferedReader reader = new BufferedReader(fr)
			)
		{
			//Check if configuration file contains MongoDB properties
			List<String> configFileContents = reader.lines().filter(s -> s.contains("mongodb:")).collect(Collectors.toList());
			assertTrue(configFileContents.size()>0);
		}catch(IOException exception){
			exception.printStackTrace();
		}
	}
}
