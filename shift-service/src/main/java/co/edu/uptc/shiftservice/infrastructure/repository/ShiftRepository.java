package co.edu.uptc.shiftservice.infrastructure.repository;

import co.edu.uptc.shiftservice.domain.model.Shift;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ShiftRepository extends MongoRepository<Shift, String> {
}
