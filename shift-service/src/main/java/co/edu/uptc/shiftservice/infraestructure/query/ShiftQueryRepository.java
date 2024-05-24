package co.edu.uptc.shiftservice.infraestructure.query;

import co.edu.uptc.shiftservice.domain.Shift;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShiftQueryRepository extends MongoRepository<Shift, String> {
}
