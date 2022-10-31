package co.edu.unipiloto.platVMS.repository;

import co.edu.unipiloto.platVMS.entities.Vms;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VmsRepository extends MongoRepository<Vms, String> {
}
