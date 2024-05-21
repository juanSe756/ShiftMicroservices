package co.edu.uptc.notificationservice.domain.service;


import co.edu.uptc.notificationservice.domain.model.ShiftNotification;
import co.edu.uptc.notificationservice.domain.repository.ShiftNotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShiftNotificationService {

    private final ShiftNotificationRepository repository;

    @Autowired
    public ShiftNotificationService(ShiftNotificationRepository repository) {
        this.repository = repository;
    }

    public List<ShiftNotification> getAllNotifications() {
        return repository.findAll();
    }

    public List<ShiftNotification> getNotificationsByUserId(String userId) {
        return repository.findByUserId(userId);
    }

    public ShiftNotification createNotification(ShiftNotification notification) {
        return repository.save(notification);
    }

    public ShiftNotification updateNotification(String id, ShiftNotification notificationDetails) {
        ShiftNotification notification = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Notification not found"));
        notification.setUserId(notificationDetails.getUserId());
        notification.setShiftId(notificationDetails.getShiftId());
        notification.setNotificationType(notificationDetails.getNotificationType());
        notification.setMessage(notificationDetails.getMessage());
        notification.setTimestamp(notificationDetails.getTimestamp());
        notification.setStatus(notificationDetails.getStatus());
        return repository.save(notification);
    }

    public void deleteNotification(String id) {
        repository.deleteById(id);
    }
}
