package co.edu.unipiloto.platVMS.repository;

import co.edu.unipiloto.platVMS.entities.Report;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReportRepository extends MongoRepository<Report, String> {
}