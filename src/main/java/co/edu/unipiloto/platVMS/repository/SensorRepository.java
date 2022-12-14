package co.edu.unipiloto.platVMS.repository;

import co.edu.unipiloto.platVMS.entities.Sensor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorRepository extends MongoRepository<Sensor, String> {

}
