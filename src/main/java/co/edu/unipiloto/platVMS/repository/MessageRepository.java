package co.edu.unipiloto.platVMS.repository;

import co.edu.unipiloto.platVMS.entities.Message;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MessageRepository extends MongoRepository<Message, String> {
}