package mp.CarDatabaseWeek6;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import mp.CarDatabaseWeek6.domain.ApplicationUser;
import mp.CarDatabaseWeek6.domain.ApplicationUserRepository;
import mp.CarDatabaseWeek6.domain.Car;
import mp.CarDatabaseWeek6.domain.CarRepository;
import mp.CarDatabaseWeek6.domain.Owner;
import mp.CarDatabaseWeek6.domain.OwnerRepository;

@SpringBootApplication
public class CarDatabaseWeek6Application {

	private static final Logger log = LoggerFactory.getLogger(SpringBootApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CarDatabaseWeek6Application.class, args);
	}

	@Bean
	public CommandLineRunner demoData(CarRepository carRepository, OwnerRepository ownerRepository,
			ApplicationUserRepository applicationUserRepository) {
		return (args) -> {

			log.info("luodaan pari sovelluksen käyttäjää: toinen admin/admin ja toinen user/user");
			// public ApplicationUser(String firstName, String lastName, String role, String
			// username, String passwordHash)
			ApplicationUser user1 = new ApplicationUser("Otto", "Pellikka", "USER", "user",
					"$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6");
			ApplicationUser user2 = new ApplicationUser("Minna", "Pellikka", "ADMIN", "admin",
					"$2a$08$bCCcGjB03eulCWt3CY0AZew2rVzXFyouUolL5dkL/pBgFkUH9O4J2");
			applicationUserRepository.saveAll(Arrays.asList(user1, user2));

			log.info("save some owners");
			// public Owner(String firstName, String lastName, String city, String ssn, int
			// yob)
			ownerRepository.save(new Owner("Aku", "Ankka", "Ankkalampi", "131240-113A", 1940));
			ownerRepository.save(new Owner("Iines", "Ankka", "Ankkalampi", "131140-113I", 1940));
			ownerRepository.save(new Owner("John", "Johnson", "Helsinki", "111177-134M", 1977));
			ownerRepository.save(new Owner("Kia", "Watson", "Helsinki", "300378-194L", 1978));

			log.info("save some cars");
			// String brand, String model, String color, String registerNumber, double
			// price, int year
			// carRepository.save(new Car("Ford", "Mustang", "Red", "ADF-1121", 59000.00,
			// 2021));
			carRepository.save(new Car("Ford", "Mustang", "Red", "ADF-1121", 59000.00, 2021,
					ownerRepository.findBySsn("111177-134M").get(0)));
			carRepository.save(new Car("Nissan", "Leaf", "White", "SSJ-3002", 29000.00, 2021,
					ownerRepository.findBySsn("111177-134M").get(0)));
			carRepository.save(new Car("Toyota", "Prius", "Silver", "KKO-0212", 39000.00, 2022,
					ownerRepository.findBySsn("300378-194L").get(0)));

			log.info("tulostetaan autot");
			for (Car car : carRepository.findAll()) {
				log.info(car.toString());
			}

		};
	}

}
