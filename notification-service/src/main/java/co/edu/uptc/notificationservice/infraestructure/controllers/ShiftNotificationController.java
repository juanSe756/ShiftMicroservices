package co.edu.uptc.notificationservice.infraestructure.controllers;
import co.edu.uptc.notificationservice.application.command.CreateNotificationCommand;
import co.edu.uptc.notificationservice.application.query.handlers.GetAllNotificationsHandler;
import co.edu.uptc.notificationservice.application.query.handlers.GetNotificationsByUserIdHandler;
import co.edu.uptc.notificationservice.domain.model.ShiftNotification;
import co.edu.uptc.notificationservice.domain.service.ShiftNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class ShiftNotificationController {

    private final ShiftNotificationService service;
    private final GetAllNotificationsHandler getAllNotificationsHandler;
    private final GetNotificationsByUserIdHandler getNotificationsByUserIdHandler;

    @Autowired
    public ShiftNotificationController(ShiftNotificationService service,
                                       GetAllNotificationsHandler getAllNotificationsHandler,
                                       GetNotificationsByUserIdHandler getNotificationsByUserIdHandler) {
        this.service = service;
        this.getAllNotificationsHandler = getAllNotificationsHandler;
        this.getNotificationsByUserIdHandler = getNotificationsByUserIdHandler;
    }

    @GetMapping
    public List<ShiftNotification> getAllNotifications() {
        return getAllNotificationsHandler.handle();
    }

    @GetMapping("/user/{userId}")
    public List<ShiftNotification> getNotificationsByUserId(@PathVariable String userId) {
        return getNotificationsByUserIdHandler.handle(userId);
    }

    @PostMapping
    public ShiftNotification createNotification(@RequestBody CreateNotificationCommand command) {
        ShiftNotification notification = new ShiftNotification(
                null, command.getUserId(), command.getShiftId(),
                command.getNotificationType(), command.getMessage(),
                command.getTimestamp(), command.getStatus()
        );
        return service.createNotification(notification);
    }

    @PutMapping("/{id}")
    public ShiftNotification updateNotification(@PathVariable String id, @RequestBody ShiftNotification notificationDetails) {
        return service.updateNotification(id, notificationDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteNotification(@PathVariable String id) {
        service.deleteNotification(id);
    }
}

