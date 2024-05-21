package co.edu.uptc.shiftservice.infraestructure.query;

import co.edu.uptc.shiftservice.domain.Shift;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ShiftQueryRepository extends MongoRepository<Shift, String> {
}
