package co.edu.uptc.notificationservice.domain.repository;

import co.edu.uptc.notificationservice.domain.model.ShiftNotification;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ShiftNotificationRepository extends MongoRepository<ShiftNotification, String> {
    List<ShiftNotification> findByUserId(String userId);
    List<ShiftNotification> findByStatus(String status);
}
