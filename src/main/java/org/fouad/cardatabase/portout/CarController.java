package org.fouad.cardatabase.portout;

import org.fouad.cardatabase.domain.Car;
import org.fouad.cardatabase.repo.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.NoArgsConstructor;

@RestController
@NoArgsConstructor
public class CarController {

	@Autowired
	private CarRepository carRepository;
	
	
	
	protected CarController(CarRepository carRepository) {
		super();
		this.carRepository = carRepository;
	}



	@GetMapping("/cars")
	public Iterable<Car> getCars(){
		return this.carRepository.findAll();
	}
}
