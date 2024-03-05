package mp.CarDatabaseWeek6.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Long> {

	List<Car> findByBrand(String string);

	List<Car> findByOwnerLastName(String string);
	List<Car> findByOwnerId(Long id);
	



}
