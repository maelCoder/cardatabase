package org.fouad.cardatabase.repo;

import org.fouad.cardatabase.domain.Car;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PagingAndSortingCarRepository extends PagingAndSortingRepository<Car, Long> {

}
