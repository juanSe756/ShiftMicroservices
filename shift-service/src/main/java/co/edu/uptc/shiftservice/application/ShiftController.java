package co.edu.uptc.shiftservice.application;

import co.edu.uptc.shiftservice.application.services.AdminShiftServices;
import co.edu.uptc.shiftservice.application.services.UserShiftServices;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shift")
public class ShiftController {
    private UserShiftServices userShiftServices;
    private AdminShiftServices adminShiftServices;
    @GetMapping("/create")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String createShift() {
        return userShiftServices.createShift();
    }
    @GetMapping("/update")
    public String updateShift() {
        return "Shift updated";
    }
    @GetMapping("/get")
    public String getShift() {
        return "Shift retrieved";
    }

    //delete a shift by id
    @GetMapping("delete/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteShift(@PathVariable int id) {
        adminShiftServices.deleteShiftById(id);
    }
    @GetMapping("/delete")
    @PreAuthorize("hasRole('ROLE_USER')")
    public void deleteShift() {
        userShiftServices.deleteShift();
    }
}
