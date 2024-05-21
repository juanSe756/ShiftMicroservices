package uptc.edu.co.eventsservice.application.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uptc.edu.co.eventsservice.domain.model.Event;
import uptc.edu.co.eventsservice.domain.repository.EventRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EventQueryService {

    private final EventRepository eventRepository;

    @Autowired
    public EventQueryService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Optional<Event> getEventById(String id) {
        return eventRepository.findById(id);
    }
}
