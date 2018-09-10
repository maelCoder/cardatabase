package org.fouad.cardatabase.initializer;

import org.fouad.cardatabase.domain.Car;
import org.fouad.cardatabase.domain.Owner;
import org.fouad.cardatabase.repo.CarRepository;
import org.fouad.cardatabase.repo.PagingAndSortingOwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {

	@Autowired
	CarRepository repository;
	
	@Autowired
	PagingAndSortingOwnerRepository ownerRepository;

	@Override
	public void run(String... args) throws Exception {
		// Save demo data to database
		 // Add owner objects and save these to db
        Owner owner1 = new Owner("John" , "Johnson");
        Owner owner2 = new Owner("Mary" , "Robinson");
        ownerRepository.save(owner1);
        ownerRepository.save(owner2);
        
		repository.save(new Car("Ford", "Mustang", "Red", "ADF-1121", 2017, 59000, "",owner1));
		repository.save(new Car("Nissan", "Leaf", "White", "SSJ-3002", 2014, 29000, "",owner2));
		repository.save(new Car("Toyota", "Prius", "Silver", "KKO-0212", 2018, 39000, "",owner2));

	}

}
