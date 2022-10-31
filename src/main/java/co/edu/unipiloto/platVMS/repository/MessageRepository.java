package co.edu.unipiloto.platVMS.repository;

import co.edu.unipiloto.platVMS.entities.Message;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends MongoRepository<Message, String> {
}