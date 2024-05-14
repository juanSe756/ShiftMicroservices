package co.edu.uptc.shiftservice.application;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shift")
public class ShiftController {
    @GetMapping("/create")
    public String createShift() {
        return "Shift created";
    }
    @GetMapping("/delete")
    public String deleteShift() {
        return "Shift deleted";
    }
    @GetMapping("/update")
    public String updateShift() {
        return "Shift updated";
    }
    @GetMapping("/get")
    public String getShift() {
        return "Shift retrieved";
    }
}
