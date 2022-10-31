package co.edu.unipiloto.platVMS.repository;

import co.edu.unipiloto.platVMS.entities.Report;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends MongoRepository<Report, String> {
}