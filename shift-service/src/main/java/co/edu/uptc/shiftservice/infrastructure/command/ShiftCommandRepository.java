package co.edu.uptc.shiftservice.infrastructure.command;

import co.edu.uptc.shiftservice.domain.Shift;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ShiftCommandRepository extends MongoRepository<Shift, String> {
}
