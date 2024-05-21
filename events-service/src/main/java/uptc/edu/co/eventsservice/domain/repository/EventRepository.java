package uptc.edu.co.eventsservice.domain.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import uptc.edu.co.eventsservice.domain.model.Event;

public interface EventRepository extends Neo4jRepository<Event, String> {
}