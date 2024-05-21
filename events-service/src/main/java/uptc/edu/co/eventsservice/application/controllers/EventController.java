package uptc.edu.co.eventsservice.application.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uptc.edu.co.eventsservice.application.service.command.CreateEventCommand;
import uptc.edu.co.eventsservice.application.service.command.EventCommandService;
import uptc.edu.co.eventsservice.domain.model.Event;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventCommandService commandService;

    @Autowired
    private EventQueryService queryService;

    @PostMapping
    public void createEvent(@RequestBody CreateEventCommand command) {
        commandService.handle(command);
    }

    @GetMapping
    public List<Event> getAllEvents() {
        return queryService.getAllEvents();
    }
}