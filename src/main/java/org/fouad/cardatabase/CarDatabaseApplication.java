package org.fouad.cardatabase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author FOUAD
 *
 */
@Slf4j
@SpringBootApplication
public class CarDatabaseApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(CarDatabaseApplication.class, args);
		log.info("Car database application");
	}
	
	
}
