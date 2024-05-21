package co.edu.uptc.notificationservice.domain.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "shift_notifications")
public class ShiftNotification {

    @Id
    private String id;
    private String userId;
    private String shiftId;
    private String notificationType;
    private String message;
    private Date timestamp;
    private String status;

    public ShiftNotification(String id, String userId, String shiftId, String notificationType, String message, Date timestamp, String status) {
        this.id = id;
        this.userId = userId;
        this.shiftId = shiftId;
        this.notificationType = notificationType;
        this.message = message;
        this.timestamp = timestamp;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getShiftId() {
        return shiftId;
    }

    public void setShiftId(String shiftId) {
        this.shiftId = shiftId;
    }

    public String getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(String notificationType) {
        this.notificationType = notificationType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
