package mp.CarDatabaseWeek6.web;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import mp.CarDatabaseWeek6.domain.Car;
import mp.CarDatabaseWeek6.domain.CarRepository;



@RestController
public class RestCarController {

	private static final Logger log = LoggerFactory.getLogger(RestCarController.class);
	
	//injektoi repository interface RestCarController-luokalle
	@Autowired
	CarRepository carRepository;

	// return list of cars
	@GetMapping("/cars")
	public Iterable<Car> getCars() { 
		log.info("//fetch and return cars");
		return carRepository.findAll();
	}

	// add new car
	@PostMapping("cars")
	Car newCar(@RequestBody Car newCar) {
		log.info("save new car " + newCar);
		return carRepository.save(newCar);
	}

	// edit existing car information
	@PutMapping("/cars/{id}")
	Car editCar(@RequestBody Car editedCar, @PathVariable Long id) {
		log.info("edit car " + editedCar);
		editedCar.setId(id);
		return carRepository.save(editedCar);
	}

//	// delete car
//	@DeleteMapping("/cars/{id}")
//	void deleteCar(@PathVariable Long id) {
//		carRepository.deleteById(id);
//	}
	
	// delete car
	@DeleteMapping("/cars/{id}")
	public Iterable<Car> deleteCar(@PathVariable Long id) {
		log.info("delete car, id = " + id);
		carRepository.deleteById(id);
		return carRepository.findAll();
	}

	// find one car and return it
	@GetMapping("/cars/{id}")
	Optional<Car> getCar(@PathVariable Long id) {
		log.info("find car, id = " + id);
		return carRepository.findById(id);
	}
}
