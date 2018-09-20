package org.fouad.cardatabase;

import static org.assertj.core.api.Assertions.assertThat;

import org.fouad.cardatabase.domain.Car;
import org.fouad.cardatabase.repo.CarRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.Getter;
import lombok.Setter;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CarRepositoryTest {

	@Autowired
	@Getter
	@Setter
	private TestEntityManager entityManager;

	@Autowired
	@Getter
	@Setter
	private CarRepository repo;
	@Test
	public void should_save_the_entity_car() {
		Car car = new Car("Tesla", "Model X", "White", "ABC-1234", 2017, 86000, "", null);
		Car persistedCar = entityManager.persistAndFlush(car);
		assertThat(persistedCar.getId()).isNotNull();
	}

	@Test
	public void should_delete_all_cars() {
		Car car = new Car("Tesla", "Model X", "White", "ABC-1234", 2017, 86000, "", null);
		Car car2 = new Car("Mini", "Cooper", "Yellow", "BWS-3007", 2015, 24500, "", null);
		entityManager.persistAndFlush(car);
		entityManager.persistAndFlush(car2);
		repo.deleteAll();
		assertThat(repo.findAll()).isEmpty();
	}
}