package co.edu.unipiloto.platVMS.repository;

import co.edu.unipiloto.platVMS.entities.Funcionario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends MongoRepository<Funcionario, String> {
}