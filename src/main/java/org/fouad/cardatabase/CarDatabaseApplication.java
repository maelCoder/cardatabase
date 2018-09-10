package org.fouad.cardatabase;

import org.fouad.cardatabase.repo.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
