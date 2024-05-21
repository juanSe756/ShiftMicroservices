package uptc.edu.co.eventsservice.application.service.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uptc.edu.co.eventsservice.domain.model.Event;
import uptc.edu.co.eventsservice.domain.repository.EventRepository;

@Service
public class EventCommandService {

    @Autowired
    private EventRepository eventRepository;

    public void handle(CreateEventCommand command) {
        Event event = new Event();
        event.setName(command.getName());
        event.setDescription(command.getDescription());
        eventRepository.save(event);
    }
}

