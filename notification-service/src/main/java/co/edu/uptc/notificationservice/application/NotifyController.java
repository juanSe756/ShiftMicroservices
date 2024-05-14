package co.edu.uptc.notificationservice.application;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notify")
public class NotifyController {
    @GetMapping("/send")
    public String sendNotification() {
        return "Notification sent";
    }
}
