package co.edu.unipiloto.platVMS.repository;

import co.edu.unipiloto.platVMS.entities.AgenteVial;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgenteVialRepository extends MongoRepository<AgenteVial, String> {
}
