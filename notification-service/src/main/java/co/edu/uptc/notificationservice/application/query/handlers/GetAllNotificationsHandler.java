package co.edu.uptc.notificationservice.application.query.handlers;

import co.edu.uptc.notificationservice.domain.model.ShiftNotification;
import co.edu.uptc.notificationservice.domain.repository.ShiftNotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllNotificationsHandler {

    private final ShiftNotificationRepository repository;

    @Autowired
    public GetAllNotificationsHandler(ShiftNotificationRepository repository) {
        this.repository = repository;
    }

    public List<ShiftNotification> handle() {
        return repository.findAll();
    }
}
