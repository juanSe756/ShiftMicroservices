package co.edu.uptc.shiftservice.application.controller;

import co.edu.uptc.shiftservice.application.services.AdminShiftServices;
import co.edu.uptc.shiftservice.application.services.UserShiftServices;
import co.edu.uptc.shiftservice.domain.model.Shift;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/shift")
public class ShiftController {
    @Autowired
    private UserShiftServices userShiftServices;
    @Autowired
    private AdminShiftServices adminShiftServices;
    @PostMapping("/create")
    //@PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<Shift> createShift(@RequestBody Shift shift) {
        Shift newShift = userShiftServices.createShift(shift);
        return new ResponseEntity<>(newShift, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Shift> updateShift(@PathVariable String id, @RequestBody Shift shiftDetails) {
        Optional<Shift> updatedShift = userShiftServices.updateShift(id, shiftDetails);
        return updatedShift.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/get")
    public String getShift() {
        return "Shift retrieved";
    }


    @DeleteMapping("/{id}")
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<HttpStatus> deleteShift(@PathVariable String id) {
        try {
            userShiftServices.deleteShiftById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/delete")
    //@PreAuthorize("hasRole('ROLE_USER')")
    public void deleteShift() {
        //userShiftServices.deleteShift();
    }
}
