package mp.CarDatabaseWeek6.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

	// This method selects all owners from db which have given ssn value
	List<Owner> findBySsn(String ssn);

	List<Owner> findByLastName(String lastName);
	
}
