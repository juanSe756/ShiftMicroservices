package co.edu.uptc.shiftservice.application.services;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class UserShiftServices {
    public String createShift() {
        return "Shift created";
    }

    public void deleteShift() {
        //TODO: DELETE the user's current shift
    }
}
