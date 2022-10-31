package co.edu.unipiloto.platVMS.repository;

import co.edu.unipiloto.platVMS.entities.Vms;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VmsRepository extends MongoRepository<Vms, String> {
}
